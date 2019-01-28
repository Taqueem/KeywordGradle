package automationPractice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AutoPracticeHomePage {

	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	private WebElement linkSignIn;

	public WebElement getAutoPracticeHomePageElements(String elementName) {

		switch (elementName) {
			case "linkSignIn" :
				return linkSignIn;
			default :
				return null;
		}
	}
}
