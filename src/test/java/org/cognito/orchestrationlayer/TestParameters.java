package org.cognito.orchestrationlayer;

import io.cucumber.java.Scenario;
import org.cognito.orchestrationlayer.enums.Browser;
import org.cognito.orchestrationlayer.enums.ExecutionMode;

import java.util.HashMap;

public class TestParameters {

    public TestParameters() {
    }

    private final static TestParameters instance = new TestParameters();

    public static TestParameters getInstance() {
        return TestParameters.instance;
    }


    public static ThreadLocal<HashMap<String, Object>> parameters = new ThreadLocal<HashMap<String, Object>>() {
        @Override
        protected HashMap<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    public static void setBrowser(Browser browser) {
        parameters.get().put("browser", browser);
    }

    public static void setExecutionMode(ExecutionMode executionMode) {
        parameters.get().put("executionMode", executionMode);
    }

    public static void setScenario(Scenario scenario) {
        parameters.get().put("scenario", scenario);
    }

    public static Browser getBrowser() {
        return (Browser) parameters.get().get("browser");
    }

    public static ExecutionMode getExecutionMode() {
        return (ExecutionMode) parameters.get().get("executionMode");
    }

    public static Scenario getScenario() {
        return (Scenario) parameters.get().get("scenario");
    }

    public void clearTestParameters(){
        parameters.get().clear();
    }

}
