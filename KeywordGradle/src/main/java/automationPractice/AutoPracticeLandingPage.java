package automationPractice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AutoPracticeLandingPage {

	@FindBy(css = "a.logout")
    private WebElement linkSignOut;

	

	public WebElement getAutoPracticeLandingPageElements(String elementName) {

		switch (elementName) {
			case "linkSignOut" :
				return linkSignOut;
			default :
				return null;
		}
	}
}
