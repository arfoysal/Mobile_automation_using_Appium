package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import base.PageDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utilities {
	public void scrollDown(double d, double e) {
		Dimension dimension = PageDriver.getCurrentDriver().manage().window().getSize();
		int scrollStart = (int) (dimension.getHeight() * d);
		int scrollEnd = (int) (dimension.getHeight() * e);

		new TouchAction<>((PerformsTouchActions) PageDriver.getCurrentDriver())
				.press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(0, scrollEnd))
				.release().perform();
	}

	public void scrollToTextNClick(By listItems, String text) throws InterruptedException {
		boolean flag = false;
		while (!flag) {
			for (WebElement element : PageDriver.getCurrentDriver().findElements(listItems)) {
				if (element.getAttribute("text").equals(text)) {
					element.click();
					flag = true;
					break;
				}
			}
			if (!flag) {
				scrollDown(0.5, 0.2);

			}

		}

	}

	public void scrollToTextNClick(WebElement element) {
		int retry = 0;
		while (retry < 15) {
			try {
				element.click();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				scrollDown(0.5, .2);
				retry++;
			}
		}
	}

	public void scrollToText(String text) {
		((AndroidDriver<WebElement>) PageDriver.getCurrentDriver())
				.findElementByAndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"" + text + "\"));")
				.click();
		;

	}

}
