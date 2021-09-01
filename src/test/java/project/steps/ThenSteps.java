package project.steps;

import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import project.brovser.Driver;
import project.data.RoofArtProductSpecificationsData;
import project.pages.RoofArtPage;
import java.util.List;

public class ThenSteps {

    RoofArtPage roofArtPage = new RoofArtPage(Driver.getDriver());

    @Then("next specifications are displayed")
    public void getSpecificationDetails (DataTable dataTable){
        List<RoofArtProductSpecificationsData> movieSpecification = dataTable.asList(RoofArtProductSpecificationsData.class);

        for (RoofArtProductSpecificationsData specificationData : movieSpecification) {
            Assert.assertEquals("specification details are equal", specificationData.getSpecification(),
                    roofArtPage.getSpecificationValueBySpecificationTitle(specificationData.getSpecificationTitle()));
        }
        for (RoofArtProductSpecificationsData specificationData : movieSpecification) {
            System.out.println(specificationData.getSpecificationTitle() + ":" +
                    roofArtPage.getSpecificationValueBySpecificationTitle(specificationData.getSpecificationTitle()));
        }

    }

}
