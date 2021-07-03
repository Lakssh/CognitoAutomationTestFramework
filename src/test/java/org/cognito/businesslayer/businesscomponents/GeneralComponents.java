package org.cognito.businesslayer.businesscomponents;

import org.cognito.businesslayer.pageactions.LoginActions;
import org.cognito.corelayer.FrameworkUtils;
import org.cognito.corelayer.Settings;

import java.util.Properties;

public class GeneralComponents extends FrameworkUtils {
    private static Properties globalProperties = Settings.getInstance();
    LoginActions login= new LoginActions();

    /*    Function to launch the application
        @param : application name
    */

    public void launchApplication(String application){

        String url = null;
        url = globalProperties.getProperty(application);
        if(url == null)
            addStepError("Application URL is not defined");
        driver.get(url);
        waitForPageLoad(20);
        addStepLog(" Application Launched : " +url);
    }

    /*    Function to login to the application
        @param : String Username and parameter
    */

    public void login(String userName,String password){

        login.navigateToLogin();
        login.enterUser(userName);
        login.enterPassword(password);
        login.clickSubmit();
        waitForPageLoad(20);

    }

}
