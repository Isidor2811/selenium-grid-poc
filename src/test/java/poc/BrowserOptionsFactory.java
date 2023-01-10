package poc;

import org.openqa.selenium.Capabilities;

public class BrowserOptionsFactory {

  public Capabilities getBrowserOptions(String browser) {
    switch (browser) {
      case "chrome":
        return BrowserOptions.getChromeOptions();
      case "firefox":
        return BrowserOptions.getFireFoxOptions();
      default:
        throw new IllegalStateException("Unexpected value: " + browser);
    }
  }

}
