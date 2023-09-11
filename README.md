This readme file provides instructions on how to run the automated tests for the project "restful_booker_api_automation_rest_assured" 
The "Restful-Booker" project provides a fictional RESTful API for managing hotel bookings. 
It offers endpoints for actions like creating authentication tokens, retrieving booking IDs, getting specific booking details, 
creating new bookings, updating existing bookings, and deleting bookings. The API documentation outlines the various endpoints, 
their required parameters, and expected responses, along with example usage in different formats (JSON, XML, URL-encoded). 
The tests are organized using Maven as a build automation tool. 
The project structure includes a Test folder that contains Java and Resources directories. 
The Java directory consists of the restbookerapi package, which contains sub-package with tests.
The Resources directory includes the necessary schema.json files used for testing.

###Setup Instructions
Ensure that Maven is installed on your machine.
Install the required dependencies and plugins defined in the pom.xml file.

Set the system environment variables for the project:
Set the ´REST_BOOKER_BASE_URL´ variable with the base url for navigation
Set the ´REST_BOOKER_USERNAME´ variable with the username for authentication.
Set the ´REST_BOOKER_PASSWORD´ variable with the password for authentication.
In the project they are set in the restbookerapi.utis.authentication.ApiConstants

###Executing tests
To run the automation tests, follow these steps:
Open the terminal and navigate to the project root directory.
Execute the following command in the terminal to run the tests.
´mvn clean test -Dtest="Tests"´
This command will execute the automation tests using the testng.xml configuration file.

###Test Reports
After running the tests, the test reports will be generated in the "target/surefire-reports" directory. 
You can access the HTML reports to view the test results and any failures or errors encountered during the execution.

###Cleaning Up
To clean the project and remove any generated files, execute the following command:
´mvn clean´
