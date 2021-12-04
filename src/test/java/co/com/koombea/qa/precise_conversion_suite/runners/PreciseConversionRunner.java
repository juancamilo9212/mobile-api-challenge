package co.com.koombea.qa.precise_conversion_suite.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                /*"src/test/resources/features/preciseConversion.feature",*/
                "src/test/resources/features/rickAndMorty.feature"
        },
        glue = "co.com.koombea.qa.precise_conversion_suite.step_definitions",
        snippets = SnippetType.CAMELCASE
)
public class PreciseConversionRunner {
}
