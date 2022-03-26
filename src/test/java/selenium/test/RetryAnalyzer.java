package selenium.test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (retryLimit > counter) {
			counter++;
			return true;
		}
		return false;
	}

}
