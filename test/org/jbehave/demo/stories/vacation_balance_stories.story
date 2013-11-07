Scenario: Default accrual and no vacation time used
Given I have a start date of '9/1/2013'
When I ask for my vacation balance
Then I learn that my balance is '1.9164955509924706'
