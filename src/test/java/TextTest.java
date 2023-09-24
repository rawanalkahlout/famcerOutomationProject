import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Text {
   private String Xpath;
   private WebDriver driver;
   private WebElement displayText;


    public Text(String Xpath, WebDriver driver) {
        this.Xpath = Xpath;
        this.driver = driver;
    }
    public void TextDisplay(){
        displayText = driver.findElement(By.xpath(Xpath));
        Assert.assertTrue(displayText.isDisplayed());
    }

}
