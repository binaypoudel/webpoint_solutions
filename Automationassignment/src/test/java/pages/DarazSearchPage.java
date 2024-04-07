package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DarazSearchPage {
    final WebDriver driver;
    public By searchLocator=By.xpath("//input[@id='q']");
    public By searchListLocator=By.xpath("//div[@class='search-box__popup--3Pf1']//a[@class='suggest-common--2KmE ']");
    public By priceListLocator=By.xpath("//div[@class='current-price--Jklkc']");
    public By cartLocator=By.xpath("//body/div[@id='container']/div[@id='root']/div[@id='block-dFw8WZ-Pxj']/div[@id='block-gz6-yWDPy6']/div[@id='block-PTQ9ARrhnd']/div[@id='block-pZ-AGMz7zM']/div[@id='module_add_to_cart']/div[1]/button[2]");
    public By goTolLocator=By.xpath("//button[contains(text(),'GO TO CART')]");
    public By checkoutLocator=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT (1)')]");
    public By placeOrderLocator=By.xpath(" //button[contains(text(),'Place Order')]");




    //public By closeCartLocator=By.cssSelector("body.pdp-layout-column-2:nth-child(2) div:nth-child(27) div.next-overlay-wrapper.next-dialog-wrapper.cart-dialog-wrapper.automation-cart-popup.opened div.next-dialog.right.next-overlay-inner.animated.fadeInDown.cart-dialog.next-position-cc > a.next-dialog-close");





    public DarazSearchPage(WebDriver driver){
        this.driver=driver;
    }
}
