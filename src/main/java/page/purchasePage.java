package page;

import base.baseClass;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import lib.getConfig;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class purchasePage extends baseClass {

    //飞机票页面跳转按钮
    By flight=By.xpath("/html/body/center/center/a[1]");

    By findFlight= By.xpath("/html/body/h1/font/b");

    By DepartureCity=By.name("depart");

    By arrived=By.name("arrive");

    By numPassengers=By.name("numPassengers");

    By departDate=By.name("departDate");

    By returnDate=By.name("returnDate");

    By seatType=By.name("seatType");

    By seatPref=By.name("seatPref");

    By findFlights=By.name("findFlights");

    By outboundFlight=By.name("outboundFlight");

    By reserveFlights=By.name("reserveFlights");

    By payDetail=By.xpath("/html/body/h1/font/b");

    By firstName=By.name("firstName");

    By lastName=By.name("lastName");

    By address1=By.name("address1");

    By address2=By.name("address2");

    By pass1=By.name("pass1");

    By pass2=By.name("pass2");

    By creditCard=By.name("creditCard");

    By buyFlights=By.name("buyFlights");

    By thankYou=By.xpath("/html/body/blockquote/center/small/b");

    By one=By.name("1");

    By ltinerary=By.xpath("/html/body/center/center/a[2]/img");

    By total=By.xpath("/html/body/blockquote/form/center/table[1]/tbody/tr[5]/td/b");

    By removeFlights=By.name("removeFlights");




    public void base() throws InterruptedException {

        prepare("loginPage");

        driver.switchTo().frame(driver.findElement(By.name("body")));
        driver.switchTo().frame(driver.findElement(By.name("navbar")));
        driver.findElement(By.name("username")).sendKeys("root");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.name("login")).click();

        timeOut(2000);

        driver.switchTo().defaultContent();
        //driver.switchTo().frame(driver.findElement(By.name("navbar")));
        driver.switchTo().frame(driver.findElement(By.name("body")));
        driver.switchTo().frame(driver.findElement(By.name("navbar")));
        driver.findElement(flight).click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(findFlight));
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.name("body")));
        driver.switchTo().frame(driver.findElement(By.name("info")));
        driver.findElement(findFlight);
        String text = driver.findElement(findFlight).getText();
        Assert.assertEquals(text,"Find Flight","切换机票购买机票失败");


    }


    public void buy(){

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(DepartureCity));
        Select depart=new Select(driver.findElement(DepartureCity));
        depart.selectByValue("London");
        Select arrive=new Select(driver.findElement(arrived));
        arrive.selectByValue("Paris");
        driver.findElement(numPassengers).clear();
        driver.findElement(numPassengers).sendKeys("2");
        Calendar cal=Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        Integer month=cal.get(Calendar.MONTH);
        Integer day=cal.get(Calendar.DATE);
        String goDate=day.toString()+"/"+month.toString()+"/"+day.toString();
        driver.findElement(departDate).sendKeys(goDate);
        cal.add(Calendar.DATE,+1);
        Integer backYear = cal.get(Calendar.YEAR);
        Integer backMonth=cal.get(Calendar.MONTH);
        Integer backDay=cal.get(Calendar.DATE);
        String backDate=backDay.toString()+"/"+backMonth.toString()+"/"+backYear.toString();
        driver.findElement(returnDate).sendKeys(backDate);

        List<WebElement> SeatType = driver.findElements(seatType);
        for (WebElement element : SeatType) {
            if(element.getAttribute("value").equals("Business")){
                element.click();
                break;
            }
            else {
                continue;
            }

        }

        List<WebElement> seatPrefer = driver.findElements(seatPref);
        for (WebElement element : seatPrefer) {
            if (element.getAttribute("value").equals("Window")){
                element.click();
                break;
            }
            else{
                continue;
            }
        }
        driver.findElement(findFlights).click();


        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.name("body")));
        driver.switchTo().frame(driver.findElement(By.name("info")));
        String text = driver.findElement(By.xpath("/html/body/blockquote/form/center/blockquote/b[1]")).getText();

        Assert.assertEquals(text,"London","选票跳转失败");

    }


    public void choose(){

        List<WebElement> elements = driver.findElements(outboundFlight);
        for (WebElement element : elements) {

            if (element.getAttribute("value").equals("241;140;04/20/2020")){
                element.click();
                break;
            }
            else{
                continue;
            }

        }
        driver.findElement(reserveFlights).click();
        String text = driver.findElement(payDetail).getText();
        Assert.assertEquals(text,"Payment Details","选票方法错误");


    }


    public void pay(){

        driver.findElement(firstName).sendKeys("zhou");
        driver.findElement(lastName).sendKeys("wang");
        driver.findElement(address1).sendKeys("beijing");
        driver.findElement(address2).sendKeys("hebei");
        driver.findElement(pass1).sendKeys("zhou");
        driver.findElement(pass2).sendKeys("wang");
        driver.findElement(creditCard).sendKeys("125445566321");
        driver.findElement(buyFlights).click();
        String text = driver.findElement(thankYou).getText();
        Assert.assertEquals(text,"Thank you for booking through Web Tours.","付款失败");


    }


    public void checkHistory() throws InterruptedException {

        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("navbar");
        driver.findElement(ltinerary).click();

        timeOut(2000);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("info");
        driver.findElement(one).click();
        String text = driver.findElement(total).getText();
        Assert.assertEquals(text,"A total of 1 scheduled flights.","未成功跳转到查看已定机票界面");
        driver.findElement(removeFlights).click();


    }







}
