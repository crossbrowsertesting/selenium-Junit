<h1><strong>Getting Started with Junit and CrossBrowserTesting in Eclipse</strong></h1>
<p><em>For this document, we provide an example test located in our <a href="https://github.com/crossbrowsertesting/selenium-Junit">JUnit Github Repository</a>.</em></p>
<p><a href="https://junit.org/junit5/">JUnit</a> is a Java unit testing framework that is useful for creating scalable and repeatable tests. <a href="https://www.eclipse.org/">Eclipse</a> is a widely used Java integrated development environment (<em>IDE</em>) containing a comprehensive workspace for user's code development needs.</p>
<p>In this guide we will use JUnit with Eclipse for testing using the <a href="https://www.seleniumhq.org/">Selenium Webdriver</a> and <a href="https://www.java.com/en/">Java</a> programming language.</p>
<h3>Setting up Eclipse</h3>
<ol>
<li>Download and install <a href="https://www.eclipse.org/downloads/packages/">Eclipse IDE for Java Developers</a><img src="http://help.crossbrowsertesting.com/wp-content/uploads/2019/08/download_eclipse.png"></li>
<li>After installing is complete, launch Eclipse<img src="http://help.crossbrowsertesting.com/wp-content/uploads/2019/08/eclipse_welcome.png"></li>
<li>Select <strong>Create a new Java project&nbsp;</strong><img src="http://help.crossbrowsertesting.com/wp-content/uploads/2019/08/new_project.png"></li>
</ol>
<h3>Running a test</h3>
<div class="blue-alert">You’ll need to use your Username and Authkey to run your tests on CrossBrowserTesting. To get yours, sign up for a&nbsp;<a href="https://crossbrowsertesting.com/freetrial"><b>free trial</b></a>&nbsp;or purchase a&nbsp;<a href="https://crossbrowsertesting.com/pricing"><b>plan</b></a>.</div>
<ol>
<li>Download <a href="https://docs.seleniumhq.org/download/">Selenium WebDriver for Java</a><img src="http://help.crossbrowsertesting.com/wp-content/uploads/2019/08/selenium_for_java.png"></li>
<li>Add the Selenium jars to the build path of your project
<ul>
<li>Right click your project folder and select <strong>Properties</strong><img src="http://help.crossbrowsertesting.com/wp-content/uploads/2019/08/eclipse_properties_1.png"></li>
<li>From the <strong>Java Build Path</strong> tab, select the <strong>Libraries</strong> tab<img src="http://help.crossbrowsertesting.com/wp-content/uploads/2019/08/eclipse_build_path.png"></li>
<li>Select <strong>Add External JARs</strong> and add all jars for Selenium<img src="http://help.crossbrowsertesting.com/wp-content/uploads/2019/08/eclipse_add_jars.png"><img src="http://help.crossbrowsertesting.com/wp-content/uploads/2019/08/eclipse_add_jars_1.png"></li>
<li><strong>Apply and Close</strong></li>
</ul>
</li>
<li>Create a new JUnit Test Case
<ul>
<li>Right click your project folder</li>
<li>Hover over <strong>New&nbsp;</strong>and select <strong>JUnit Test Case</strong><img src="http://help.crossbrowsertesting.com/wp-content/uploads/2019/08/eclipse_junit_testcase.png"></li>
<li>Name your test case and select <strong>Finish</strong><img src="http://help.crossbrowsertesting.com/wp-content/uploads/2019/08/eclipse_new_junit.png"></li>
<li>Select <strong>OK</strong> to add JUnit to the build path<img src="http://help.crossbrowsertesting.com/wp-content/uploads/2019/08/eclipse_add_junit.png"></li>
</ul>
</li>
<li>Copying the following content:
<pre><code>import static org.junit.jupiter.api.Assertions.*;
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
	        String username = "YOUR_USERNAME";
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
</code></pre>
</li>
<li>Run your test by selecting the <strong>Run</strong> button<img src="http://help.crossbrowsertesting.com/wp-content/uploads/2019/08/eclipse_run.png"></li>
</ol>
<p>Congratulations! You have successfully integrated CBT and JUnit using Eclipse. Now you are ready to see your build start to run in the <a href="https://app.crossbrowsertesting.com/selenium/results">Crossbrowsertesting app</a>.</p>
<h3>Conclusions</h3>
<p>By following the steps outlined in this guide, you are now able to seamlessly integrate JUnit and CrossBrowserTesting. If you have any questions or concerns, please feel free to reach out to our <a href="mailto:support@crossbrowsertesting.com">support team</a>.</p>
