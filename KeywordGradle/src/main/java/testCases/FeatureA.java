package testCases;
import java.util.Set;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.BaseTestClass;
import util.TestCaseMapper;
public class FeatureA extends BaseTestClass {

	@BeforeTest
	public void setTheTestCaseLevelSettings() {

	}

	@Test
	public void Test1() {

		String sheet = this.getClass().getSimpleName();
		System.out.println(sheet);
		excelutil.createWorkBook(TestCaseMapper.excelPath);
		excelutil.setSheet(sheet);
		int a = excelutil.noOfCellsinColumn(0);
		System.out.println(a);
		testcaseMap = excelutil.getTestCaseMap(0);
		Set<Integer> keySet = testcaseMap.keySet();
		for (Integer key : keySet) {
			// System.out.println("The key is " + key + " and the value is " +
			// testcaseMap.get(key));
			int testStepStarts = key + 1;
			while (!excelutil.getCellData(testStepStarts, TestCaseMapper.Keyword).isEmpty()) {
				performAction(testStepStarts, excelutil.getCellData(testStepStarts, TestCaseMapper.Keyword));
				testStepStarts++;
			}
		}
	}

	@Test
	public void test2() {

		homePage.getRequiredMethod("linkLogin");
	}
}
