## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: sqedemonstrationchallenge@nbcuni.com

#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/

#### Expectations
We will be evaluating
1. Quality of test cases
2. Variety  of testing types (examples: boundary, happy path, negative, etc)
3. Code structure and organization
4. Naming conventions
5. Code readability
6. Code modularity

#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases

Functional Testcases:  
1. To verify whether user is able to place Pizza order with all the details  
2. To verify Success pop up after entering all details and clicking PlaceOrder button  
3. To verify Reset button functionality to clear the data entered  
4. To verify maximum and minimum length of name,Email and phone fields
5. To verify mandatory message or pop up is displayed if user clicks Place Order button without entering Name and Phone fields
6. To check for invalid details in Name,Email and Phone fields
7. To verify Cost is updated according to quantity and pizza type entered by user
8. To verify Cost field is in disabled mode
9. To verify if the user selects 1 radio button in Payment Information then other should be in disbaled mode
10. To verify user should be able to change or toggle between 2 radio buttons in Payment Information
11. To verify the text in success popup is displayed correctly
12. To verify the close button functionality of success message poup
13. To verify the Total amount on the popup displayed is same as cost
14. To verify maximum and minimum length of Quantity field
15. To verify the Pop up message if the user doesn't enter any data and clicks Place Order button
16. To verify that the user cannot enter any data or click any button untill the pop up is closed
17. To check if the email id entered is valid or not
18. To verify the user data is not cleared off after page refresh


UI/Non functional testcases:

1.To verify the order form for Cross browser testing  
2.To verify the Place Order and Reset buttons are blue in colour  
3.To verify dropdowns closes after selecting the values  
4.To verify the * symbol for Name and Phone fields  
5.To verify the alignment and borders of the page  
6.To verify if the title is dispalyed in the center  
7.To verify if the page is scrollable

Performance/Load testcases:

1.To verify page load time for single order  
2.To verify page with continuous orders and check for load testing


Boundary testcases:
1.Enter string,numeric and special characters in Quantity, name, email and phone number fields  
2.Invalid credit card information or phone number is entered

Defects in the page:

1. On clicking Reset button all the data enetered is not resetted
2. Toppings dropdowns are enabled even if the pizza type is not selected
3. Able to select both radio buttons at a time in Payment Information Section
4. Able to place order even if the pizza type is not selected
5. Unable to enter credit card details

