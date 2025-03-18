package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ListenersClass implements ITestListener {

	ExtentReports report;// generating reports
	ExtentTest test;// handling all the test cases

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName + " test case executed");
		
		test = report.startTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
		test.log(LogStatus.PASS, methodName+" pass");
		report.endTest(test);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(result.getThrowable().toString());
		GenericUtilities gu = new GenericUtilities();

		String path = "C:\\Users\\ALINA\\eclipse-workspace\\Testing\\Vtiger\\src\\test\\resources\\defectimages\\Vtiger_"
				+ methodName + "_" + gu.currentDate() + ".jpg";
		//gu.captureScreenshot(BaseClass.sdriver, path);
		test.log(LogStatus.FAIL, test.addScreenCapture(gu.captureScreenshot(BaseClass.sdriver, path)));
		
		report.endTest(test);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName + " test case Skipped");
		//Reporter.log(result.getThrowable().toString());
		
		test.log(LogStatus.SKIP, methodName);
		
		report.endTest(test);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("----Execution Started-----");
		report = new ExtentReports("./reports/extentReport_Vtiger.html");
		
		report.addSystemInfo("OS","Windows 11");
		report.addSystemInfo("browser","chrome");
		report.addSystemInfo("User Name","Alina");
		report.addSystemInfo("Project Name","Vtiger");
		report.addSystemInfo("BaseUrl","http://localhost:8888/");
		report.addSystemInfo("username","admin");
		report.addSystemInfo("password","admin");
		

	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("----Execution Finished-----");
		report.flush();

	}

}
