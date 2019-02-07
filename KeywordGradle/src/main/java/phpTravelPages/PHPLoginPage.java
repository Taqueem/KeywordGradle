package phpTravelPages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class PHPLoginPage {

	/*public LoginPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}*/
	@FindBy(css = "input[name='username']")
	public WebElement	inputUserName;

	@FindBy(css = "input[name='password']")
	public WebElement	inputPassword;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	public WebElement	buttonLogin;

	public WebElement getInputUserName() {

		return inputUserName;
	}

	public WebElement getInputPassword() {

		return inputPassword;
	}

	public WebElement getButtonLogin() {

		return buttonLogin;
	}

	public WebElement getLoginPageElement(String element) {

		switch (element) {
			case "inputUserName" :
				return inputUserName;
			case "inputPassword" :
				return inputPassword;
			case "buttonLogin" :
				return buttonLogin;
			default :
				break;
		}
		return null;
	}
}
