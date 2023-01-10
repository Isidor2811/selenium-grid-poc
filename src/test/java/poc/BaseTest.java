package poc;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePage;

public class BaseTest {

  @BeforeMethod(alwaysRun = true)
  @Parameters(value = "browser")
  public void startBrowser(@Optional("chrome") String browser) throws MalformedURLException {
    BrowserOptionsFactory optionsFactory = new BrowserOptionsFactory();
    WebDriver driver = new RemoteWebDriver(
        new URL("http://localhost:4444"), optionsFactory.getBrowserOptions(browser));
    BasePage.setDriverThreadLocal(driver);
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    if (BasePage.getDriver() != null) {
      BasePage.getDriver().quit();
    }
    if (BasePage.getDriverThreadLocal() != null) {
      BasePage.getDriverThreadLocal().remove();
    }
  }

}
