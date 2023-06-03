package Retry_01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Kiosk {
    Menu menu = new Menu();
    Order order = new Order();
    Product product = new Product();
    ProductDB productDB = new ProductDB();
    Map< String, String > totalOrderList = new HashMap<>(); // 총 판매 상품 리스트
    Scanner sc = new Scanner( System.in );
    double totalSales; // 총 판매금액
    int waitingNum = 1; // 대기번호

    // 키오스크를 켜면 menuScreen()으로 가게 된다.
    public void onKiosk() {
        menuScreen();
    }

    // 메뉴 화면
    public void menuScreen() {
        menu.showMenu();
        int menu = sc.nextInt();
        // 처음 선택한 번호에 따라 각 번호에 맞는 화면 메서드로 이동한다.
        switch ( menu ) {
            case 0:
                totalSalesScreen();
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                productScreen( menu );
                break;
            case 5: {
                if ( order.orderList.size() == 0 ) {
                    System.out.println( "장바구니에 담은 상품이 없습니다. 다시 메뉴판으로 이동합니다." );
                    System.out.println( "---------------------------------------------" );
                    menuScreen();
                } else {
                    orderScreen();
                }
                break;
            }
            case 6: {
                if ( order.orderList.size() == 0 ) {
                    System.out.println( "취소할 주문이 없습니다. 메뉴판으로 이동합니다." );
                    System.out.println( "---------------------------------------------" );
                    menuScreen();
                } else {
                    cancelScreen();
                }
                break;
            }
            case 7: {
                offKiosk();
                break;
            }
            default: {
                System.out.println( "옵션을 잘못 선택하였습니다. 다시 골라주세요." );
                System.out.println( "---------------------------------------------" );
                menuScreen();
                break;
            }
        }

    }

    // 상품 화면
    public void productScreen( int menu ) {
        // 상품을 보여준다.
        product.showProduct( menu );
        int detailMenu = sc.nextInt();

        // 고른 상품 목록(ex. burgerList)을 호출.
        String pickMenu = productDB.menuList().get( menu - 1 ).name;
        List< Product > productList = productDB.menuMap().get( pickMenu );
        Product element = new Product();

        // 고른 상품 목록의 크기 안에서 선택하면 장바구니에 추가할 것인지 물어보는 메서드로 넘어감.
        // 그 외 번호를 입력하면 잘못되었다고 출력하고 다시 productScreen()으로 되돌아 옴.
        if ( 1 <= detailMenu && detailMenu <= productList.size() ) {
            element = product.pickProduct( menu, detailMenu );
        } else {
            System.out.println( "잘못 선택하셨습니다. 다시 선택해 주세요." );
            System.out.println( "---------------------------------------------" );
            productScreen( menu );
        }

        int checknum = sc.nextInt();

        // 1. 예 : 장바구니에 추가, 2. 아니오 : 다시 productScreen()으로 되돌아 옴.
        // 그 외 : 잘못되었다 출력하고 productScreen()으로 되돌아 옴.
        if ( checknum == 1 ) {
            order.addOrder( element );
            menuScreen();
        } else if ( checknum == 2 ) {
            productScreen( menu );
        } else {
            System.out.println( "잘못 선택하셨습니다. 상품 화면으로 돌아갑니다." );
            System.out.println( "---------------------------------------------" );
            productScreen( menu );
        }
    }

    // 주문 화면(장바구니)
    public void orderScreen() {
        order.showOrder();

        int confirmOrder = sc.nextInt();

        // 1. 예 : 주문완료. 총 판매 목록에 상품의 이름과 설명을 올리고,
        // 총 판매 금액에 주문했던 상품들의 금액을 더해준다.
        // 장바구니를 비워주고 다시 menuScreen()으로.
        // 2. 아니오 : menuScreen()으로
        // 그 외 : 잘못 선택했다는 것을 알려주고 다시 orderScreen()으로 되돌아오기
        if ( confirmOrder == 1 ) {

            for ( Product product : order.orderList ) {
                totalOrderList.put( product.name, product.desc );
            }
            System.out.println( "주문이 완료되었습니다!\n" );
            System.out.println( "대기번호는 [ " + waitingNum + " ] 번 입니다." );
            waitingNum++;
            System.out.println( "(3초 후 메뉴판으로 돌아갑니다.)" );
            System.out.println( "---------------------------------------------" );
            try {
                Thread.sleep( 3000 );
            } catch ( InterruptedException e ) {
                throw new RuntimeException( e );
            }
            totalSales += order.getSum( order.orderList );
            order.orderList.clear();
            menuScreen();

        } else if ( confirmOrder == 2 ) {

            menuScreen();

        } else {

            System.out.println( "잘못 선택하셨습니다. 다시 선택해주세요." );
            System.out.println( "---------------------------------------------" );
            orderScreen();

        }
    }

    // 주문취소 화면
    public void cancelScreen() {
        System.out.println( "진행하던 주문을 취소하시겠습니까?" );
        System.out.println( "1. 확인        2. 취소" );
        System.out.println( "---------------------------------------------" );

        int cancelpick = sc.nextInt();

        // 1. 주문취소 : 장바구니를 비워주고 menuScreen()으로
        // 2. 주문취소X : menuScreen()으로
        // 그 외 : 잘못 입력하였다는 걸 알려주고 cancelScreen()으로 되돌아오기
        if ( cancelpick == 1 ) {
            order.orderList.clear();
            System.out.println( "진행하던 주문이 취소되었습니다." );
            System.out.println( "---------------------------------------------" );
            menuScreen();
        } else if ( cancelpick == 2 ) {
            menuScreen();
        } else {
            System.out.println( "잘못 선택하셨습니다. 다시 선택해 주세요." );
            System.out.println( "---------------------------------------------" );
            cancelScreen();
        }
    }

    // 총 판매가격과 총 판매 물품들을 보여주는 화면
    public void totalSalesScreen() {
        System.out.println( "[ 총 판매금액 현황 ]" );
        System.out.println( "현재까지 총 판매된 금액은 [ W " + Math.round( totalSales * 10 ) / 10.0 + " ] 입니다.\n" );
        System.out.println( "[ 총 판매상품 목록 현황 ]" );
        System.out.println( "현재까지 총 판매된 상품 목록은 아래와 같습니다." );

        // 총 판매상품 목록에서 메뉴 이름 부분의 길이를 정하는 부분
        int keyLen = 0;
        for ( String key : totalOrderList.keySet() ) {
            keyLen = Math.max( key.length(), keyLen );
        }
        keyLen += 2;

        // 총 판매 목록 출력
        for ( String key : totalOrderList.keySet() ) {
            String value = totalOrderList.get( key );
            String space = " ".repeat( keyLen - key.length() );
            System.out.println( "- " + key + space + "| " + value );
        }
        System.out.println( "\n1. 돌아가기" );
        System.out.println( "---------------------------------------------" );

        int back = sc.nextInt();

        // 1. : menuScreen()으로 돌아가기
        // 2. : 잘못된 값을 입력하였다고 알려주고 다시 totalSalesScreen()으로 되돌아오기
        if ( back == 1 ) {
            menuScreen();
        } else {
            System.out.println( "잘못된 값을 입력하였습니다." );
            System.out.println( "---------------------------------------------" );
            totalSalesScreen();
        }

    }

    // 키오스크를 끄는 메서드.
    public void offKiosk() {
        System.out.println( "키오스크를 종료하시겠습니까?" );
        System.out.println( "1. 네        2. 아니오" );
        System.out.println( "---------------------------------------------" );
        int offNum = sc.nextInt();
        if ( offNum == 1 ) {
            System.out.println( "키오스크를 종료합니다." );
            System.out.println( "---------------------------------------------" );
        } else if ( offNum == 2 ) {
            menuScreen();
        } else {
            System.out.println( "잘못된 값을 입력하였습니다." );
            System.out.println( "---------------------------------------------" );
            offKiosk();
        }
    }
}