package Retry_01;

import java.util.Scanner;

public class Kiosk {
    Menu menu = new Menu();
    Order order = new Order();
    Product product = new Product();
    Scanner sc = new Scanner( System.in );

    Kiosk() {
        menuScreen();
    }

    public void menuScreen() {
        menu.showMenu();
        int first = sc.nextInt();
        if ( first <= 4 ) {
            productScreen( first );
        } else if ( first == 5 ) {
            if ( order.orderList == null ) {
                System.out.println( "장바구니에 담은 상품이 없습니다. 다시 메뉴판으로 이동합니다." );
                menuScreen();
            } else {
                orderScreen();
            }
        } else {
            cancleScreen();
        }
    }

    public void productScreen( int first ) {
        product.showProduct( first );
        int second = sc.nextInt();
        order.checkorder( first, second );
        int checknum = sc.nextInt();
        if ( checknum == 1 ) {
            order.addOrder( first, second );
            menuScreen();
        } else {
            product.showProduct( first );
        }
    }

    public void orderScreen() {
        order.showOrder();
        int confirmOrder = sc.nextInt();
        if (confirmOrder==1){
            System.out.println("주문이 완료되었습니다!\n");
            System.out.println("대기번호는 [ 1 ] 번 입니다.");
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.");
            try {
                Thread.sleep( 3000 );
            } catch ( InterruptedException e ) {
                throw new RuntimeException( e );
            }
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
        } else {
            menuScreen();
        }
    }



}