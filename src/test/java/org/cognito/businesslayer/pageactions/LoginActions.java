package org.cognito.businesslayer.pageactions;


import org.cognito.businesslayer.pagelocators.Login;

public class LoginActions extends Login {

    public void navigateToLogin() {
        click(btnLogin);
    }

    public void enterUser(String value) {
        enterValue(txtUser, value);
    }

    public void enterPassword(String value) {
        enterValue(txtPassword, value);
    }

    public void clickSubmit() {
        click(btnSignin);
    }

    public void signOut() {
        click(btnSignOut);
    }

}
