 import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

class BasicExample {

	  private WebDriver driver;

	    @BeforeEach
	    void setUp() throws Exception {
	        String username = "YOUR_USERNAME"; //be sure to replace the @ symbol with %40 in your username
	        String authkey = "YOUR_AUTHKEY";
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("version", "76");
	        capabilities.setCapability("platform", "WINDOWS");
	        capabilities.setCapability("name", "Junit Example");
	        capabilities.setCapability("browserName", "Chrome");
	        capabilities.setCapability("record_video", true);

	        String hubAddress = String.format("http://%s:%s@hub.crossbrowsertesting.com:80/wd/hub", username, authkey);
	        URL url = new URL(hubAddress);

	        driver = new RemoteWebDriver(url, capabilities); 
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    }

	    @AfterEach
	    void tearDown() throws Exception {
	        driver.quit();
	    
	    }

	    @Test
	    void test() {
	        
	        driver.get("http://www.google.com");
	        assertEquals("Google", driver.getTitle());
	    
	    }

}
