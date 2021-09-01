package project.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class TiglaMetalicaArcticaClasicaPage {
    private WebDriver driver;

    @FindBy(xpath = "//h2[contains(@class, 'main-title')]") //este pt mai multe sectii
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(@class, 'specifications-header')]")
    private WebElement specifications;

    @FindBy(xpath = "//div[contains(@class, 'specifications-content')]")
    private WebElement specificationsBlock;


    //span[contains(@class, 'gray')] toate cifrele cu sur

    //div[contains(@class, 'specifications-item')]

    public TiglaMetalicaArcticaClasicaPage(WebDriver driver1){
        this.driver=driver1;
        PageFactory.initElements(driver1,this);
    }

    public List<WebElement> getSpecificationBlock(){
        return specificationsBlock.findElements(By.xpath(" //div[contains(@class, 'specifications-item')]"));
    }

    public WebElement getSpecificationText(String specificationText){
        return getSpecificationBlock().stream()
                .filter(element -> element.getText().equalsIgnoreCase(specificationText))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("specifications does not exist - " + specificationText));
    }

}
