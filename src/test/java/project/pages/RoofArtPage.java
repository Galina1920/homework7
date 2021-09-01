package project.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


@Getter
public class RoofArtPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'burger-menu-block burger-animation')]")
    private WebElement menuButton;

    @FindBy(xpath = "//div[contains(@class, 'items')]//a[contains(@class, 'product-item')]")
    private List <WebElement> itemsList;

    @FindBy(xpath = "//div[contains(@class, 'category-page-item')]")
    private  List <WebElement> productsList ;

    @FindBy(xpath = "//div[contains(@class, 'specifications-item')]")
    private List <WebElement> productSpecifications;

    public RoofArtPage(WebDriver driver1){
        this.driver=driver1;
        PageFactory.initElements(driver1,this);
    }

    public WebElement getMenuButton () {
        return menuButton;
    }


    public WebElement getProductListItemByName(String itemName){
        return itemsList.stream().filter(element -> element.getText().equalsIgnoreCase(itemName))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Such item does not exist - " + itemName));
    }

    public WebElement getProductByName(String productName){
        return productsList.stream()
                .filter(element -> element.findElement(By.tagName("h4")).getText().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Such product does not exists - " + productName));
    }

    public void clickOnProductDetailsByName(String productName) {
        getProductByName(productName).findElement(By.tagName("a")).click();
    }

    public String getSpecificationValueBySpecificationTitle(String specificationTitle) {
        WebElement specification = productSpecifications.stream()
                .filter(element -> element.findElement(By.tagName("span")).getText().equals(specificationTitle))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Such specification title does not exist - " + specificationTitle));

        return specification.findElement(By.className("gray")).getText();
    }

}
