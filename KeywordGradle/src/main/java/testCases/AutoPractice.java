package testCases;
import java.util.Set;

import org.testng.annotations.Test;

import util.BaseTestClass;
import util.TestCaseMapper;
public class AutoPractice extends BaseTestClass {

	@Test
	public void Test1() {

		String sheet = this.getClass().getSimpleName();
		System.out.println(sheet);
		excelutil.createWorkBook(TestCaseMapper.excelPath);
		excelutil.setSheet(sheet);
		int a = excelutil.noOfNotEmptyCellsinColumn(0);
		System.out.println(a);
		testcaseMap = excelutil.getTestCaseMap(0);
		Set<Integer> keySet = testcaseMap.keySet();
		for (Integer key : keySet) {
			// System.out.println("The key is " + key + " and the value is " +
			// testcaseMap.get(key));
			int testStepStarts = key;
			while (!(excelutil.getCellData(testStepStarts, TestCaseMapper.Keyword).isEmpty())) {
				performAction(testStepStarts, excelutil.getCellData(testStepStarts, TestCaseMapper.Keyword));
				testStepStarts++;
			}
		}
	}

	@Test(dataProvider = "noOfTests")
	public void Test2(int rowNum) {

		System.out.println("Executing  test for " + testcaseMap.get(rowNum));
		int testStepStarts = rowNum;
		while (!(excelutil.getCellData(testStepStarts, TestCaseMapper.Keyword).isEmpty())) {
			performAction(testStepStarts, excelutil.getCellData(testStepStarts, TestCaseMapper.Keyword));
			testStepStarts++;
		}
	}
}
