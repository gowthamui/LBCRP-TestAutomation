package test_runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"steps"},
        tags = { "@labcorp_search" },
        features={ "src/test/resources/features/labcorpSearch.feature" },
        plugin = { "pretty", "html:target/cucumber-reports/LabCorpJobSearchTest/"}
)
public class LabCorpJobSearchTest extends BaseTestRunner{

}
