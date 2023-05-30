package Retry_01;

import java.util.Scanner;

public class Kiosk {
    Menu menu = new Menu();
    Order order = new Order();
    Product product = new Product();
    Scanner sc = new Scanner( System.in );

    Kiosk() {
        menu.showMenu();
        order.showOrder();
        int first = sc.nextInt();
        if ( first <= 4 ) {
            product.showProduct( first );
        } else {

        }

    }

}