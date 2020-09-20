Feature: Validate the Awards & Accolades page

  Background:
    Given User is on dbs singapore home page
    And User clicks on "Learn More"
    And User clicks on "About"

  @SmokeTest
  Scenario: Validate the total number of awards displayed is 22
    Given User clicks on "Who we are"
    And User clicks on "Our Awards & Accolades"
    Then Validate the total number of awards displayed on the page is 22

  @SmokeTest
  Scenario: Validate all the award name and caption of the awards mentioned in the below table
    Given User clicks on "Who we are"
    And User clicks on "Our Awards & Accolades"
    Then User validates all the award name and caption of the awards mentioned below
      |Award Name	    |Caption of the award                                     |
      |A World First	|Euromoney                                                |
      |The Banker	    |Bank of the Year 2018                                    |
      |Global Finance	|Best Bank in the World 2018                              |
      |Euromoney	    |Awards For Excellence                                    |
      |Global Finance	|World's Best Banks                                       |
      |Global Finance	|World's Best Investment Banks and Derivatives Providers  |