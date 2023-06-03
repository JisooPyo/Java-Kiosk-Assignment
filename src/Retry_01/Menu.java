package Retry_01;

import java.util.List;

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

    // 처음 켰을 때의 카테고리를 보여준다.
    public void showMenu() {

        List< Menu > menuList = productDB.menuList();
        System.out.println( "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"" );
        System.out.println( "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요." );
        System.out.println();
        System.out.println( "[ SHAKESHACK MENU ]" );

        makeList( menuList );

        System.out.println( "\n[ ORDER MENU ]" );
        System.out.println( "5. Order          | 장바구니를 확인 후 주문합니다." );
        System.out.println( "6. Cancel         | 진행중인 주문을 취소합니다." );
        System.out.println( "7. Off the KIOSK  | 키오스크를 종료합니다. " );
        System.out.println("---------------------------------------------");
    }

    // 카테고리를 보여줄 때 이름 부분의 길이를 정하는 메소드이다.
    private int menuPartLength( List< Menu > menuList ) {
        int menuPartLength = 0;
        for ( int i = 0 ; i < menuList.size() ; i++ ) {
            menuPartLength = Math.max( menuList.get( i ).name.length(), menuPartLength );
        }
        menuPartLength += 2;
        return menuPartLength;
    }

    // 메뉴리스트들을 받았을 때 그 메뉴리스트들로 리스트를 sout해주는 메서드
    private void makeList( List< Menu > menuList ) {
        for ( int i = 0 ; i < menuList.size() ; i++ ) {
            String name = menuList.get( i ).name;
            String desc = menuList.get( i ).desc;
            String space = " ".repeat( menuPartLength( menuList ) - name.length() );

            System.out.println( i + 1 + ". " + name + space + "| " + desc );
        }
    }


}
