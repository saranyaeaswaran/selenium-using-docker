

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeFireFoxDockerTest {
	
	@Test
    public void runChromeTestOnDocker() throws Exception {
		
		URL url;
		url = new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		RemoteWebDriver remoteDriver = new RemoteWebDriver(url, capabilities);
		remoteDriver.get("https://www.google.com");
		System.out.println("In Chrome : "+remoteDriver.getTitle());
		remoteDriver.quit();
		
	}
	
	@Test
    public void runFFTestOnDocker() throws Exception {
		
		URL url;
		url = new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		RemoteWebDriver remoteDriver = new RemoteWebDriver(url, capabilities);
		remoteDriver.get("https://www.google.com");
		System.out.println("In Firefix : "+remoteDriver.getTitle());
		remoteDriver.quit();
		
	}

}
