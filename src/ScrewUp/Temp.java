package ScrewUp;

import java.util.TimerTask;

public class Temp extends TimerTask {

    @Override
    public void run() {
        MenuScreen menuScreen = new MenuScreen();
        menuScreen.showMenu();
    }
}
