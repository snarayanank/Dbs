Feature: Validate DBS Stronger Together Fund setup by DBS in various countries to support communities hard hit by Covid-19

  Background:

    @RegressionTest
  Scenario: Get the list of SG F&B Businesses that provide meals via 'Feed the City' programme funded by DBS
    Given User is on dbs singapore home page
    When User clicks on "Learn More"
    When User clicks on "Sustainability"
    When User clicks on "Creating Social Impact"
    When User clicks on "DBS Stronger Together Fund"
    Then User navigates to "Singapore" on the left panel
    And Gets the list of SG F&B Businesses providing meals and writes to excel