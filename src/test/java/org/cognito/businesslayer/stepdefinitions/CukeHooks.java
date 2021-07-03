package org.cognito.businesslayer.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.cognito.corelayer.FrameworkUtils;
import org.cognito.orchestrationlayer.DriverManager;
import org.cognito.orchestrationlayer.ScenarioContext;
import org.cognito.orchestrationlayer.TestParameters;
import org.junit.Test;

import java.io.IOException;

public class CukeHooks extends FrameworkUtils {


    @Before
    public void setUp(Scenario scenario) {
        TestParameters.setScenario(scenario);
        addStepLog("Execution started for Scenario: " + TestParameters.getScenario().getName());

    }

    @After
    public void tearDown(Scenario scenario) {

        addStepLog("Execution completed for Scenario: " + TestParameters.getScenario().getName() + " and driver closed");
        DriverManager.getInstance().closeDriver();
        TestParameters.getInstance().clearTestParameters();
        ScenarioContext.getInstance().clearScenarioContext();
    }

    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        addScreenshot(scenario);
    }
}
