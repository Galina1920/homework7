package project.configuration;

import cucumber.api.TypeRegistry;
import cucumber.runtime.DefaultTypeRegistryConfiguration;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import project.data.RoofArtProductSpecificationsData;

import java.util.Locale;

public class CostumTypeRegistryConfigurer extends DefaultTypeRegistryConfiguration {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(defineRoofArtProductSpecifications());

    }

    public DataTableType defineRoofArtProductSpecifications() {
        return new DataTableType(RoofArtProductSpecificationsData.class,
                (TableEntryTransformer<RoofArtProductSpecificationsData>) dataRow -> {

                    RoofArtProductSpecificationsData roofArtProductSpecificationsData = new RoofArtProductSpecificationsData();

                    roofArtProductSpecificationsData.setSpecificationTitle(dataRow.get("specificationTitle"));
                    roofArtProductSpecificationsData.setSpecification(dataRow.get("specification"));

                    return roofArtProductSpecificationsData;
                });
    }
}
