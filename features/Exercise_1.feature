# Created by Qal at 11/06/2024
Feature: Automation exercise 1

  Scenario: Financial Services are correctly displayed under the Financial Services Tab
    Given I navigate to the risk LexisNexis page
    When I select Financial Services from the dropdown menu
    Then I should see the list of services are present and clickable