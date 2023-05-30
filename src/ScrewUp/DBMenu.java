package ScrewUp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBMenu {
    List< String > name;
    Map< String, String > menuDescription;

    DBMenu() {
        List< String > name = new ArrayList<>();
        name.add( "Burgers" );
        name.add( "Frozen Custard" );
        name.add( "Drinks" );
        name.add( "Beer" );
        this.name = name;

        Map< String, String > menuDescription = new HashMap<>();
        menuDescription.put( "Burgers", "앵거스 비프 통살을 다져만든 버거" );
        menuDescription.put( "Frozen Custard", "매장에서 신선하게 만드는 아이스크림" );
        menuDescription.put( "Drinks", "매장에서 직접 만드는 음료" );
        menuDescription.put( "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주" );
        this.menuDescription = menuDescription;

    }

    int getMenuStringSize( List< String > name ) {
        int menuStringSize = 0;
        for ( int i = 0 ; i < name.size() ; i++ ) {
            menuStringSize = Math.max( name.get( i ).length(), menuStringSize );
        }
        menuStringSize += 2;
        return menuStringSize;
    }
}
