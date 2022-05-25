
@login
Feature: Navigate to printerpix and perform loginto facebook

  @logintofacebook
  Scenario Outline: Login to facebook
    Given User  launch the  browser "<browser>"
    When User navigates to "<URL>"
    And User clicks on Account button
    And User clicks on Login to facebook button
    And User enters the emailaddress "<emailaddress/phoneNumber>"
    And User enters the password "<password>"
    And User clicks on Login

    Examples: 
      | browser | URL                        | emailaddress/phoneNumber | password  |
      | chrome | https://www.printerpix.com | harish_kiccha@yahoo.com  | incorrect |
