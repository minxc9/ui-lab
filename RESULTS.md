# UI lab results

Tool parts that I chose: Part 2 Selenium WebDriver in Java and Part 4 Cypress

## Part 0
- Step 0.1, Chrome version: 158.0.8127.37 (Official Build) (arm64) 
- Step 0.3, ChromeDriver version: ChromeDriver 158.0.8127.36
- Step 0.4, locator of Pizza, Please!: name=pizza-please
- Step 0.4, locator of Excluded tools: css=select
- Step 0.4, locator of Must be vegetarian: id=default-checkbox
- Step 0.4, locator of Custom Pizza Name: css=input#pizza-name
- Step 0.5, pizza name, tool and calories of the run by hand: Lab Pizza 20261124-023510 tool=Scissors, calories per slice: 425

| Step | Actual result | Pass or fail |
|------|---------------|--------------|
| 1    | Heading "Looking to break out of your pizza routine?" shown | Pass |
| 2    | Max Calories per Slice, Excluded tools, Must be vegetarian and Custom Pizza Name appeared | Pass |
| 3    | Fields showed 600, Knife, vegetarian ticked, Lab Pizza 20261124-023510 | Pass |
| 4    | Name: Lab Pizza 20261124-023510, Tool: Scissors, Calories per slice: 425 | Pass |
| 5    | "Please log in first." shown | Pass |
| 6    | "Latest pizza recommendations" shown after admin/admin | Pass |
| 7    | Lab Pizza 20261124-023510 (tool=Scissors, ingredients_number=6) | Pass |


## Part 2: Selenium WebDriver in Java
- Step 2.4, the failure line for the wrong title: [ERROR]   FirstTest.webFormOpens:20 expected: <Web Form> but was: <Web form>
- Step 2.15, QP01Test run 1, result and time: Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 7.914 s -- in uilab.QP01Test
- Step 2.15, QP01Test run 2, result and time: Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 8.412 s -- in uilab.QP01Test
- Step 2.20, full run 1, time and number of tests: Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Total time:  23.709 s
- Step 2.20, full run 2, time and number of tests: Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Total time:  24.065 s

## Part 4: Cypress
- node --version, npm --version and npx cypress version: v26.2.0, 11.13.0, Cypress package version: 16.2.1, Cypress binary version: 16.2.1
- Step 4.3, failure message for the wrong title: 
      Timed out retrying after 10000ms
      + expected - actual

      -'Web form'
      +'Web Form'
- Step 4.6, tool and calories in the answer of POST /api/pizza: tool Pizza cutter, calories 550 
- Step 4.7, the line of the admin list that shows your pizza: Lab Pizza 20261124-173017 (tool=Scissors, ingredients_number=5)
- Step 4.8, run 1, result, duration and pizza name: both specs passed (pizza-scenario 1 passing, 0 failing, 9 s; web-form 1 passing, 0 failing, 3 s; total 12 s), Pizza name: Lab Pizza 20261124-173936
- Step 4.8, run 2, result, duration and pizza name: both specs passed (pizza-scenario 1 passing, 0 failing, 9 s; web-form 1 passing, 0 failing, 3 s; total 12 s), Pizza name: Lab Pizza 20261124-174556
- Step 4.9 (optional), browser and result:

## Part B
1. `$$("#floating_filled").length` returned 3, because the three number boxes share one id, so the tests find Max Calories per Slice through its label instead. I propose a unique id such as `id="max-calories"` for each box. A unique id gives a short locator that does not break when the label text or layout changes.

2. It is a consistency oracle, because it compares the recommendation that the customer sees with the record that the admin sees. In my run both showed Scissors for Lab Pizza 20261124-173017, below pizzas from other users. It would catch a fault where the server saves a different tool than it shows the customer.

3. The page shows only ingredient names, so the test cannot tell from the page whether the pizza is vegetarian. The test could use the response of `POST /api/pizza` from `cy.intercept` and assert that its `vegetarian` field is true. A stronger check would compare each ingredient with a list of vegetarian ingredients from the API.

4. In Java I had to write every wait myself, and WaitTest failed with NoSuchElementException until I added one, while Cypress retried every command for 10 seconds by itself. QP-01 took about 8 s in both tools, but Cypress was quicker to write and gave a video and screenshots, while Java gave a Surefire text report. Both had trouble with Chrome 158: Selenium warned about CDP version 158, and Cypress crashed with "* is not a valid URL" between specs, so I ran each spec separately.

5. My group used Selenium WebDriver with pytest for Project 2, and after this lab I would choose it again. The habits from Part 2 carried over directly, such as `WebDriverWait` instead of fixed pauses and page objects that keep the locators in one place. Selenium can also open a second browser for a staff user and a customer, while Cypress controls only one browser per test.

6. (Part 2) QP01Test has the calories XPath inside the test method, so I would have to edit the test itself. In QP01PageObjectTest I would change only the constant `MAX_CALORIES` in HomePage. Every test that uses HomePage is then repaired at once.

7. (Part 4) A cookie keeps one browser on one QuickPizza server, and Cypress clears cookies before each test. A separate test for steps 6 and 7 could reach another server, miss the pizza, and lose `pizzaName` and `@tool`. I saw this by hand when my first pizza, 20261124-022630, did not appear in the admin list.