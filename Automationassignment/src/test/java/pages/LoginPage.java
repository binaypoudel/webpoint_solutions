package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    final  WebDriver driver;
    public By usernameLocator=By.cssSelector("body.venture-NP.p-yatra:nth-child(2) div.lzd-playground:nth-child(2) div.lzd-playground-main div.container div.login form:nth-child(1) div.mod-login div.mod-login-col1 div.mod-input.mod-login-input-loginName.mod-input-loginName:nth-child(1) > input:nth-child(2)");
    public  By passwordLocator=By.cssSelector("body.venture-NP.p-yatra:nth-child(2) div.lzd-playground:nth-child(2) div.lzd-playground-main div.container div.login form:nth-child(1) div.mod-login div.mod-login-col1 div.mod-input.mod-input-password.mod-login-input-password.mod-input-password:nth-child(2) > input:nth-child(2)");
    public  By loginLocator=By.cssSelector("body.venture-NP.p-yatra:nth-child(2) div.lzd-playground:nth-child(2) div.lzd-playground-main div.container div.login form:nth-child(1) div.mod-login div.mod-login-col2 div.mod-login-btn > button.next-btn.next-btn-primary.next-btn-large");
    public  By registerLocator=By.xpath("//span[@id='myAccountTrigger']");




    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameLocator).clear();

        driver.findElement(usernameLocator).sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(password);
    }

    // Method to perform login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        driver.findElement(loginLocator).click();
    }
    public boolean isLoginSuccessful() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(registerLocator));
            WebElement res = driver.findElement(registerLocator);
            String str = res.getText();
            return str.equals("Hello, Binay Poudel's account");
        }
        catch (Exception e){
            return false;

        }
    }


    }




