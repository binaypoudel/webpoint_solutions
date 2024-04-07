import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FlashSalePage;
import pages.LoginPage;


import java.time.Duration;
import java.util.List;

public class FlashSaleTest {
    private WebDriver driver;

    private FlashSalePage flashSalePage;
    LoginPage loginPage;
    final String correctUserName="binay.poudel2000@gmail.com";
    final String correctPassword="Test@buy2024";

    @BeforeEach
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://member.daraz.com.np/user/login?spm=a2a0e.11779170.header.d5.287d2d2baXWtn5&redirect=https%3A%2F%2Fwww.daraz.com.np%2F");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        flashSalePage=new FlashSalePage(driver);
        loginPage.login(correctUserName,correctPassword);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.registerLocator));
        driver.findElement(loginPage.registerLocator);
    }

    @AfterEach
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void flashSaleItem() throws InterruptedException {
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 500)
                .perform();
        driver.navigate().refresh();
        WheelInput.ScrollOrigin scrollAgain = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollAgain, 0, 500)
                .perform();
        String hour=driver.findElement(flashSalePage.hourLocator).getText();
        int h=Integer.parseInt(hour);
        //System.out.println(h);
        List<WebElement> elements=driver.findElements(flashSalePage.flashSaleListTitleLocator);
            if(h>=5){
                String itemName=elements.get(2).getText();
                System.out.println("Item Name: "+itemName+" and position is Third");
                elements.get(2).click();
                driver.findElement(flashSalePage.cartLocator).click();
            } else if (h>=3) {
                String itemName=elements.get(1).getText();
                System.out.println("Item Name: "+itemName+" and position is Second");
                elements.get(1).click();
                driver.findElement(flashSalePage.cartLocator).click();

            }
            else {
                String itemName=elements.get(0).getText();
                System.out.println("Item Name: "+itemName+" and position is First");
                elements.get(0).click();
                driver.findElement(flashSalePage.cartLocator).click();
            }
        Thread.sleep(5000);

    }
}

