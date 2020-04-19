package testCase;


import base.baseClass;
import com.thoughtworks.selenium.ScreenshotListener;
import org.jboss.netty.util.Timeout;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.purchasePage;
import screenshot.screenshot;

@Listeners(screenshot.class)
public class purchase extends baseClass {


    @Test
    public void pursechase() {

        purchasePage p=new purchasePage();

        try {
            p.base();
            p.buy();
            p.choose();
            p.pay();
            p.checkHistory();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
