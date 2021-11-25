Feature: Login functionality

Background:
Given user navigate to url "http://localhost:100" on chrome
Then Login page should be appear


Scenario: Valid login
When user enters valid username and password
And click on the login button
Then user should be landed on homepage
And Logout link should be appear
And close the browser


#Scenario Outline: Invalid login
#When user enters invalid userid as "<userid>" and password as "<password>"
#And click on the login button
#Then error msg should be appear
#And close the browser
#Examples:
#|userid|password|
#|admin1|admin1|
#|admin2|admin2|
#|admin3|admin3|
