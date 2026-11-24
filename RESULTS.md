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
- Step 4.6, tool and calories in the answer of POST /api/pizza:
- Step 4.7, the line of the admin list that shows your pizza:
- Step 4.8, run 1, result, duration and pizza name:
- Step 4.8, run 2, result, duration and pizza name:
- Step 4.9 (optional), browser and result:

## Part B
1.
2.
3.
4.
5.
6.
7.
