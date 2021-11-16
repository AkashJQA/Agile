package com.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentRep;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String resName = "Test-Report-" + timestamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/" + resName); // location
		// "./test- // path to
		// store the
		// report
		// file
		htmlReporter.loadXMLConfig("C:\\Users\\Admin\\Desktop\\Sdy\\AgileProject\\Config\\extentreportconfig.xml");

		extentRep = new ExtentReports();

		logger.assignAuthor("akash");
		logger.assignCategory("smoke");

		htmlReporter.config().setDocumentTitle("Agile Project");// to sent the tile of report
		htmlReporter.config().setReportName("smoke Test Report"); // name of the report
		htmlReporter.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult tr) {

	//	logger = extentRep.createTest(tr.getName()); // create each passed test new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // Send the passed
																							// information to the report
	}

	public void onTestFailure(ITestResult tr) {
	//	logger = extentRep.createTest(tr.getName()); // crate each failed test entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		try {
	//		logger.addScreenCaptureFromPath(BaseClass.takeScrenshot(driver, tr.getName()));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void onTestSkipped(ITestResult tr) {
	//	logger = extentRep.createTest(tr.getName());// create each skipped test entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext) {
	//) extentRep).flush();
	}

}
