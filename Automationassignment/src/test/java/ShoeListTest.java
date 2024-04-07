import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CSVWriter;
import pages.LoginPage;
import pages.ShoeListPage;
import java.time.Duration;
import java.util.List;

public class ShoeListTest {
    private WebDriver driver;

    private ShoeListPage shoeListPage;
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
      shoeListPage=new ShoeListPage(driver);
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
    public void sneakerListInExcel() throws InterruptedException {
        WebElement element= driver.findElement(shoeListPage.mensFashionLocator);
        element.click();
        Actions actions = new Actions(driver);

        //Hovering on shoe menu
        actions.moveToElement( driver.findElement(shoeListPage.shoeLocator)).perform();
        driver.findElement(shoeListPage.sneakerLocator).click();
        List<WebElement> names=driver.findElements(shoeListPage.sneakerNameLocator);
        List<WebElement> price=driver.findElements(shoeListPage.sneakerPriceLocator);


        CSVWriter csvWriter = new CSVWriter("C:\\Users\\Binay\\Desktop\\ShoeList.csv");
        for (int i = 0; i < 20; i++) {
            String itemName =names.get(i).getText();
            //System.out.println(itemName);
            String itemPrice = price.get(i).getText();
            String str=itemPrice.replace(",","");
            //System.out.println(str);
            csvWriter.writeData(itemName,str );
        }
        csvWriter.close();

        for (WebElement name : names) {
            String nameCheck = name.getText();
            //System.out.println(nameCheck);
            if (nameCheck.matches("Air Force 1.*")) {
                name.click();
                break;
            }
        }
        driver.findElement(shoeListPage.sizeLocator).click();
        driver.findElement(shoeListPage.quantityLocator).click();
        driver.findElement(shoeListPage.cartLocator).click();
        Thread.sleep(5000);


    }
}