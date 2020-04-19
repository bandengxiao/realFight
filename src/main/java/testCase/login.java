package testCase;

import base.baseClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.loginPage;
import screenshot.screenshot;

@Listeners(screenshot.class)
public class login extends baseClass {




    @Test
    public void login() throws InterruptedException {

        loginPage login=new loginPage();
        login.login();
        String text = login.getElementOfLoginPage();

        Assert.assertEquals(text,"Welcome","登录成功");

    }






}
