package Retry_01;

import java.util.HashMap;
import java.util.Map;

public class ProductDB {
    public Product[] burgerArr() {
        Product burger1 = new Product( "ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", "Single", 6.9, "Double", 10.9 );
        Product burger2 = new Product( "SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", "Single", 8.9, "Double", 12.9 );
        Product burger3 = new Product( "Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", "oneSize", 9.4 );
        Product burger4 = new Product( "Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", "Single", 6.9, "Double", 10.9 );
        Product burger5 = new Product( "Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", "Single", 5.4, "Double", 9.0 );
        Product[] burgerArr = { burger1, burger2, burger3, burger4, burger5 };
        return burgerArr;
    }
    public Product[] frozenCustardArr() {
        Product frozenCustard1 = new Product( "Shakes", "바닐라, 초콜렛, 솔티드 카라멜, 블랙 & 화이트, 스트로베리, 피넛버터, 커피", "oneSize", 5.9 );
        Product frozenCustard2 = new Product( "Shake of the Week", "특별한 커스터드 플레이버", "oneSize", 6.5 );
        Product frozenCustard3 = new Product( "Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", "oneSize", 6.5 );
        Product frozenCustard4 = new Product( "Floats", "루트 비어, 퍼플 카우, 크림시클", "oneSize", 5.9 );
        Product frozenCustard5 = new Product( "Cups & Cones", "바닐라, 초콜렛, Flavor of the Week", "Single", 4.9, "Double", 5.9 );
        Product[] frozenCustardArr = { frozenCustard1, frozenCustard2, frozenCustard3, frozenCustard4, frozenCustard5 };
        return frozenCustardArr;
    }
    public Product[] drinkArr() {
        Product drink1 = new Product( "Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", "Regular", 3.9, "Large", 4.5 );
        Product drink2 = new Product( "Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", "Regular", 3.4, "Large", 3.9 );
        Product drink3 = new Product( "Fifty / Fifty", "레몬에이드와 아이스티의 만남", "Regular", 3.5, "Large", 4.4 );
        Product drink4 = new Product( "Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", "Regular", 2.7, "Large", 3.3 );
        Product drink5 = new Product( "Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 탄산음료", "oneSize", 4.4 );
        Product[] drinkArr = { drink1, drink2, drink3, drink4, drink5 };
        return drinkArr;
    }
    public Product[] beerArr() {
        Product beer1 = new Product( "ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", "oneSize", 9.8 );
        Product beer2 = new Product( "Magpie Brewing Co.", "Pale Ale, Draft", "oneSize", 6.8 );
        Product[] beerArr = { beer1, beer2 };
        return beerArr;
    }


    public Menu[] menuArr() {
        Menu menu1 = new Menu( "Burgers", "앵거스 비프 통살을 다져만든 버거" );
        Menu menu2 = new Menu( "Frozen Custard", "매장에서 신선하게 만드는 아이스크림" );
        Menu menu3 = new Menu( "Drinks", "매장에서 직접 만드는 음료" );
        Menu menu4 = new Menu( "Beers", "뉴욕 브루클린 브루어리에서 양조한 맥주" );
        Menu[] menuArr = { menu1, menu2, menu3, menu4 };
        return menuArr;
    }


    public Map< String, Product[] > menuMap() {
        Menu[] menuArr = menuArr();
        Map< String, Product[] > menuMap = new HashMap<>();
        menuMap.put( menuArr[0].name, burgerArr() );
        menuMap.put( menuArr[1].name, frozenCustardArr() );
        menuMap.put( menuArr[2].name, drinkArr() );
        menuMap.put( menuArr[3].name, beerArr() );
        return menuMap;
    }

}
