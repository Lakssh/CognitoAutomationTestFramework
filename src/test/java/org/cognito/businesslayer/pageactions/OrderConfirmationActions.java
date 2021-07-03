package org.cognito.businesslayer.pageactions;

import org.cognito.businesslayer.pagelocators.OrderConfirmation;
import org.cognito.orchestrationlayer.enums.TestData;

public class OrderConfirmationActions extends OrderConfirmation {

    public void navigateToMegaMenu(String megaMenuItem) {
        click(megaMenu(megaMenuItem));
    }

    public String getProductPrice() {
        scrollByLocator(plpProductImage);
        mouseHoverTo(plpProductImage, "product");
        String price = getText(plpProductPrice);
        setScenarioContext(TestData.UNITPRICE,price);
        return price;
    }

    public void addToCartFromPlp() {
        click(btnAddToCart);
    }

    public void validateCartPrice() {
        validateText(getText(cartProductPrice),getScenarioContext(TestData.UNITPRICE));
    }
    public void getCartAttributes() {
        setScenarioContext(TestData.QUANTITY,getText(productQuantity));
        setScenarioContext(TestData.SHIPPINGCOST,getText(cartShippingCost));
        setScenarioContext(TestData.TOTALPRICE,getText(cartTotalPrice));
        setScenarioContext(TestData.PRODUCT,getText(productName));

    }

    public void clickProceedToCheckout() {
        click(btnProceedToCheckOut);
    }

    public void validateSummaryPageAttributes(){
        validateText(getText(summaryProductPrice),getScenarioContext(TestData.UNITPRICE));
        validateText(getText(summaryShippingCost),getScenarioContext(TestData.SHIPPINGCOST));
        setScenarioContext(TestData.PRICEINCLTAX,getText(summaryTotalPriceWithTax));
    }

    public void clickProceedToCheckoutInSummary() {
        click(btnSummaryProceedToCheckOut);
    }

    public void clickProceedToCheckoutInAddressPage() {
        click(btnAddressProceedToCheckOut);
    }

    public void selectPaymentMethod() {
        click(paymentMode);
        validateText(getText(confirmationTotalAmount),getScenarioContext(TestData.PRICEINCLTAX));
    }

    public void checkTermsandConditions() {
        driver.findElement(checkBoxTermsOfService).click();
    }

    public void confirmOrder() {
        click(btnOrderConfirmation);
    }
    public void getOrderRef(){

        String orderRef = driver.findElement(orderReferenceNumber).getText().trim();
        int end = orderRef.indexOf(" in the subject of your bank wire.");
        orderRef = orderRef.substring(end-9,end);
        addStepLog("order Reference number is : " +orderRef);
        setScenarioContext(TestData.ORDERREF,orderRef);

    }

    public void clickProceedToCheckoutInShippingPage() {
        click(btnShippingConfirmation);
    }
}
