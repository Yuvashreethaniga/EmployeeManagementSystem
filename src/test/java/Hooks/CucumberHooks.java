package Hooks;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import extentReport.ExtentReportManager;
import io.cucumber.java.Before;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import io.cucumber.java.*;


import static io.restassured.RestAssured.baseURI;

public class CucumberHooks {

    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> scenarioThread = new ThreadLocal<>();
    @Before
    public  void setup() {
        baseURI="http://127.0.0.1:8000";
    }

    @Before
    public void ExecuteFirst(){
        System.out.println("This will be executed first of the all");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest test = extent.createTest(scenario.getName());
        scenarioThread.set(test);
    }
    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            scenarioThread.get().log(Status.FAIL, "Step failed");
        } else {
            scenarioThread.get().log(Status.PASS, "Step passed");
        }
    }

    @After
    public void afterScenario() {
        extent.flush();
    }
}
