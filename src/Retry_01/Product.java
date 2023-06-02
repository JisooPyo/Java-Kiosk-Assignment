package Retry_01;

import java.util.Map;
import java.util.Scanner;

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

    private int menuPartLength( Product[] productArr ) {
        int menuPartLength = 0;
        for ( int i = 0 ; i < productArr.length ; i++ ) {
            menuPartLength = Math.max( productArr[i].name.length(), menuPartLength );
        }
        menuPartLength += 2;
        return menuPartLength;
    }

    private void makeList( Product[] productArr ) {
        for ( int i = 0 ; i < productArr.length ; i++ ) {
            String name = productArr[i].name;
            String desc = productArr[i].desc;
            double price = productArr[i].op1_price;
            String space = " ".repeat( menuPartLength( productArr ) - name.length() );

            System.out.println( i + 1 + ". " + name + space + "| W " + price + " | " + desc );
        }
    }


    public String[] pickProduct( int menu, int detailMenu ) {
        Scanner sc = new Scanner( System.in );

        Menu[] menuArr = productDB.menuArr();
        Product product = productDB.menuMap().get( menuArr[menu - 1].name )[detailMenu - 1];
        String[] arr;

        if ( !( product.op1.equals( "oneSize" ) ) ) {
            String op1 = product.op1;
            String op1_price = Double.toString( product.op1_price );
            String op2 = product.op2;
            String op2_price = Double.toString( product.op2_price );
            System.out.println( product.name + "  | W " + op1_price + " | " + product.desc );
            System.out.println( "위 메뉴의 어떤 옵션으로 추가하시겠습니까?" );
            System.out.println( "1. " + op1 + "(W " + op1_price + ")        2. " + op2 + "(W " + op2_price + ")" );

            int pickOp = sc.nextInt();
            if ( pickOp == 1 ) {
                arr = new String[] { product.name + "(" + op1 + ")", op1_price, product.desc, "1" };
            } else {
                arr = new String[] { product.name + "(" + op2 + ")", op2_price, product.desc, "1" };
            }
        } else {
            arr = new String[] { product.name, Double.toString( product.op1_price ), product.desc, "1" };
        }
        System.out.println( arr[0] + "  | W " + arr[1] + " | " + arr[2] );
        System.out.println( "위 메뉴를 장바구니에 추가하시겠습니까?" );
        System.out.println( "1. 확인        2. 취소" );

        return arr;
    }

}
