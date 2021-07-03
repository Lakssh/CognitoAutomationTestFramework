package org.cognito.businesslayer.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.cognito.businesslayer.pageactions.MyAccountActions;
import org.cognito.businesslayer.pageactions.OrderConfirmationActions;

public class OrderConfirmation extends OrderConfirmationActions {

    MyAccountActions myAccount = new MyAccountActions();

    @Given("^I navigate to (.+) menu and add a product to basket$")
    public void navigate_to_megaMenuItem_and_add_a_product(String megaMenuItem) {
        navigateToMegaMenu(megaMenuItem);
        getProductPrice();
        addToCartFromPlp();
        waitForPageLoad(20);
        validateCartPrice();
        getCartAttributes();
        clickProceedToCheckout();
        waitForPageLoad(20);
    }

    @Then("I validate the summary and confirm order")
    public void validate_and_confirm_order() {
        validateSummaryPageAttributes();
        clickProceedToCheckoutInSummary();
        clickProceedToCheckoutInAddressPage();
        checkTermsandConditions();
        clickProceedToCheckoutInShippingPage();
        selectPaymentMethod();
        confirmOrder();
        getOrderRef();

    }

    @And("I navigate to order History page and validate the details")
    public void navigate_to_orderHistory_and_validate_details() {

        myAccount.clickMyAccount();
        myAccount.clickOrderHistory();
        myAccount.sortbyOrder();
        myAccount.clickOrderDetails();
        myAccount.validateOrderDetails();

    }

}
