package Retry_01;

public class ProductDB {
    static Product burgers1 = new Product( "ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", new String[] { "Single", "6.9" }, new String[] { "Double", "10.9" } );
    static Product burgers2 = new Product( "SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", new String[] { "Single", "8.9" }, new String[] { "Double", "12.9" } );
    static Product burgers3 = new Product( "Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", new String[] { "oneSize", "9.4" } );
    static Product burgers4 = new Product( "Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", new String[] { "Single", "6.9" }, new String[] { "Double", "10.9" } );
    static Product burgers5 = new Product( "Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", new String[] { "Single", "5.4" }, new String[] { "Double", "9.0" } );

    static Product frozenCustard1 = new Product( "Shakes", "바닐라, 초콜렛, 솔티드 카라멜, 블랙 & 화이트, 스트로베리, 피넛버터, 커피", new String[] { "oneSize", "5.9" } );
    static Product frozenCustard2 = new Product( "Shake of the Week", "특별한 커스터드 플레이버", new String[] { "oneSize", "6.5" } );
    static Product frozenCustard3 = new Product( "Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", new String[] { "oneSize", "6.5" } );
    static Product frozenCustard4 = new Product( "Floats", "루트 비어, 퍼플 카우, 크림시클", new String[] { "oneSize", "5.9" } );
    static Product frozenCustard5 = new Product( "Cups & Cones", "바닐라, 초콜렛, Flavor of the Week", new String[] { "Single", "4.9" }, new String[] { "Double", "5.9" } );

    static Product drinks1 = new Product( "Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", new String[] { "Regular", "3.9" }, new String[] { "Large", "4.5" } );
    static Product drinks2 = new Product( "Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", new String[] { "Regular", "3.4" }, new String[] { "Large", "3.9" } );
    static Product drinks3 = new Product( "Fifty / Fifty", "레몬에이드와 아이스티의 만남", new String[] { "Regular", "3.5" }, new String[] { "Large", "4.4" } );
    static Product drinks4 = new Product( "Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", new String[] { "Regular", "2.7" }, new String[] { "Large", "3.3" } );
    static Product drinks5 = new Product( "Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 탄산음료", new String[] { "oneSize", "4.4" } );

    static Product beer1 = new Product( "ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", new String[] { "oneSize", "9.8" } );
    static Product beer2 = new Product( "Magpie Brewing Co.", "Pale Ale, Draft", new String[] { "oneSize", "6.8" } );

    static Product[] burgerArr = { burgers1, burgers2, burgers3, burgers4, burgers5 };
    static Product[] frozenCustardArr = { frozenCustard1, frozenCustard2, frozenCustard3, frozenCustard4, frozenCustard5 };
    static Product[] drinkArr = { drinks1, drinks2, drinks3, drinks4, drinks5 };
    static Product[] beerArr = { beer1, beer2 };

    static Menu menu1 = new Menu( "Burgers", "앵거스 비프 통살을 다져만든 버거" );
    static Menu menu2 = new Menu( "Frozen Custard", "매장에서 신선하게 만드는 아이스크림" );
    static Menu menu3 = new Menu( "Drinks", "매장에서 직접 만드는 음료" );
    static Menu menu4 = new Menu( "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주" );
    static Menu[] menuArray = { menu1, menu2, menu3, menu4 };
}
