import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Specialists {

    WebDriver driver;
    WebElement SearchField;
    WebElement SearchResult;
    WebElement ViewMoreButton;
    WebElement imageSpecial;

    Wait<WebDriver> wait;



    @BeforeClass
    public void setUp(){
        //Initialize driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.get("https://famcare.app/specialists/");

    }

    @Test(priority = 1)
    public void SearchFieldIsDisplayed() {
        SearchField = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/label/input"));
        SearchField.sendKeys("هدى");
        SearchField.sendKeys(Keys.ENTER);

        }

    @Test(priority = 2)
    public void SearchResultIsDisplayed() {
        // Verify that the related result appears
        SearchResult = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/label/input"));
        Assert.assertTrue(SearchResult.isDisplayed(), "Search result is displayed");
        driver.navigate().back();
    }

    @Test(priority = 3)
    public void ViewMoreButtonIsDisplayed() {
        ViewMoreButton = driver.findElement(By.xpath("/html/body/div[1]/a"));
        Assert.assertTrue(ViewMoreButton.isDisplayed());
    }

    @Test(priority = 4)
    public void CardSpeciaButton() {
        // Verify that the related result appears
        SearchResult = driver.findElement(By.xpath(" /html/body/div[1]/div/div[2]/div/div[2]/a[1]"));
    }

    @Test(priority = 5)
    public void CardSpeciaButtonISClickable() {
        SearchResult.click();
    }

    @Test(priority = 6)
    public void verifyCardSpeciaInformation() {
        SearchResult = driver.findElement(By.xpath(" /html/body/div[1]/div/div[1]/div/div/img"));
        SearchResult = driver.findElement(By.xpath("  /html/body/div[1]/div/div[1]/div/h1"));
        Assert.assertEquals(SearchResult.getText(), "طلال عياش الحربي");
        SearchResult = driver.findElement(By.xpath("      /html/body/div[1]/div/div[1]/div/p"));
        Assert.assertEquals(SearchResult.getText(), "أخصائي تخاطب");



    }





}
