package ScrewUp;

import ScrewUp.CartScreen;
import ScrewUp.MenuScreen;
import ScrewUp.ProductScreen;

import java.util.Scanner;

public class BuyScreen extends ProductScreen {
    public void buyCheck( int choose, int pick ) {
        Scanner sc = new Scanner( System.in );
        CartScreen cartScreen = new CartScreen();
        ProductScreen productScreen = new ProductScreen();
        MenuScreen menuScreen = new MenuScreen();
        switch ( choose ) {
            case 1:
                printFirstLine( burger, pick );
                break;
            case 2:
                printFirstLine( forzenCustard, pick );
                break;
            case 4:
                printFirstLine( beer, pick );
                break;
        }
        System.out.println( "위 메뉴를 장바구니에 추가하시겠습니까?" );
        System.out.println( "1. 확인        2. 취소" );
        int add = sc.nextInt();
        if ( add == 1 ) {
            cartScreen.addCart( choose, pick, 0 );
            String menu = "";
            switch ( choose ) {
                case 1:
                    menu += "Hamburger";
                case 2:
                    menu += "Forzen Custard";
                case 4:
                    menu += "Beer";
            }
            System.out.println( menu + " 가 장바구니에 추가되었습니다." );
            menuScreen.showMenu();
        } else {
            productScreen.showProduct( choose );
        }
    }

    public void buyDrinkCheck( int pick, int size ) {
        Scanner sc = new Scanner( System.in );
        CartScreen cartScreen = new CartScreen();
        ProductScreen productScreen = new ProductScreen();
        MenuScreen menuScreen = new MenuScreen();
        if ( pick <= 4 ) {
            char ch = size == 1 ? 'R' : 'L';
            String price = size == 1 ? drinkSizePrice[pick - 1][2] : drinkSizePrice[pick - 1][4];
            System.out.println( pick + ". " + drinkDescription[pick - 1][0] + " | " + ch + " | W " + price );
        } else {
            String price = drinkSizePrice[pick - 1][1];
            System.out.println( pick + ". " + drinkDescription[pick - 1][0] + " | " + " | W " + price );
        }
        System.out.println( "위 메뉴를 장바구니에 추가하시겠습니까?" );
        System.out.println( "1. 확인        2. 취소" );
        int add = sc.nextInt();
        if ( add == 1 ) {
            cartScreen.addCart( 3, pick, size );
            System.out.println( "Drink 가 장바구니에 추가되었습니다." );
            menuScreen.showMenu();
        } else {
            productScreen.showProduct( 3 );
        }

    }

    public void printFirstLine( String[][] menu, int pick ) {
        System.out.println( pick + ". " + menu[pick - 1][0]
                + " ".repeat( menuSize( menu ) - menu[pick - 1][0].length() )
                + "| W " + menu[pick - 1][1] + " | " + menu[pick - 1][2] );
    }

}
