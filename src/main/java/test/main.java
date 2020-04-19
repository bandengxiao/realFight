package test;

import javafx.scene.chart.PieChart;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screenshot.screenshot;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;


public class main {


    @Test
    public void test(){

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\86157\\Desktop\\GoogleDriver\\chromedriver.exe");
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://127.0.0.1:1080/WebTours/");
//        driver.get("https://etms.e-yuntong.com/home");
//        Cookie c1=new Cookie("ETMS_ACCESS_TOKEN","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoibWFkZSBieSBldG1zIiwidXNlcl9uYW1lIjoiMTU3MzI2NDMzMzMiLCJzY29wZSI6WyJzZXJ2ZXIiXSwiYWN0aXZlIjp0cnVlLCJleHAiOjE1ODczMjM1MjAsImRlcHRfaWQiOm51bGwsInVzZXJJZCI6ODU0LCJhdXRob3JpdGllcyI6WyIxX0ZPUldBUkRFUl9BRE1JTiJdLCJqdGkiOiIyMjViYTc1OS1kYzM5LTQ0YWMtOWZjNS1hMmJhNTdiZDE2YjMiLCJjbGllbnRfaWQiOiJldG1zIiwidXNlcm5hbWUiOiIxNTczMjY0MzMzMyJ9.q9-hHxLcO9_Y30lrCZzVbttBu0a8kSCdFvYN8WDV2_c");
//        Cookie c2=new Cookie("ETMS_REFRESH_TOKEN","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoibWFkZSBieSBldG1zIiwidXNlcl9uYW1lIjoiMTU3MzI2NDMzMzMiLCJzY29wZSI6WyJzZXJ2ZXIiXSwiYXRpIjoiMjI1YmE3NTktZGMzOS00NGFjLTlmYzUtYTJiYTU3YmQxNmIzIiwiYWN0aXZlIjp0cnVlLCJleHAiOjE1ODk4NzIzMjAsImRlcHRfaWQiOm51bGwsInVzZXJJZCI6ODU0LCJhdXRob3JpdGllcyI6WyIxX0ZPUldBUkRFUl9BRE1JTiJdLCJqdGkiOiIxMmZiMjQzNi0yOTgwLTRhNjMtODQ2Ni1jNDg4MmViMTlmNGMiLCJjbGllbnRfaWQiOiJldG1zIiwidXNlcm5hbWUiOiIxNTczMjY0MzMzMyJ9.cKYGIIS-M7F49rzxqn1cINkHZJGXb3EI5NY21B1qIb4");
//        Cookie c3=new Cookie("U_INFO","eyJmb3J3YXJkZXJJbmZvIjp7Im9yZ2FuaXphdGlvbklkIjoxMjEsIm9yZ2FuaXphdGlvbk5hbWUiOiLljJfkuqzmtYvor5UifSwiY29tcGFueUluZm8iOm51bGx9");
//        Cookie c4=new Cookie("U_ORG_ID","eyJjdXJyZW50Rm9yZ0lkIjoxMjEsImN1cnJlbnRGb3JnTmFtZSI6IuWMl+S6rOa1i+ivlSJ9");
//        driver.manage().addCookie(c1);
//        driver.manage().addCookie(c2);
//        driver.manage().addCookie(c3);
//        driver.manage().addCookie(c4);
//        driver.get("https://etms.e-yuntong.com/home");


        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);

        System.out.println(day+"  "+month+"   "+year);









    }
}
