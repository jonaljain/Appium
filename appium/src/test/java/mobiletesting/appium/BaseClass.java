package mobiletesting.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AndroidDriver driver;
	public AppiumDriverLocalService appiumServer;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		// Starting appium server
		appiumServer = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\Jonal\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		appiumServer.start();

		// capabilities setup
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Redmi");
		options.setApp("C:\\Testing\\Appium\\appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");

		// Setting Android driver
		driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/"), options);
	}

	@AfterClass
	public void tearDown() {
		//Quit the application
		driver.quit();
		//Stop the appium server	
		appiumServer.stop();
	}

}
