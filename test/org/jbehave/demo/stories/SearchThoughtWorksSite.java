package org.jbehave.demo.stories;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.demo.steps.AboutUsPage;
import org.jbehave.demo.steps.BeforeAndAfterSteps;
import org.jbehave.demo.steps.BioPage;
import org.jbehave.demo.steps.Search;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.net.MalformedURLException;

public class SearchThoughtWorksSite extends JUnitStory {

    @Override
    public Configuration configuration() {
        try {
            return new MostUsefulConfiguration()
                    .useStoryLoader(new LoadFromRelativeFile(new File("test").toURI().toURL()))
                            .usePendingStepStrategy(new FailingUponPendingStep())
                            .useStoryReporterBuilder(
                                    new StoryReporterBuilder()
                                            .withDefaultFormats());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        WebDriver driver = new FirefoxDriver();
        return new InstanceStepsFactory(configuration(),
                new BeforeAndAfterSteps(driver),
                new AboutUsPage(driver),
                new Search(driver),
                new BioPage(driver)
        );
    }

}
