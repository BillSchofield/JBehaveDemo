package org.jbehave.demo.stories;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.demo.steps.BeforeAndAfterSteps;
import org.jbehave.demo.steps.VacationBalanceSteps;
import org.jbehave.demo.steps.VacationBalancePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class VacationBalanceStories extends JUnitStory {

    @Override
    public Configuration configuration() {
        try {
            URL test = new File("test").toURI().toURL();
            LoadFromRelativeFile storyLoader = new LoadFromRelativeFile(test);
            return new MostUsefulConfiguration()
                    .useStoryLoader(storyLoader)
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

        VacationBalancePage vacationBalancePage = new VacationBalancePage(driver);
        return new InstanceStepsFactory(configuration(),
                new BeforeAndAfterSteps(driver, vacationBalancePage),
                new VacationBalanceSteps(vacationBalancePage)
        );
    }

}
