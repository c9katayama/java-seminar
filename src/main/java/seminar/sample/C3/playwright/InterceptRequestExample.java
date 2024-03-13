package seminar.sample.C3.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Route;

public class InterceptRequestExample {

	public static void main(String[] args) throws Exception {
		try (Playwright playwright = Playwright.create()) {
			BrowserType browerType = playwright.chromium();
			Browser browser = browerType.launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();

			page.navigate("https://www.google.co.jp");
			Locator inputBox = page.locator("textarea[name='q']");
			inputBox.fill("Javaのライブラリ");
			Thread.sleep(1000);

			// レスポンスを改変
			page.route("**/*", route -> {
				// カスタムレスポンスを返す
				route.fulfill(new Route.FulfillOptions().setStatus(200).setContentType("application/json")
						// カスタムレスポンスボディ
						.setBody("{\"custom\": \"response\"}"));
			});
			// 検索
			page.getByLabel("Google 検索").first().click();

			Thread.sleep(5000);
			browser.close();
		}
	}
}
