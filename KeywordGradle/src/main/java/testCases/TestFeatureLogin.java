/*package testCases;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import util.BaseTestClass;
public class TestFeatureLogin extends BaseTestClass {

	@Test
	public void testLogin() {

		getDriver().get("https://www.phptravels.net/");
		homePage.getDropdownMyAccount().click();
		homePage.getLinkLogin().click();
		loginPage.getInputUserName().sendKeys("user@phptravels.com");
		loginPage.getInputPassword().sendKeys("demouser");
		loginPage.getButtonLogin().click();
		explicitWait(30, "titleContains", "My Account");
		System.out.println(getDriver().getTitle());
		assertTrue(getDriver().getTitle().contains("My Account"), "The test case failed as the title is not correct.");
	}
}
*/
