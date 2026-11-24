# ui-lab

Tool parts that I chose: **Part 2 (Selenium WebDriver in Java)** and **Part 4 (Cypress)**.

## selenium-java (Part 2)

A Maven project with JUnit 6 and Selenium 4.52 tests: the web form, a wait demo, QP-01 written
directly (`QP01Test`) and QP-01 with page objects (`QP01PageObjectTest`, pages in
`src/test/java/uilab/pages`). `screenshots/` and `reports/` hold the evidence of the full runs.
The tests need the environment variable `CHROMEDRIVER`, the path of a ChromeDriver that matches Chrome.

Run from the `selenium-java` folder:

    mvn test -Dheadless=true

## cypress (Part 4)

A Cypress 16 project with two specs in `cypress/e2e`: `web-form.cy.js` and `pizza-scenario.cy.js`
(QP-01, with `cy.intercept` and the custom command `adminLogin` in `cypress/support/commands.js`).
`cypress/videos` and `cypress/screenshots` hold the evidence of the last full run.

Run from the `cypress` folder, after `npm install`:

    npx cypress run --browser chrome

With Chrome 158 a single run crashed between the two specs ("* is not a valid URL"),
so the evidence was made by running each spec on its own:

    npx cypress run --browser chrome --spec cypress/e2e/pizza-scenario.cy.js
    npx cypress run --browser chrome --spec cypress/e2e/web-form.cy.js