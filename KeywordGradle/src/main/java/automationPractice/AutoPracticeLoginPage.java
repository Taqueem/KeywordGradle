package automationPractice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AutoPracticeLoginPage {

	@FindBy(xpath = "//input[@id='email']")
	private WebElement	inputEmail;

	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement	inputPassword;

	@FindBy(xpath = "//button[@id='SubmitLogin']//span[1]")
	private WebElement	buttonSignIn;

	public WebElement getAutoPracticeLoginPageElements(String elementName) {

		switch (elementName) {
			case "inputEmail" :
				return inputEmail;
			case "inputPassword" :
				return inputPassword;
			case "buttonSignIn" :
				return buttonSignIn;
			default :
				return null;
		}
	}
}
