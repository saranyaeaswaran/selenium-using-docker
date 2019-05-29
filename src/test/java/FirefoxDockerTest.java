

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FirefoxDockerTest {
	
	
	@Test
    public void runFFTestOnDocker() throws Exception {
		
		//For running the tests remotely we have to use Remote Web driver which takes URL and Capabilities as arguments. URL should be which URL the remote driver should listen to. The browser will not open in this case but will be running in the remotedriver.		
		URL url;
		url = new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		RemoteWebDriver remoteDriver = new RemoteWebDriver(url, capabilities);
		remoteDriver.get("https://www.google.com");
		System.out.println(remoteDriver.getTitle());
		remoteDriver.wait(10000);
		System.out.println("FF wait ended");
		remoteDriver.quit();
	}

}
