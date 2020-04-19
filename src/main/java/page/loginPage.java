package page;

import base.baseClass;
import lib.getConfig;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;


public class loginPage extends baseClass {

    //登录按钮
    By loginButton=By.name("login");
    //用户名输入框
    By userName=By.name("username");
    //密码输入框
    By password=By.name("password");
    //获取首页文字
    By welcome=By.xpath("/html/body");
    //用户名
    String loginUserName="root";
    //密码
    String loginPassword="123";

    //获取全局logger对象
    Logger logger=Logger.getLogger(loginPage.class);



    //登录
    public String login(){

        prepare("loginPage");

        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(getConfig.getValueByKey("frameTotal"));
            driver.switchTo().frame(getConfig.getValueByKey("frameLeft"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(userName));
        driver.findElement(userName).sendKeys(loginUserName);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(password));
        driver.findElement(password).sendKeys(loginPassword);

        System.out.println(driver.getPageSource()+"前面");
        driver.findElement(loginButton).click();


        return"success";

    }



    //获取login页面welecome元素
    public String getElementOfLoginPage(){

        try {

            driver.switchTo().defaultContent();
            driver.switchTo().frame(getConfig.getValueByKey("frameTotal"));
            driver.switchTo().frame(getConfig.getValueByKey("frameRight"));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(welcome));
            //获取标签内包含文字
            String text = driver.findElement(welcome).getText();
            if (text.contains("Welcome")){
                logger.debug("获取login页面Welcome文字成功");
                return "Welcome";
            }
            else {
                logger.debug("获取login页面Welcome文字失败");
                return "failure";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.debug("获取login页面Welcome文字失败");
        return "failure";

    }





}
