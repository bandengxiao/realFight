package base;

import lib.getConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


public class baseClass {

    protected WebDriver driver=new ChromeDriver();
    protected WebDriverWait wait;


    public void prepare(String key){
        //这应该做成可配置的
        String url= null;
        try {

            url = getConfig.getValueByKey(key);
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\86157\\Desktop\\GoogleDriver\\chromedriver.exe");
            wait=new WebDriverWait(this.driver,10,1);
            driver.get(url);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean AssertByPageElement(WebDriver driver,String expect,String message){

        String source = driver.getPageSource();
        boolean contains = source.contains(expect);
        return contains;
    }


    public void takeScreenShot(){
        String path=null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String now = format.format(date);
        try {
            String name=this.getClass().getSimpleName();
            path= getConfig.getValueByKey("ScreenShutPath")+"\\"+name+".png";
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(path);
        takeShot((TakesScreenshot)driver,path);

    }

    public void takeShot(TakesScreenshot driver , String path){

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile,new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("截图成功");
        }



    }

    public static void timeOut(int time){

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }






}
