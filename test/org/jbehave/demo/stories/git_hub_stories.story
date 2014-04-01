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

Scenario: Test addition using Tabular Parameters
When I add these numbers:
| x| y |
| 1| 2 |
| 2| 3 |
| 3|-4 |
Then I get these numbers:
|result|
|  3 |
|  5 |
| -1 |

Scenario: Test addition for kids using Parametrised Scenarios
Given <startingApples> apples
When I buy <moreApples> more apples
Then I have <totalApples> apples

Examples:
|startingApples|moreApples|totalApples|
|             1|        10|         11|
|            11|         1|         12|
|            21|        11|         32|