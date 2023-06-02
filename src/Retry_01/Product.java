package Retry_01;

import java.util.Map;

public class Product extends Menu {
    String op1;
    double op1_price;
    String op2;
    double op2_price;

    Product() {
    }

    Product( String name, String desc, String op1, double op1_price ) {
        super.name = name;
        super.desc = desc;
        this.op1 = op1;
        this.op1_price = op1_price;
    }

    Product( String name, String desc, String op1, double op1_price, String op2, double op2_price ) {
        this.name = name;
        this.desc = desc;
        this.op1 = op1;
        this.op1_price = op1_price;
        this.op2 = op2;
        this.op2_price = op2_price;
    }

    public void showProduct( int menu ) {
        System.out.println( "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"" );
        System.out.println( "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요." );
        System.out.println();
        String pickMenu = productDB.menuArr()[menu - 1].name;
        Product[] productArr = productDB.menuMap().get( pickMenu );
        System.out.println( "[ " + pickMenu + " MENU ]" );
        makeList( productArr );
    }

    public int menuPartLength( Product[] productArr ) {
        int menuPartLength = 0;
        for ( int i = 0 ; i < productArr.length ; i++ ) {
            menuPartLength = Math.max( productArr[i].name.length(), menuPartLength );
        }
        menuPartLength += 2;
        return menuPartLength;
    }

    public void makeList( Product[] productArr ) {
        for ( int i = 0 ; i < productArr.length ; i++ ) {
            String name = productArr[i].name;
            String desc = productArr[i].desc;
            double price = productArr[i].op1_price;
            String space = " ".repeat( menuPartLength( productArr ) - name.length() );

            System.out.println( i + 1 + ". " + name + space + "| W " + price + " | " + desc );
        }
    }

}
