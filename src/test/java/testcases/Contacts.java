package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Base;
import pageObjects.P1_HomePage;

public class Contacts extends Base {

	@Test
	public void mySecondTest() throws IOException, InterruptedException {
		// AndroidDriver<AndroidElement> driver =capabilities();
		Thread.sleep(2000);
		// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Appium");

		P1_HomePage home = new P1_HomePage();
		// home.nameField.sendKeys("appium");
		/*
		 * home.getNameField().sendKeys("appium"); Thread.sleep(2000);
		 * 
		 * driver.hideKeyboard();
		 * 
		 * home.femaleOption.click(); home.maleOption.click();
		 * 
		 * home.dropDownClick.click();
		 */
		home.contacts.click();
		Thread.sleep(2000);

		// Automatically create contact
		for (int i = 4; i < 50; i++) {
			home.createNewContact("Name " + i);
			Thread.sleep(1000);
		}

		home.scrollTesst();
		Thread.sleep(2000);
	}

}
