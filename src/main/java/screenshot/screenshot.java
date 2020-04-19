package screenshot;


import base.baseClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class screenshot extends TestListenerAdapter {



    @Override
    public void onTestFailure(ITestResult tr) {
        takeScreenShot(tr);
        super.onTestFailure(tr);

    }

    private void takeScreenShot(ITestResult tr) {
        baseClass b = (baseClass) tr.getInstance();
        // driver = b.driver;
        b.takeScreenShot();
    }



    }







