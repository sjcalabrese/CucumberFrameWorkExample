#Author: erotavlas103@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps

Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenCart landing page
When User searched with short name <Names> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to Checkout and validates the <Names> items in checkout page
And verify user is able to enter promo code and place order

Examples:
| Names |
| Tom 	|
