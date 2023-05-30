package Retry_01;

public class Menu {
    String name;
    String desc;


    Menu() {
    }
    Menu( String name, String desc ) {
        this.name = name;
        this.desc = desc;
    }
    public void showMenu() {
        Menu menu1 = new Menu( "Burgers", "앵거스 비프 통살을 다져만든 버거" );
        Menu menu2 = new Menu( "Frozen Custard", "매장에서 신선하게 만드는 아이스크림" );
        Menu menu3 = new Menu( "Drinks", "매장에서 직접 만드는 음료" );
        Menu menu4 = new Menu( "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주" );
        Menu[] menuArray = { menu1, menu2, menu3, menu4 };

        System.out.println( "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"" );
        System.out.println( "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요." );
        System.out.println();
        System.out.println( "[ SHAKESHACK MENU ]" );

        int menuPartLength = 0;
        for ( int i = 0 ; i < menuArray.length ; i++ ) {
            menuPartLength = Math.max( menuArray[i].name.length(), menuPartLength );
        }
        menuPartLength += 2;
        for ( int i = 0 ; i < menuArray.length ; i++ ) {
            String name = menuArray[i].name;
            String desc = menuArray[i].desc;
            String space = " ".repeat( menuPartLength - name.length() );

            System.out.println( i + 1 + ". " + name + space + "| " + desc );
        }
        System.out.println();
    }


}
