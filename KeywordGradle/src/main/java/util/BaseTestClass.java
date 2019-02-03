package util;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import automationPractice.AutoPracticeHomePage;
import automationPractice.AutoPracticeLoginPage;
import phpTravelPages.HomePage;
import phpTravelPages.LoginPage;
public class BaseTestClass {

	private static WebDriver				driver;

	private static WebDriverWait			explicitWait;

	protected static HomePage				homePage	= new HomePage();

	protected static LoginPage				loginPage	= new LoginPage();

	protected static AutoPracticeHomePage	aphomePage	= new AutoPracticeHomePage();

	protected static AutoPracticeLoginPage	aploginPage	= new AutoPracticeLoginPage();

	protected HashMap<Integer, String>		testcaseMap	= new HashMap<Integer, String>();

	Set<Integer>							keySet;

	protected static WebDriver getDriver() {

		if (driver == null) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\\\Selenium\\\\Driver\\\\geckodriver-v0.19.0-win64\\\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public void initializePage() {

		PageFactory.initElements(getDriver(), aploginPage);
		PageFactory.initElements(getDriver(), aphomePage);
		PageFactory.initElements(getDriver(), loginPage);
		PageFactory.initElements(getDriver(), homePage);
	}

	@BeforeTest
	public void beforeTest() {

		getDriver();
		initializePage();
		setExcelFile();
	}

	protected void explicitWait(int seconds, String condition, String generic) {

		explicitWait = new WebDriverWait(getDriver(), seconds);
		System.out.println("Value passed:" + generic);
		switch (condition) {
			case "titleContains" :
				String title = generic;
				explicitWait.until(ExpectedConditions.titleContains(title));
				break;
			/*case "visibilityOf" :
				WebElement element = (WebElement) generic;
				explicitWait.until(ExpectedConditions.visibilityOf(element));
				break;*/
			default :
				break;
		}
	}

	protected ExcelUtil excelutil = new ExcelUtil();

	public WebElement getElement(int rowNum) {

		String page = excelutil.getCellData(rowNum, TestCaseMapper.Page);
		String object = excelutil.getCellData(rowNum, TestCaseMapper.Object);
		if (page.equalsIgnoreCase("homePage"))
			return homePage.getHomePageElements(object);
		else if (page.equalsIgnoreCase("loginPage"))
			return loginPage.getLoginPageElement(object);
		else if (page.equalsIgnoreCase("aploginPage"))
			return aploginPage.getAutoPracticeLoginPageElements(object);
		else if (page.equalsIgnoreCase("aphomePage"))
			return aphomePage.getAutoPracticeHomePageElements(object);
		return null;
	}

	protected void performAction(int rowNum, String action) {

		switch (action) {
			case "navigateTo" :
				UIActions.navigateTo(excelutil.getCellData(rowNum, TestCaseMapper.Value));
				break;
			case "clickOn" :
				UIActions.click(getElement(rowNum));
				break;
			case "sendKeys" :
				UIActions.sendKeys(excelutil.getCellData(rowNum, TestCaseMapper.Value), getElement(rowNum));
				break;
			case "explicitWait" :
				explicitWait(30, excelutil.getCellData(rowNum, TestCaseMapper.Object), excelutil.getCellData(rowNum, TestCaseMapper.Value));
				break;
			default :
				break;
		}
	}

	protected void setExcelFile() {

		String sheet = this.getClass().getSimpleName();
		System.out.println(sheet);
		excelutil.createWorkBook(TestCaseMapper.excelPath);
		excelutil.setSheet(sheet);
	}

	@DataProvider(name = "noOfTests")
	protected Object[][] getNoOfTests() {

		/*String sheet = this.getClass().getSimpleName();
		System.out.println(sheet);
		excelutil.createWorkBook(TestCaseMapper.excelPath);
		excelutil.setSheet(sheet);*/
		Object[][] testData = null;
		testcaseMap = excelutil.getTestCaseMap(0);
		keySet = testcaseMap.keySet();
		int timesOfRepeat = keySet.size();
		int numOfParameter = 1;
		testData = new Object[timesOfRepeat][numOfParameter];
		int i = 0, j = 0;
		for (Integer key : keySet) {
			testData[i][j] = key;
			i++;
		}
		return testData;
	}
}
