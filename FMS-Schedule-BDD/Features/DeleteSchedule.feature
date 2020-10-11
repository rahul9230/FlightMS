Feature: Delete Schedule

Scenario: Successful deleting of Schedule
Given Admin in on the Scheduling Page
When Admin clicks on DeleteScheduledFlight
And Admin gives flightID to be deleted
Then Admin should be able to see Scheduled flight deleted.