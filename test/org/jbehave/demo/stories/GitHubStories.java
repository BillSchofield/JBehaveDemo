package org.jbehave.demo.stories;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.io.StoryPathResolver;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.IdeOnlyConsoleOutput;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.demo.pages.LoginPage;
import org.jbehave.demo.steps.BeforeAndAfterSteps;
import org.jbehave.demo.steps.GithubLoginSteps;
import org.jbehave.demo.pages.LandingPage;
import org.json.XML;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.html.HTML;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.jbehave.core.reporters.StoryReporterBuilder.Format.CONSOLE;
import static org.jbehave.core.reporters.StoryReporterBuilder.Format.HTML;

public class GitHubStories extends JUnitStory {

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
                                            .withReporters(new IdeOnlyConsoleOutput())
                                            .withFormats(Format.IDE_CONSOLE)
                                            .withFailureTrace(true).withFailureTraceCompression(true)
                                            .withDefaultFormats());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        System.setProperty("webdriver.chrome.driver", "/Users/ThoughtWorker/Tools/chromedriver");
        WebDriver driver = new ChromeDriver();

        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        return new InstanceStepsFactory(configuration(),
                new BeforeAndAfterSteps(driver, landingPage),
                new GithubLoginSteps(landingPage, loginPage)
        );
    }

}
