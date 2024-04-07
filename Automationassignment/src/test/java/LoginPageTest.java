import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;




import java.sql.*;

import java.time.Duration;

public class LoginPageTest {

    private WebDriver driver;
    private  final String correctUserName="binay.poudel2000@gmail.com";
    private final String correctPassword="Test@buy2024";
    private LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://member.daraz.com.np/user/login?spm=a2a0e.11779170.header.d5.287d2d2baXWtn5&redirect=https%3A%2F%2Fwww.daraz.com.np%2F");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testLogin() {

        try {
           Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\sqlitedatabase\\loginDB.db"," "," ");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT username, password FROM user");

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                driver.get("https://member.daraz.com.np/user/login?spm=a2a0e.11779170.header.d5.287d2d2baXWtn5&redirect=https%3A%2F%2Fwww.daraz.com.np%2F");
                loginPage.login(username, password);

                 //Check if login was successful
                if (loginPage.isLoginSuccessful()) {
                    System.out.println("Successfully logged in with username: " + username);
                    break;
                } else {
                    System.out.println("Login failed with username: " + username);
                }
           }
            conn.close();
             }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


}