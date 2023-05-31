package Retry_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    ProductDB productDB = new ProductDB();
    static List< Product > orderList = new ArrayList<>();

    public void showOrder() {

        System.out.println( "아래와 같이 주문 하시겠습니까?\n" );
        System.out.println( "[ Orders ]" );
        makeList( orderList );
        System.out.println();
        System.out.println( "[ Total ]" );
        System.out.println( "W " + getSum( orderList ) + "\n" );
        System.out.println( "1. 주문        2. 메뉴판" );
    }

    public void addOrder( int first, int second ) {
        String name = "";
        switch ( first ) {
            case 1: {
                orderList.add( productDB.burgerArr[second - 1] );
                name = productDB.burgerArr[second - 1].name;
                break;
            }
            case 2: {
                orderList.add( productDB.frozenCustardArr[second - 1] );
                name = productDB.frozenCustardArr[second - 1].name;
                break;
            }
            case 3: {
                orderList.add( productDB.drinkArr[second - 1] );
                name = productDB.drinkArr[second - 1].name;
                break;
            }
            case 4: {
                orderList.add( productDB.beerArr[second - 1] );
                name = productDB.beerArr[second - 1].name;
                break;
            }
        }
        System.out.println( name + " 가 장바구니에 추가되었습니다.\n" );
    }

    public void makeList( List< Product > productList ) {
        List< Product > distinct = productList.stream().distinct().collect( Collectors.toList() );
        int[] count = countList( productList );

        for ( int i = 0 ; i < distinct.size() ; i++ ) {
            String name = distinct.get( i ).name;
            String desc = distinct.get( i ).desc;
            double price = distinct.get( i ).price;
            int num = count[i];

            String space = " ".repeat( menuPartLength( productList ) - name.length() );

            System.out.println( name + space + "| W " + price + " | " + num + "개 | " + desc );
        }
    }

    public int[] countList( List< Product > productList ) {
        List< Product > distinct = productList.stream().distinct().collect( Collectors.toList() );
        int[] count = new int[distinct.size()];
        Arrays.fill( count, 0 );

        for ( int i = 0 ; i < distinct.size() ; i++ ) {
            for ( int j = 0 ; j < productList.size() ; j++ ) {
                if ( distinct.get( i ).equals( productList.get( j ) ) ) {
                    count[i]++;
                }
            }
        }

        return count;
    }

    public int menuPartLength( List< Product > productList ) {
        int menuPartLength = 0;
        for ( int i = 0 ; i < productList.size() ; i++ ) {
            menuPartLength = Math.max( productList.get( i ).name.length(), menuPartLength );
        }
        menuPartLength += 2;
        return menuPartLength;
    }

    public double getSum( List< Product > productList ) {
        double sum = 0;
        for ( Product p : productList ) {
            sum += p.price;
        }
        return Math.round( sum * 10 ) / 10.0;
    }

    public void checkorder( int first, int second ) {
        String name = "";
        double price = 0;
        String desc = "";
        switch ( first ) {
            case 1: {
                name = productDB.burgerArr[second - 1].name;
                price = productDB.burgerArr[second - 1].price;
                desc = productDB.burgerArr[second - 1].desc;
                break;
            }
            case 2: {
                name = productDB.frozenCustardArr[second - 1].name;
                price = productDB.frozenCustardArr[second - 1].price;
                desc = productDB.frozenCustardArr[second - 1].desc;
                break;
            }
            case 3: {
                name = productDB.drinkArr[second - 1].name;
                price = productDB.drinkArr[second - 1].price;
                desc = productDB.drinkArr[second - 1].desc;
                break;
            }
            case 4: {
                name = productDB.beerArr[second - 1].name;
                price = productDB.beerArr[second - 1].price;
                desc = productDB.beerArr[second - 1].desc;
                break;
            }
        }
        System.out.println( name + "  | W " + price + " | " + desc );
        System.out.println( "위 메뉴를 장바구니에 추가하시겠습니까?" );
        System.out.println( "1. 확인        2. 취소" );
    }
}
