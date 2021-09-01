package project.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class TiglaMetalicaClasicaPage {

    private WebDriver driver;

    @FindBy(xpath = "//h2[contains(@class, 'main-title full')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[contains(@href, '/ro/products/tigla-metalica-arctica')]")
    private WebElement firstProduct ;

    @FindBy(xpath = "// a[contains(@href, '/ro/products/tigla-metalica-nordica-clasica')]")
    private WebElement secondProduct;

//h4[contains(@class, 'h4')] titlul pentru ambele produse



    public TiglaMetalicaClasicaPage(WebDriver driver1){
        this.driver=driver1;
        PageFactory.initElements(driver1,this);
    }

}
