package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.PageDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Utilities;

public class P1_HomePage extends Utilities {

	public P1_HomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(PageDriver.getCurrentDriver()), this);
	}

	public By contactlistBy = By.id("com.android.dialer:id/contact_name");
	
	/*
	 * @AndroidFindBy(id = "com.android.dialer:id/contact_name") public
	 * List<WebElement> contacList;
	 */
	 
	@AndroidFindBy(id = "com.android.dialer:id/contacts_tab")
	public WebElement contacts;

	@AndroidFindBy(xpath = "//*[@text='First name']")
	public WebElement firstname; // public List<WebElement> name; -->for FindByElements

	@AndroidFindBy(id = "com.android.contacts:id/editor_menu_save_button")
	public WebElement btnSave;

	@AndroidFindBy(xpath = "//*[@text='Create new contact']")
	public WebElement btnCreateNewContact;
	@AndroidFindBy(xpath = "//*[@text='Name 9']")
	public WebElement name;

	/*
	 * @AndroidFindBy(xpath="//*[@text='Male']") public WebElement maleOption;
	 * 
	 * @AndroidFindBy(xpath="//*[@text='Bangladesh']") public WebElement
	 * ChooseCountryBangladesh;
	 */
	public void createNewContact(String name) throws InterruptedException {
		System.out.println("Trying to create a new contact");
		btnCreateNewContact.click();
		firstname.sendKeys(name);
		Thread.sleep(1000);
		btnSave.click();
		Thread.sleep(1000);
		PageDriver.getCurrentDriver().navigate().back();
	}

	public void scrollTesst() throws InterruptedException {
		//scrollDown(.5, .4);
		//scrollToTextNClick(contactlistBy, "Name 9");
		//scrollToTextNClick(name);
		scrollToText("Name 9");

	}

}
