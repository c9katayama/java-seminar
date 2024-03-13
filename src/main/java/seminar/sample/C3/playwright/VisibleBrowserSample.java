package seminar.sample.C3.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleBrowserSample {

	public static void main(String[] args) throws Exception {
		try (Playwright playwright = Playwright.create()) {
			BrowserType browerType = playwright.chromium();
			Browser browser = browerType.launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			page.navigate("https://www.google.co.jp");
			Locator inputBox = page.locator("textarea[name='q']");
			inputBox.fill("Javaのライブラリ");
			page.getByLabel("Google 検索").first().click();

			Thread.sleep(5000);
			browser.close();
		}
	}
}
