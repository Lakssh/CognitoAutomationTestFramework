package org.cognito.businesslayer.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.cognito.businesslayer.pageactions.MyAccountActions;

public class MyAccount extends MyAccountActions {

    @When("I navigate to personal information page")
    public void navigate_to_personal_information_page()
    {
    clickMyAccount();
    clickPersonalInformation();
    }
    @Then("^I update FirstName (.+) in personal information page using password (.+) and submit$")
    public void update_firstName(String updatedName , String password){
        updateFirstName(updatedName,password);
        savePersonalInformationChanges();
        validateSuccessMessage();
    }
    @Then("^validate if the updated first name is replicated$")
    public void validate_updated_first_name_replicated(){
        validateUpdatedFirstName();
    }


}
