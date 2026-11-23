package uilab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

class QP01Test extends BaseTest {

    static final String HOME = "https://quickpizza.grafana.com/";

    // QP-01: a custom pizza keeps its restrictions, rating it needs a
    // login, and the admin sees the new pizza.
    @Test
    void customPizzaReachesTheAdminList() {
        String stamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String pizzaName = "Lab Pizza " + stamp;

        // Step 1: open the home page
        driver.get(HOME);
        WebElement heading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                By.tagName("h1")));
        assertEquals("Looking to break out of your pizza routine?",
                heading.getText());

        // Step 2: turn on Advanced
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//label[.//span[normalize-space()='Advanced']]")))
                .click();
        WebElement calories = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//label[normalize-space()='Max Calories per Slice']"
                + "/preceding-sibling::input")));

        // Add the next step above this line.
    }
}