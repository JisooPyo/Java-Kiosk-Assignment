package Retry_01;

public class Product extends Menu {
    String name;
    String desc;
    String[] op1;
    String[] op2;

    Product() {
    }

    Product( String name, String desc, String[] op1, String[] op2 ) {
        this.name = name;
        this.desc = desc;
        this.op1 = op1;
        this.op2 = op2;
    }

    Product( String name, String desc, String[] op1 ) {
        this.name = name;
        this.desc = desc;
        this.op1 = op1;
    }

    public void showProduct( int first ) {
        System.out.println( "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"" );
        System.out.println( "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요." );
        System.out.println();

        switch ( first ) {
            case 1: {
                System.out.println( "[ Burgers MENU ]" );
                makeList( productDB.burgerArr );
                break;
            }
            case 2: {
                System.out.println( "[ FrozenCustard MENU ]" );
                makeList( productDB.frozenCustardArr );
                break;
            }
            case 3: {
                System.out.println( "[ Drinks MENU ]" );
                makeList( productDB.drinkArr );
                break;
            }
            case 4: {
                System.out.println( "[ Beers MENU ]" );
                makeList( productDB.beerArr );
                break;
            }
        }
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
            String price = productArr[i].op1[1];
            String space = " ".repeat( menuPartLength( productArr ) - name.length() );

            System.out.println( i + 1 + ". " + name + space + "| W " + price + " | " + desc );
        }
    }

}
