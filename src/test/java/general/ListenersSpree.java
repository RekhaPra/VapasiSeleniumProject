package general;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersSpree implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("The Test Case "+result.getName()+" has started");
        // BaseTest.takeScreenShot(driver);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("The Test Case "+result.getName()+" has successfully completed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("The Test Case "+result.getName()+" has failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("The Test Case "+result.getName()+" is skipped");
    }

}
