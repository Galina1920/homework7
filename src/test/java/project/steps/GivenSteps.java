package project.steps;

import cucumber.api.java.en.Given;
import project.actions.CommonActions;
import project.brovser.Driver;
import project.pages.RoofArtPage;

import java.util.concurrent.TimeUnit;

import static project.brovser.Driver.getDriver;

public class GivenSteps {

    RoofArtPage roofArtPage = new RoofArtPage(getDriver());
    CommonActions commonActions = new CommonActions();

    @Given("user is at {string} page")
    public void userOpenLink(String pageLink){
        Driver.getDriver().get(pageLink);
    }


    @Given("user click on menu button")
    public void userClickMenuButton () {
        roofArtPage.getMenuButton().click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Given("user select {string} item")
    public void userSelectItem (String itemName){
        commonActions.waitUntilElementDisplayed(roofArtPage.getProductListItemByName(itemName));
        roofArtPage.getProductListItemByName(itemName).click();
    }
}
