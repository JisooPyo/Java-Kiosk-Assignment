package ScrewUp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;

public class CartScreen extends BuyScreen {
    List< String > list;
    Map< String, String > price;
    Map< String, String > desc;

    public void addCart( int choose, int pick, int size ) {
        List< String > list = new ArrayList<>();
        Map< String, String > price = new HashMap<>();
        Map< String, String > desc = new HashMap<>();
        list.add( makeName( choose, pick, size ) );
        price.put( makeName( choose, pick, size ), makePrice( choose, pick, size ) );
        desc.put( makeName( choose, pick, size ), makeDesc( choose, pick, size ) );
        System.out.println( list );
        this.list = list;
        this.price = price;
        this.desc = desc;

    }

    public void showCart() {
        Scanner sc = new Scanner( System.in );
        Timer t = new Timer( true );
        MenuScreen menuScreen = new MenuScreen();
        if ( list == null ) {
            System.out.println( "장바구니에 담아 놓은 것이 없습니다. 메뉴로 이동합니다." );
            System.out.println( "-------------------------------------------------------" );
            menuScreen.showMenu();
        }
        System.out.println( "아래와 같이 주문하시겠습니까?" );
        double sum = 0;
        for ( int i = 0 ; i < list.size() ; i++ ) {
            String str = list.get( i );
            System.out.println( ( i + 1 ) + ". " + str + " ".repeat( menuSize( list ) - str.length() )
                    + "| W " + price.get( str ) + " | " + desc.get( str ) );
            sum += Integer.parseInt( price.get( str ) );
        }
        System.out.println();
        System.out.println( "[ Total ]" );
        System.out.println( "W " + sum );
        System.out.println();
        System.out.println( "1. 주문        2. 메뉴판" );
        int check = sc.nextInt();
        if ( check == 1 ) {
            list.clear();
            price.clear();
            desc.clear();
            System.out.println( "주문이 완료되었습니다!" );
            System.out.println();
            System.out.println( "대기번호는 [ 1 ] 번 입니다." );
            System.out.println( "(3초후 메뉴판으로 돌아갑니다.)" );
            Temp temp = new Temp();
            t.schedule( temp, 3000 );
            temp.run();
        } else {
            menuScreen.showMenu();
        }
    }

    public String makeName( int choose, int pick, int size ) {
        String menuName = "";
        if ( choose == 1 ) {
            menuName += burger[pick - 1][0];
        } else if ( choose == 2 ) {
            menuName += forzenCustard[pick - 1][0];
        } else if ( choose == 4 ) {
            menuName += beer[pick - 1][0];
        } else if ( choose == 3 && ( size == 1 || size == 2 ) ) {
            String sizeCheck = size == 1 ? "R" : "L";
            menuName += drinkDescription[pick - 1][0] + " [ " + sizeCheck + " ]";
        } else {
            menuName += drinkDescription[pick - 1][0];
        }
        return menuName;
    }

    public String makePrice( int choose, int pick, int size ) {
        String menuPrice = "";
        if ( choose == 1 ) {
            menuPrice += burger[pick - 1][1];
        } else if ( choose == 2 ) {
            menuPrice += forzenCustard[pick - 1][1];
        } else if ( choose == 4 ) {
            menuPrice += beer[pick - 1][1];
        } else if ( choose == 3 && ( size == 1 || size == 2 ) ) {
            if ( size == 1 ) {
                menuPrice += drinkSizePrice[pick - 1][2];
            } else {
                menuPrice += drinkSizePrice[pick - 1][4];
            }
        } else {
            menuPrice += drinkSizePrice[pick - 1][1];
        }
        return menuPrice;
    }

    public String makeDesc( int choose, int pick, int size ) {
        String menuDesc = "";
        if ( choose == 1 ) {
            menuDesc += burger[pick - 1][2];
        } else if ( choose == 2 ) {
            menuDesc += forzenCustard[pick - 1][2];
        } else if ( choose == 4 ) {
            menuDesc += beer[pick - 1][2];
        } else {
            menuDesc += drinkDescription[pick - 1][1];
        }
        return menuDesc;
    }

    public int menuSize( List< String > list ) {
        int ans = 0;
        for ( int i = 0 ; i < list.size() ; i++ ) {
            ans = Math.max( list.get( i ).length(), ans );
        }
        return ans;
    }
}

