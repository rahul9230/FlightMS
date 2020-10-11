Feature: Check Login

Scenario: Successful login with valid credentials
Given Admin is on login page
When Admin enters valid username and password
And Admin clicks on Login button
Then Admin should be able to see Scheduling Page.