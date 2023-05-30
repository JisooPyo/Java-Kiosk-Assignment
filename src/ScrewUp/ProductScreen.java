package ScrewUp;

import java.util.Scanner;

public class ProductScreen extends DBProduct {



    public void showProduct( int choose ) {
        Scanner sc = new Scanner( System.in );
        BuyScreen buyScreen = new BuyScreen();
        MenuScreen menuScreen = new MenuScreen();

        System.out.println( "SHAKESHACK BURGER 에 오신걸 환영합니다." );
        System.out.println( "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요." );
        System.out.println();

        switch ( choose ) {
            case 1:
                showBurger();
                break;
            case 2:
                showForzenCustard();
                break;
            case 3:
                showDrink();
                break;
            case 4:
                showBeer();
                break;
            default:
                System.out.println( "잘못 선택하셨습니다." );
                menuScreen.showMenu();
                break;
        }
        int pick = sc.nextInt();
        if ( choose == 3 ) {
            if ( pick <= 4 ) {
                System.out.println( "1, 2 중에 하나를 골라 입력해주세요." );
                System.out.println( pick + ". 1) R | W " + drinkSizePrice[pick - 1][2] );
                System.out.println( pick + ". 2) L | W " + drinkSizePrice[pick - 1][4] );
                int size = sc.nextInt();
                buyScreen.buyDrinkCheck( pick, size );
            } else {
                System.out.println( pick + ". | W " + drinkSizePrice[pick - 1][1] );
                int size = 0;
                buyScreen.buyDrinkCheck( pick, size );
            }
        } else {
            buyScreen.buyCheck( choose, pick );

        }

    }

    void showBurger() {
        System.out.println( "[ Burgers Menu ]" );
        for ( int i = 0 ; i < burger.length ; i++ ) {
            System.out.println( ( i + 1 ) + ". " + burger[i][0]
                    + " ".repeat( menuSize( burger ) - burger[i][0].length() )
                    + "| W " + burger[i][1] + " | " + burger[i][2] );
        }
    }

    void showForzenCustard() {
        System.out.println( "[ Forzen Custard Menu ]" );
        for ( int i = 0 ; i < forzenCustard.length ; i++ ) {
            System.out.println( ( i + 1 ) + ". " + forzenCustard[i][0]
                    + " ".repeat( menuSize( forzenCustard ) - forzenCustard[i][0].length() )
                    + "| W " + forzenCustard[i][1] + " | " + forzenCustard[i][2] );
        }
    }

    void showDrink() {
        System.out.println( "[ Drinks Menu ]" );
        for ( int i = 0 ; i < drinkDescription.length ; i++ ) {
            System.out.println( ( i + 1 ) + ". " + drinkDescription[i][0]
                    + " ".repeat( menuSize( drinkDescription ) - drinkDescription[i][0].length() )
                    + "| " + drinkDescription[i][1] );
        }
    }

    void showBeer() {
        System.out.println( "[ Beer Menu ]" );
        for ( int i = 0 ; i < beer.length ; i++ ) {
            System.out.println( ( i + 1 ) + ". " + beer[i][0]
                    + " ".repeat( menuSize( beer ) - beer[i][0].length() )
                    + "| W " + beer[i][1] + " | " + beer[i][2] );
        }
    }

    static int menuSize( String[][] menu ) {
        int menuSize = 0;
        for ( int i = 0 ; i < menu.length ; i++ ) {
            menuSize = Math.max( menu[i][0].length(), menuSize );
        }
        menuSize += 2;
        return menuSize;
    }

}

