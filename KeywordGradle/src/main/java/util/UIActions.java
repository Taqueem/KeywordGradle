package util;
import org.openqa.selenium.WebElement;
public class UIActions extends BaseTestClass {

	public static void sendKeys(String argumnets, WebElement element) {

		element.sendKeys(argumnets);
	}

	public static void click(WebElement element) {

		element.click();
	}

	public static void navigateTo(String url) {

		getDriver().get(url);
	}
}
