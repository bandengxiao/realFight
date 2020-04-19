package screenshot;


import base.baseClass;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import sun.rmi.runtime.Log;



public class screenshot extends TestListenerAdapter {

    Logger logger= Logger.getLogger(screenshot.class);

    @Override
    public void onTestFailure(ITestResult tr) {
        takeScreenShot(tr);
        super.onTestFailure(tr);

    }

    private void takeScreenShot(ITestResult tr) {
        baseClass b = (baseClass) tr.getInstance();
        // driver = b.driver;
        b.takeScreenShot();
        logger.info(b.getClass().getSimpleName()+"方法执行报错");
    }



    }







