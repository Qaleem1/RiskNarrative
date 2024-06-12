package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Exercise_Step {
    WebDriver driver;

    public WebElement cookieBanner() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element;
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")));
        return element;
    }

    @Given("I navigate to the risk LexisNexis page")
    public void i_am_on_lexis_nexis_homepage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://risk.lexisnexis.co.uk/");

        if (cookieBanner().isDisplayed()) {
            cookieBanner().click();
            System.out.println("Cookie Banner Accepted");
        } else {
            throw new AssertionError("Cookie Banner is not displayed");
        }
    }

    @When("I select Financial Services from the dropdown menu")
    public void i_select_financial_services_from_the_dropdown_menu() {
        driver.findElement(By.xpath("//a[contains(., \"Choose Your Industry\")]")).click();
        driver.findElement(By.xpath("//*[@data-industryname=\"Financial Services \"]/div[contains(., \"Financial Services\")]")).click();
    }

    @Then("I should see the list of services are present and clickable")
    public void i_should_see_the_list_of_services_are_present_and_clickable() {
        String[] subPages = {"Financial Crime Compliance", "Customer Data Management", "Collections and Recovery", "Risk Orchestration", "Fraud and Identity Management", "Credit Risk Assessment", "Investigations and Due Diligence"};

        for (String subPage : subPages) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement element;
                element = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='subpage-title' and contains(text(),'" + subPage + "')]")));

                if (element.isDisplayed()) {
                    System.out.println("Element with text '" + subPage + "' is displayed.");
                }

            } catch (Exception e) {
                throw new AssertionError("Element '" + subPage + "' was not found", e);
            }
        }
    }
    @After
    public void tearDown() {
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }
}
