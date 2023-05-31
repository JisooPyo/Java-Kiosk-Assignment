package Retry_01;

import java.util.List;

public class Order {
    ProductDB productDB = new ProductDB();
    static List< Product > orderList;

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
        switch ( first ) {
            case 1: {
                orderList.add( productDB.burgerArr[second - 1] );
                break;
            }
            case 2: {
                orderList.add( productDB.frozenCustardArr[second - 1] );
                break;
            }
            case 3: {
                orderList.add( productDB.drinkArr[second - 1] );
                break;
            }
            case 4: {
                orderList.add( productDB.beerArr[second - 1] );
                break;
            }
        }


    }

    public void makeList( List< Product > productList ) {
        for ( int i = 0 ; i < productList.size() ; i++ ) {
            String name = productList.get( i ).name;
            String desc = productList.get( i ).desc;
            double price = productList.get( i ).price;

            String space = " ".repeat( menuPartLength( productList ) - name.length() );

            System.out.println( i + 1 + ". " + name + space + "| W " + price + " | " + desc );
        }
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
        return sum;
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
            }
            case 2: {
                name = productDB.frozenCustardArr[second - 1].name;
                price = productDB.frozenCustardArr[second - 1].price;
                desc = productDB.frozenCustardArr[second - 1].desc;
            }
            case 3: {
                name = productDB.drinkArr[second - 1].name;
                price = productDB.drinkArr[second - 1].price;
                desc = productDB.drinkArr[second - 1].desc;
            }
            case 4: {
                name = productDB.beerArr[second - 1].name;
                price = productDB.beerArr[second - 1].price;
                desc = productDB.beerArr[second - 1].desc;
            }
        }
        System.out.println( name + "  | W " + price + " | " + desc );
    }

    public void buyOrder(){

    }
}
