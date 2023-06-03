package Retry_01;

import java.util.*;

public class Order {
    List< Product > orderList = new ArrayList<>();
    Map< String, Integer > countMap = new HashMap<>();

    // 장바구니를 보여준다.
    public void showOrder() {
        System.out.println( "아래와 같이 주문 하시겠습니까?\n" );
        System.out.println( "[ Orders ]" );
        makeList( orderList );
        System.out.println();
        System.out.println( "[ Total ]" );
        System.out.println( "W " + getSum( orderList ) + "\n" );
        System.out.println( "1. 주문        2. 메뉴판" );
        System.out.println( "---------------------------------------------" );
    }

    // Product가 담긴 List를 입력하면 Product의 가격의 합을 출력해준다.
    public double getSum( List< Product > list ) {
        double sum = 0;
        for ( Product product : list ) {
            double price = product.op1_price;
            int count = countMap.get( product.name ).intValue();
            sum += price * count;
        }
        return Math.round( sum * 10 ) / 10.0;
    }

    // 장바구니에 Product를 담아주는 메서드
    public void addOrder( Product element ) {

        // 장바구니에 이미 같은 물건이 담겨 있는지 확인한다.
        int count = 0;
        for ( int i = 0 ; i < orderList.size() ; i++ ) {
            if ( orderList.get( i ).name.equals( element.name ) ) {
                count++;
            }
        }

        // 만약 같은 물건이 담겨 있다면 장바구니에 Product를 추가해주고,
        // countMap(K:상품, V:갯수인 Map)에 Product의 이름과 1(1개)을 추가해준다.
        // 같은 물건이 담겨 있지 않다면 countMap에 Product의 이름과 1을 추가해주는 메서드 addCount()를 호출한다.
        if ( count == 0 ) {
            orderList.add( element );
            countMap.put( element.name, 1 );
        } else {
            addCount( element );
        }

        System.out.println( element.name + " 가 장바구니에 추가되었습니다." );
        System.out.println( "---------------------------------------------" );
    }

    // List< Product> 를 입력하면 sout해주는 메서드
    private void makeList( List< Product > list ) {
        for ( int i = 0 ; i < list.size() ; i++ ) {
            String name = list.get( i ).name;
            double price = list.get( i ).op1_price;
            String desc = list.get( i ).desc;
            Integer count = countMap.get( name );
            String space = " ".repeat( Product.menuPartLength( list ) - name.length() );

            System.out.println( ( i + 1 ) + ". " + name + space + "| W " + price + " | " + count + "개 | " + desc );
        }
    }

    // 상품을 넣으면 countMap에서 상품에 맞는 value값(갯수)을 찾아 갯수를 더하기 1 해주는 메서드
    private void addCount( Product product ) {
        int add = countMap.get( product.name ).intValue() + 1;
        countMap.put( product.name, add );
    }
}
