package poc;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserOptions {

  public static ChromeOptions getChromeOptions() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-gpu");
    options.addArguments("---no-sandbox");
    options.addArguments("--headless");
    options.addArguments("--window-size=1920,1080");
    return options;
  }

  public static FirefoxOptions getFireFoxOptions() {
    FirefoxOptions options = new FirefoxOptions();
    FirefoxProfile profile = new FirefoxProfile();
    options.setHeadless(true);
    options.addArguments("--window-size=1920,1080");
    options.setLogLevel(FirefoxDriverLogLevel.INFO);
    profile.setAcceptUntrustedCertificates(true);
    options.setProfile(profile);
    return options;
  }

}
