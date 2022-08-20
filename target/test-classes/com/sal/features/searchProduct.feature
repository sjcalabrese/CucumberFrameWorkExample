#Author: erotavlas103@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps

Feature: Search and Place the order for Products

Scenario: Search Experience for product search in both home and offers page

Given User is on GreenCart landing page
When User searched with short name "Tom" and extracted actual name of product
Then User search for "Tom" short name in offers page
And validate product name in offers page matches with Landing Page


