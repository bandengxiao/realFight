package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screenshot.screenshot;

@Listeners(screenshot.class)
public class main {


    @Test
    public void test(){



        System.out.println(main.class.getClass().getSimpleName());


    }
}
