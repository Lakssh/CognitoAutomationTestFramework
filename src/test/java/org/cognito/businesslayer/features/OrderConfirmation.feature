Feature: Order Confirmation

  @Regression
  Scenario Outline: Order T-shirt and verify Order History
    Given I launch the <application>
    And I login to the application using <userName> and <password>
    And I clear the cart if present
    When I navigate to T-shirts menu and add a product to basket
    And I validate the summary and confirm order
    Then I navigate to order History page and validate the details
    And I signout from the application
    Examples:
      |application        |userName           |password   |
      |automationpractice |lakssh@hotmail.com |Test1234   |

  #####################################################################################################################

  @Regression
  Scenario Outline: Order Dresses and verify Order History
    Given I launch the <application>
    And I login to the application using <userName> and <password>
    And I clear the cart if present
    When I navigate to Dresses menu and add a product to basket
    And I validate the summary and confirm order
    Then I navigate to order History page and validate the details
    And I signout from the application
    Examples:
      |application        |userName           |password   |
      |automationpractice |lakssh@hotmail.com |Test1234   |
