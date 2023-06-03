package Retry_01;

import java.util.List;
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


    // 상품 목록을 보여준다.
    public void showProduct( int menu ) {
        System.out.println( "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"" );
        System.out.println( "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요." );
        System.out.println();
        String pickMenu = productDB.menuList().get( menu - 1 ).name;
        List< Product > productList = productDB.menuMap().get( pickMenu );
        System.out.println( "[ " + pickMenu + " MENU ]" );
        makeList( productList );
        System.out.println( "---------------------------------------------" );
    }

    // 상품 목록의 이름 부분의 길이를 정하는 메서드이다.
    // 가장 길이가 긴 상품명에 +2
    static int menuPartLength( List< Product > productList ) {
        int menuPartLength = 0;
        for ( int i = 0 ; i < productList.size() ; i++ ) {
            menuPartLength = Math.max( productList.get( i ).name.length(), menuPartLength );
        }
        menuPartLength += 2;
        return menuPartLength;
    }

    // List<Product>를 for문을 돌려 sout 해주는 메서드
    private void makeList( List< Product > productList ) {
        for ( int i = 0 ; i < productList.size() ; i++ ) {
            String name = productList.get( i ).name;
            String desc = productList.get( i ).desc;
            double price = productList.get( i ).op1_price;
            String space = " ".repeat( menuPartLength( productList ) - name.length() );

            System.out.println( i + 1 + ". " + name + space + "| W " + price + " | " + desc );
        }
    }

    // 옵션이 있다면 옵션을 고르고 옵션이 없다면 그대로 주문하고 옵션과 가격이 달라진 상품을 리턴해주는 메서드
    public Product pickProduct( int menu, int detailMenu ) {
        Scanner sc = new Scanner( System.in );

        // 고객이 고른 상품
        List< Menu > menuList = productDB.menuList();
        Product product = productDB.menuMap().get( menuList.get( menu - 1 ).name ).get( detailMenu - 1 );

        String name = product.name;
        String desc = product.desc;
        double price;

        // 상품의 op1이 oneSize가 아니라면(옵션이 한 개만 있는 상품은 op1을 oneSize로 설정함.
        if ( !( product.op1.equals( "oneSize" ) ) ) {

            System.out.println( name + "  | W " + product.op1_price + " | " + product.desc );
            System.out.println( "위 메뉴의 어떤 옵션으로 추가하시겠습니까?" );
            System.out.println( "1. " + product.op1 + "(W " + product.op1_price + ")        2. " + product.op2 + "(W " + product.op2_price + ")" );
            System.out.println( "---------------------------------------------" );
            int pickOp = sc.nextInt();

            if ( pickOp != 1 && pickOp != 2 ) {
                System.out.println( "잘못된 옵션을 선택하셨습니다. 다시 선택해 주세요." );
                System.out.println( "---------------------------------------------" );
                pickProduct( menu, detailMenu );
            }
            // 선택한 옵션에 따라 상품의 이름, 가격이 바뀐다.
            name = pickOp == 1 ? name + "(" + product.op1 + ")" : name + "(" + product.op2 + ")";
            price = pickOp == 1 ? product.op1_price : product.op2_price;
        } else {
            price = product.op1_price;
        }

        Product element = new Product( name, desc, "", price );

        System.out.println( name + "  | W " + price + " | " + desc );
        System.out.println( "위 메뉴를 장바구니에 추가하시겠습니까?" );
        System.out.println( "1. 확인        2. 취소" );
        System.out.println( "---------------------------------------------" );

        return element;
    }

}
