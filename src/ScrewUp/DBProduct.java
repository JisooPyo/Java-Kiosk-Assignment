package ScrewUp;

public class DBProduct {
    String[][] burger;
    String[][] forzenCustard;
    String[][] drinkDescription;
    String[][] drinkSizePrice;
    String[][] beer;

    DBProduct() {
        String[][] burger = new String[][] {
                { "ShackBurger", "6.9", "토마토, 양상추 쉑소스가 토핑된 치즈버거" },
                { "SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거" },
                { "Shroom Burger", "9.4", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거" },
                { "Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거" },
                { "Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"}
        };
        this.burger = burger;

        String[][] forzenCustard = new String[][] {
                { "Shakes", "5.9", "바닐라, 초콜렛, 솔티드 카라멜, 블랙 & 화이트, 스트로베리, 피넛버터, 커피" },
                { "Shake of the Week", "6.5", "특별한 커스터드 플레이버" },
                { "Red Bean Shake", "6.5", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크" },
                { "Floats", "5.9", "루트 비어, 퍼플 카우, 크림시클" }
        };
        this.forzenCustard = forzenCustard;

        String[][] drinkDescription = new String[][] {
                { "Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드(오리지날/시즈널)" },
                { "Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티" },
                { "Fifty / Fifty", "레몬에이드와 아이스티의 만남" },
                { "Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프" },
                { "Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 탄산음료" },
                { "Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수" }
        };
        this.drinkDescription = drinkDescription;

        String[][] drinkSizePrice = new String[][] {
                { "Shack-made Lemonade", "R", "3.9", "L", "4.5" },
                { "Fresh Brewed Iced Tea", "R", "3.4", "L", "3.9" },
                { "Fifty / Fifty", "R", "3.5", "L", "4.4" },
                { "Fountain Soda", "R", "2.7", "L", "3.3" },
                { "Abita Root Beer", "4.4" },
                { "Bottled Water", "1.0" }
        };
        this.drinkSizePrice = drinkSizePrice;

        String[][] beer = new String[][] {
                { "ShackMeister Ale", "9.8", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주" },
                { "Magpie Brewing Co.", "6.8", "Pale Ale, Draft" }
        };
        this.beer = beer;


    }

}
