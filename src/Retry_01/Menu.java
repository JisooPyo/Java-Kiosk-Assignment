package Retry_01;

public class Menu {
    ProductDB productDB = new ProductDB();
    String name;
    String desc;

    Menu() {
    }

    Menu( String name, String desc ) {
        this.name = name;
        this.desc = desc;
    }

    public void showMenu() {
        Menu[] menuArr = productDB.menuArr();
        System.out.println( "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"" );
        System.out.println( "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요." );
        System.out.println();
        System.out.println( "[ SHAKESHACK MENU ]" );

        makeList( menuArr );

        System.out.println( "\n[ ORDER MENU ]" );
        System.out.println( "5. Order          | 장바구니를 확인 후 주문합니다." );
        System.out.println( "6. Cancel         | 진행중인 주문을 취소합니다." );
        System.out.println( "7. Off the KIOSK  | 키오스크를 종료합니다. ");
    }
    public int menuPartLength( Menu[] menuArray ) {
        int menuPartLength = 0;
        for ( int i = 0 ; i < menuArray.length ; i++ ) {
            menuPartLength = Math.max( menuArray[i].name.length(), menuPartLength );
        }
        menuPartLength += 2;
        return menuPartLength;
    }
    public void makeList( Menu[] menuArray ) {
        for ( int i = 0 ; i < menuArray.length ; i++ ) {
            String name = menuArray[i].name;
            String desc = menuArray[i].desc;
            String space = " ".repeat( menuPartLength( menuArray ) - name.length() );

            System.out.println( i + 1 + ". " + name + space + "| " + desc );
        }
    }


}
