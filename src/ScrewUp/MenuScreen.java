package ScrewUp;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuScreen extends DBMenu {
    List< String > name = super.name;
    Map< String, String > menuDescription = super.menuDescription;
    int menuStringSize = getMenuStringSize( name );
    Scanner sc = new Scanner( System.in );
    ProductScreen productScreen = new ProductScreen();
    CartScreen cartScreen = new CartScreen();

    public void showMenu() {

        System.out.println( "\"SHAKESHACK BURGER 에 오신 걸 환영합니다.\"" );
        System.out.println( "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요." );
        System.out.println();
        ///////////////////
        System.out.println( "[ SHAKESHACK MENU ]" );
        for ( int i = 1 ; i <= name.size() ; i++ ) {
            String menu = name.get( i - 1 );
            System.out.println( i + ". " + menu + " ".repeat( menuStringSize - menu.length() ) + "| " + menuDescription.get( menu ) );
        }
        System.out.println();
        ///////////////////
        System.out.println( "[ ORDER MENU ]" );
        System.out.println( "5. " + "Order" + " ".repeat( menuStringSize - 5 ) + "| " + "장바구니를 확인 후 주문합니다." );
        System.out.println( "6. " + "Cancel" + " ".repeat( menuStringSize - 6 ) + "| " + "진행중인 주문을 취소합니다." );
        int choose = sc.nextInt();
        if ( choose <= name.size() ) {
            productScreen.showProduct( choose );
        } else if ( choose == name.size() + 1 ) {
            cartScreen.showCart();
        } else {
            if ( cartScreen.list == null ) {
                System.out.println( "취소할 주문이 없습니다. 메뉴로 이동합니다." );
                System.out.println( "------------------------------------------" );
                showMenu();
            } else {
                System.out.println( "진행하던 주문을 취소하시겠습니까?" );
                System.out.println( "1. 확인        2. 취소" );
                int num = sc.nextInt();
                if ( num == 1 ) {
                    cartScreen.list.clear();
                    cartScreen.price.clear();
                    cartScreen.desc.clear();
                    showMenu();
                } else {
                    showMenu();
                }
            }
        }
    }

}
