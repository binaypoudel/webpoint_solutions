package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlashSalePage {
    final WebDriver driver;
    public By hourLocator=By.xpath("//div[@id='hours']");
    public By minuteLocator=By.xpath("//div[@id='minutes']");
    public By secondLocator=By.xpath("//div[@id='seconds']");
    public By flashSaleListTitleLocator=By.xpath("//a[@class='card-fs-content-body-unit hp-mod-card-hover J_FSItemUnit']//div[@class='fs-card-title']");
    public By cartLocator=By.xpath("//body/div[@id='container']/div[@id='root']/div[@id='block-_4sUzDww8j']/div[@id='block-TcoRtQ-uf9']/div[@id='block-nInSf-_rzA']/div[@id='block-W4qa6DVWM4']/div[@id='module_add_to_cart']/div[1]/button[2]");

    public FlashSalePage(WebDriver driver){
        this.driver=driver;
    }
}

