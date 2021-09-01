package project.steps;

import cucumber.api.java.en.When;
import project.actions.CommonActions;
import project.pages.RoofArtPage;
import static project.brovser.Driver.getDriver;

public class WhenSteps {

    RoofArtPage roofArtPage = new RoofArtPage(getDriver());
    CommonActions commonActions = new CommonActions();

    @When("user select {string} product from list")
    public void userSelectProduct (String productName) {
        commonActions.scrollToElement(roofArtPage.getProductByName(productName));
        roofArtPage.clickOnProductDetailsByName(productName);
    }

}
