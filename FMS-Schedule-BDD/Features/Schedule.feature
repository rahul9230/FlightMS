Feature: Schedule a flight

Scenario: Successful Scheduling of flight
Given Admin is on login page
When Admin enters valid username and password
And Admin clicks on Login button
And Admin clicks Schedule a Flight

And Admin fills all the details of Flight and Schedule
And Admin click on Add Schedule	
Then Admin is logged out.