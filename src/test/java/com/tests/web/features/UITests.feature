Feature: Home page validation of reqres website

  As a user of reqres portal
  I want to validate UI specifications mentioned
  So that I can make sure the portal is working as expected

Scenario: Validate home page
  Given user launches browser and navigate to application "https://reqres.in/"
  Then user should be landed on the homepage
    And user should be able to see text "Test your front-end against a real API" in tagline
    And user should be able to see requests in homepage
      | get       |
      | put       |
      | post      |
      | delete    |
      | patch     |
    And user should be able to see "LIST USERS" selected by default
    And user should be able to see "/api/users?page=2" under "Request"
    And user should be able to see 200 as response code
    And user should be able to see response body displayed
  When user selects "SINGLE USER NOT FOUND" from list of requests
  Then user should be able to see "/api/users/23" under "Request"
    And user should be able to see 404 as response code
    And user should be able to see response body displayed
    And "Support ReqRes" button should be available in homepage

Scenario: Validate support page
  Given user launches browser and navigate to application "https://reqres.in/"
  Then user should be landed on the homepage
    And user should be able to see text "Test your front-end against a real API" in tagline
    And user should be able to see "One-time payment" and "Monthly support" options
  When user clicks on "Support ReqRes" button
  Then user should be landed on the "Support ReqRes" page

Scenario: Validate Upgrade button
  Given user launches browser and navigate to application "https://reqres.in/"
  Then user should be landed on the homepage
    And user should be able to see text "Test your front-end against a real API" in tagline
    And "Upgrade" button should be available in homepage