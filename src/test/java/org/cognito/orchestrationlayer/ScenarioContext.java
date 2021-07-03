package org.cognito.orchestrationlayer;

import org.cognito.orchestrationlayer.enums.TestData;

import java.util.HashMap;

public class ScenarioContext {

    public static ThreadLocal<HashMap<TestData, Object>> scenarioContext = new ThreadLocal<HashMap<TestData, Object>>() {
        protected HashMap<TestData, Object> initialValue() {
            return new HashMap<>();
        }
    };

    public ScenarioContext() {
    }

    private final static ScenarioContext instance = new ScenarioContext();

    public static ScenarioContext getInstance() {
        return ScenarioContext.instance;
    }

    public void setScenarioContext(TestData key, Object value) {
        scenarioContext.get().put(key, value);
    }

    public  Object getScenarioContext(TestData key) {
        return scenarioContext.get().get(key);
    }

    public void clearScenarioContext(){
        scenarioContext.get().clear();
    }

}
