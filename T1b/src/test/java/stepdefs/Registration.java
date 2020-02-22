package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.junit.Assert.assertTrue;

public class Registration {
    WebDriver driver;

    private String firstName= "Mateusz";
    private String lastName= "PLuta";
    private String email= randomAlphanumeric(5) + "piesek@wp.pl";

    @Given("^Im on the registration website$")
    public void imOnTheRegistrationWebsite() {
        firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&create_account=1");
    }

    @When("^I choose my gender$")
    public void iChooseMyGender() {
        driver.findElements(By.name("id_gender")).get(1).click();
    }

    @And("^I fill in my first name$")
    public void iFillInMyFirstName() {
        driver.findElement(By.name("firstname")).sendKeys(firstName);
    }

    @And("^I fill in my last name$")
    public void iFillInMyLastName() {
        driver.findElement(By.name("lastname")).sendKeys(lastName);

    }

    @And("^I fill in my email$")
    public void iFillInMyEmail() {
        driver.findElement(By.name("email")).sendKeys(email);

    }

    @And("^I fill in my password$")
    public void iFillInMyPassword() {
        driver.findElement(By.name("password")).sendKeys("potatoes1234");

    }

    @And("^I press Sign in button$")
    public void iPressButton() {

        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/section/form/footer/button")).click();
    }

    @Then("^the website loads index page with me signed in$")
    public void theWebsiteLoadsIndexPageWithMeSignedIn() {
        assertTrue(driver.findElement(By.className("account")).getText().contains(firstName+ " "+ lastName));
    }


}
