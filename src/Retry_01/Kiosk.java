package Retry_01;

import java.util.Scanner;

public class Kiosk {
    Menu menu = new Menu();
    Order order = new Order();
    Product product = new Product();
    Scanner sc = new Scanner( System.in );
    double totalSales;

    Kiosk() {
        menuScreen();
    }

    public void menuScreen() {
        menu.showMenu();
        int menu = sc.nextInt();
        switch ( menu ) {
            case 0: totalSalesScreen(); break;
            case 1: case 2: case 3: case 4:
                productScreen( menu );
                break;
            case 5: {
                if ( order.orderList.size() == 0 ) {
                    System.out.println( "장바구니에 담은 상품이 없습니다. 다시 메뉴판으로 이동합니다." );
                    menuScreen();
                } else {
                    orderScreen();
                }
                break;
            }
            case 6:{
                if ( order.orderList.size() == 0 ) {
                    System.out.println( "취소할 주문이 없습니다. 메뉴판으로 이동합니다.\n" );
                    menuScreen();
                } else {
                    cancleScreen();
                }
                break;
            }
            default:{
                System.out.println( "옵션을 잘못 선택하였습니다. 다시 골라주세요.\n" );
                menuScreen();
            }
        }

    }

    public void productScreen( int menu ) {
        product.showProduct( menu );
        int detailMenu = sc.nextInt();
        String[] arr = order.pickProduct( menu, detailMenu );
        int checknum = sc.nextInt();
        if ( checknum == 1 ) {
            order.addOrder( arr );
            menuScreen();
        } else {
            productScreen( menu );
        }
    }

    public void orderScreen() {
        order.showOrder();
        int confirmOrder = sc.nextInt();
        if ( confirmOrder == 1 ) {
            for ( String[] strArr : order.orderList ) {
                order.totalProductList.put( strArr[0], strArr[1] );
            }
            System.out.println( "주문이 완료되었습니다!\n" );
            System.out.println( "대기번호는 [ 1 ] 번 입니다." );
            System.out.println( "(3초 후 메뉴판으로 돌아갑니다.)\n" );
            try {
                Thread.sleep( 3000 );
            } catch ( InterruptedException e ) {
                throw new RuntimeException( e );
            }
            totalSales += order.getSum( order.orderList );
            order.orderList.clear();
            menuScreen();
        } else {
            menuScreen();
        }
    }

    public void cancleScreen() {
        System.out.println( "진행하던 주문을 취소하시겠습니까?" );
        System.out.println( "1. 확인        2. 취소" );
        int cancelpick = sc.nextInt();
        if ( cancelpick == 1 ) {
            order.orderList.clear();
            System.out.println( "진행하던 주문이 취소되었습니다." );
            menuScreen();
        } else {
            menuScreen();
        }
    }

    public void totalSalesScreen() {
        System.out.println( "[ 총 판매금액 현황 ]" );
        System.out.println( "현재까지 총 판매된 금액은 [ W " + Math.round( totalSales * 10 ) / 10.0 + " ] 입니다.\n" );
        System.out.println( "[ 총 판매상품 목록 현황 ]" );
        System.out.println( "현재까지 총 판매된 상품 목록은 아래와 같습니다." );
        int keyLen = 0;
        for ( String key : order.totalProductList.keySet() ) {
            keyLen = Math.max( key.length(), keyLen );
        }
        keyLen += 2;
        for ( String key : order.totalProductList.keySet() ) {
            String value = order.totalProductList.get( key );
            String space = " ".repeat( keyLen - key.length() );
            System.out.println( "- " + key + space + "| W " + value );
        }

        System.out.println( "\n1. 돌아가기" );
        int back = sc.nextInt();
        if ( back == 1 ) {
            menuScreen();
        } else {
            System.out.println( "잘못된 값을 입력하였습니다.\n" );
            totalSalesScreen();
        }

    }


}