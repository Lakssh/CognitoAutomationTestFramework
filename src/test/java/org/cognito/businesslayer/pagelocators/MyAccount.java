package org.cognito.businesslayer.pagelocators;
import org.cognito.corelayer.FrameworkUtils;
import org.openqa.selenium.By;

public class MyAccount extends FrameworkUtils {

    public final By myAccount = By.xpath("//a[@title='View my customer account']");
    public final By orderHistory = By.xpath("//span[text()='Order history and details']");
    public final By personalInformation = By.xpath("//span[text()='My personal information']");
    //Order History
    public final By dateSort= By.xpath("//th[normalize-space()='Date']");
    public final By orderReference = By.cssSelector("p[class='dark'] strong");
    public final By btnOrderDetails(String orderNo){
        return By.xpath("//a[contains(text(),'"+orderNo+"')]/../following-sibling::td//span[contains(text(),'Details')]");
    }
    public final By productName = By.cssSelector("td[class='bold'] label");
    public final By productQuantity = By.cssSelector("span[class='order_qte_span editable']");
    public final By unitPrice = By.cssSelector("tbody tr[class='item'] td:nth-child(4) label:nth-child(1)");
    public final By totalPriceIncTax = By.cssSelector("tr[class='totalprice item'] span[class='price']");
    //personal Information
    public final By txtFirstName = By.id("firstname");
    public final By txtOldPassword = By.id("old_passwd");
    public final By btnSave = By.xpath("//button[@name='submitIdentity']");
    public final By successMessage = By.cssSelector(".alert.alert-success");
}
