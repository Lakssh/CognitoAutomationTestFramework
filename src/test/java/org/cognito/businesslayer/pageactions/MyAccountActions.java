package org.cognito.businesslayer.pageactions;

import org.cognito.businesslayer.pagelocators.MyAccount;
import org.cognito.orchestrationlayer.enums.TestData;

public class MyAccountActions extends MyAccount {

    public void clickMyAccount(){
        click(myAccount);
    }
    public void clickOrderHistory(){
        click(orderHistory);
    }
    public void clickPersonalInformation(){
        click(personalInformation);
    }
    public void sortbyOrder(){
        clickUsingJS(dateSort,"Date sort");
    }
    public void clickOrderDetails(){
        click(btnOrderDetails(getScenarioContext(TestData.ORDERREF)));
    }
    public String getTotalPriceFromHistory(){
       return getText(totalPriceIncTax);
    }

    public void validateOrderDetails(){

        scrollByLocator(orderReference);
        validateTextContains(getText(orderReference),getScenarioContext(TestData.ORDERREF));
        scrollByLocator(productName);
        validateTextContains(getText(productName),getScenarioContext(TestData.PRODUCT));
        validateText(getText(productQuantity),getScenarioContext(TestData.QUANTITY));
        validateText(getText(unitPrice),getScenarioContext(TestData.UNITPRICE));
        validateText(getText(totalPriceIncTax),getScenarioContext(TestData.PRICEINCLTAX));
    }

    public void updateFirstName(String updatedName,String password){
        updatedName = updatedName + getRandomString("abcdefghijk",3);
        enterValue(txtFirstName,updatedName);
        setScenarioContext(TestData.FIRSTNAME,updatedName);
        enterValue(txtOldPassword,password);
    }

    public void validateUpdatedFirstName(){
        validateText(driver.findElement(txtFirstName).getAttribute("value"),getScenarioContext(TestData.FIRSTNAME));
    }

    public void savePersonalInformationChanges(){
        click(btnSave);
    }
    public void validateSuccessMessage(){
        if (driver.findElements(successMessage).size() != 0)
            addStepLog("Success Message displayed as expected");
        else
            addStepError("Success message is not displayed");
    }

}
