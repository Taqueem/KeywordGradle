package phpTravelPages;
import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePage {

	/*	public HomePage(WebDriver driver) {
	
			PageFactory.initElements(driver, this);
		}*/
	@FindBy(xpath = "(//li[@id='li_myaccount'])[2]")
	private WebElement	dropdownMyAccount;

	@FindBy(xpath = "(//a[contains(text(),'Login')])[2]")
	private WebElement	linkLogin;

	@FindBy(xpath = "(//a[contains(text(),'Sign Up')])[2]")
	private WebElement	linkSignUp;
	/*	public WebElement getDropdownMyAccount() {
	
			return dropdownMyAccount;
		}
	
		public WebElement getlinkLogin() {
	
			return linkLogin;
		}
	
		public WebElement getLinkSignUp() {
	
			return linkSignUp;
		}*/

	public WebElement getHomePageElements(String object) {

		switch (object) {
			case "dropdownMyAccount" :
				return dropdownMyAccount;
			case "linkLogin" :
				return linkLogin;
			case "linkSignUp" :
				return linkSignUp;
			default :
				break;
		}
		return null;
	}

	public WebElement getRequiredMethod(String elementName) {

		WebElement elment1 = null;
		try {
			Method requiredMethod = null;
			Class c = HomePage.class;
			Method[] methods = c.getDeclaredMethods();
			for (Method method : methods) {
				String methodName = method.getName();
				if (methodName.contains(elementName)) {
					requiredMethod = method;
					break;
				}
			}
			Object element = requiredMethod.invoke(c, new Object[0]);
			elment1 = (WebElement) element;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elment1;
	}
}
