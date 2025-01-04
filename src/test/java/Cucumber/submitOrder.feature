
 @tag
 Feature:purchase the order from Ecommerce website
 Background: 
 Given I landed on Ecommerce page
  Scenario Outline: posivite scenario to submit order
    Given Logged in with <username> and <password>
    When I add product <ProductName> to cart
    And checkout<ProductName> and submit the order
    Then "THANKYOU FOR THE ORDER."message is displayed on the ConfirmationPage.

    Examples: 
      | username  | password | ProductName
      |adviky140222@gmail.com  | Advik@14022022   | ZARA 
 
