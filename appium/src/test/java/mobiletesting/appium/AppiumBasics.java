package mobiletesting.appium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseClass{

	@Test
	public void WifiSettingsName() {
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();

	}

}
