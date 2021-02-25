package com.synaptic.library.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/synaptic/library/step_definitions",
        publish = true,
        tags="@smokeTest",
        dryRun = false
)
public class CukeRunner {


}
