@login
Feature: login to Printerpix

  @login
  Scenario Outline: Navigate to Printerpix in Chrome and perform login
    Given User  launch the  browser "<browser>"
    When User navigates to "<URL>"
    And User clicks on Account button
    And User enters the username has "<Username>"
    And User enters the password has "<Password>"
    And User clicks on Login button
    
    @loginwithChrome
    Examples:
   |browser |URL                         |Username                    |Password|
   |chrome  |https://www.printerpix.com  |testautomation0691@gmail.com|Test    |
   |chrome  |https://www.printerpix.co.uk|harish.r@syncoms.com        |syncoms |
   
   