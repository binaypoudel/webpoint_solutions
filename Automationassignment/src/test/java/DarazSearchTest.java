import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DarazSearchPage;
import pages.LoginPage;
import java.time.Duration;
import java.util.List;


public class DarazSearchTest {
    private WebDriver driver;

   DarazSearchPage darazSearchPage;
   LoginPage loginPage;

    final String correctUserName="binay.poudel2000@gmail.com";
    final String correctPassword="Test@buy2024";


    @BeforeEach
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://member.daraz.com.np/user/login?spm=a2a0e.11779170.header.d5.287d2d2baXWtn5&redirect=https%3A%2F%2Fwww.daraz.com.np%2F");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        darazSearchPage=new DarazSearchPage(driver);
        loginPage.login(correctUserName,correctPassword);

    }

    @AfterEach
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void elementCheckAndPrice() throws InterruptedException {

        driver.findElement(darazSearchPage.searchLocator).sendKeys("Sam");

        List<WebElement> elements=driver.findElements(darazSearchPage.searchListLocator);
        for(int i=0; i<elements.size();i++){
            String elementCheck=elements.get(i).getText();
            //System.out.println(elementCheck);
            Assertions.assertTrue(elementCheck.contains("Sam"));
            }
        elements.get(3).click();


        List<WebElement> price=driver.findElements(darazSearchPage.priceListLocator);
        for(int i=0; i<price.size();i++){
            String priceCheck=price.get(i).getText();
            //System.out.println(priceCheck);
            if(priceCheck.equals("Rs.15,999")){
                price.get(i).click();
                break;
            }
        }
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        WebElement cartElement=driver.findElement(darazSearchPage.cartLocator);
        js.executeScript("window.scroll(0,400)");

        cartElement.click();
        Thread.sleep(2000);
        WebElement cartCancelElement=driver.findElement(darazSearchPage.goTolLocator);
        cartCancelElement.click();
        driver.findElement(darazSearchPage.checkoutLocator).click();
        driver.findElement(darazSearchPage.placeOrderLocator).click();



        //System.out.println( cartElement.getText());
        Thread.sleep(5000);



    }
}
