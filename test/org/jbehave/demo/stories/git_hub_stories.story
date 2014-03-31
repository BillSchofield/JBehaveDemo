Logging into GitHub

Narrative:
In order to control access to my repositories
As a GitHub user
I want to login to GitHub using my username & password

Scenario: Login allows repo creation
Given I have created an account
When I login to GitHub
Then I am logged in
And I can create new repositories