package org.cognito.businesslayer.pagelocators;
import org.cognito.corelayer.FrameworkUtils;
import org.openqa.selenium.By;

public class Login extends FrameworkUtils {

    public final By btnLogin = By.cssSelector(".login");
    public final By txtUser = By.id("email");
    public final By txtPassword = By.id("passwd");
    public final By btnSignin = By.id("SubmitLogin");
    public final By btnSignOut = By.cssSelector(".logout");
    public final By cartCount = By.xpath("//div[@class='shopping_cart']/a/span[@class='ajax_cart_quantity']");
    public final By removeCart = By.xpath("//a[@class='ajax_cart_block_remove_link']");
}
