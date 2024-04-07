package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoeListPage {
    final WebDriver driver;
    public By mensFashionLocator=By.cssSelector("#Level_1_Category_No9");
    public By shoeLocator=By.xpath("//body/div[@id='J_2553362700']/div[@id='J_LzdSiteNav']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/ul[3]/li[3]");
    public By sneakerLocator=By.xpath("//body/div[@id='J_2553362700']/div[@id='J_LzdSiteNav']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/ul[3]/li[3]/ul[1]/ul[1]/li[3]");
    public By sneakerNameLocator=By.xpath(" //div[@class='title-wrapper--IaQ0m']");
    public By sneakerPriceLocator=By.xpath(" //div[@class='current-price--Jklkc']");
    public By sizeLocator=By.cssSelector(" body.pdp-layout-column-2:nth-child(2) div.pdp-block div.pdp-block.pdp-block__main-information:nth-child(3) div.pdp-block.pdp-block__main-information-detail:nth-child(2) div.pdp-block div.pdp-block.pdp-block__product-detail:nth-child(1) div.pdp-block.module:nth-child(12) div.sku-selector div.sku-prop:nth-child(2) div.pdp-mod-product-info-section.sku-prop-selection div.section-content div.sku-prop-content > span.sku-variable-size:nth-child(1)");
    public By quantityLocator=By.xpath(" //body/div[@id='container']/div[@id='root']/div[@id='block-_4sUzDww8j']/div[@id='block-TcoRtQ-uf9']/div[@id='block-nInSf-_rzA']/div[@id='block-W4qa6DVWM4']/div[@id='module_quantity-input']/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]");
    public By cartLocator=By.xpath(" //body/div[@id='container']/div[@id='root']/div[@id='block-_4sUzDww8j']/div[@id='block-TcoRtQ-uf9']/div[@id='block-nInSf-_rzA']/div[@id='block-W4qa6DVWM4']/div[@id='module_add_to_cart']/div[1]/button[2]");

    public ShoeListPage(WebDriver driver){
        this.driver=driver;
    }
}

