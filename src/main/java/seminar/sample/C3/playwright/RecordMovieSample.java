package seminar.sample.C3.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RecordMovieSample {

	public static void main(String[] args) throws Exception {
		try (Playwright playwright = Playwright.create()) {
			BrowserType chromium = playwright.chromium();
			Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false)); // ヘッドフルモード
			// ブラウザコンテキストの設定で動画記録のオプションを指定
			Browser.NewContextOptions options = new Browser.NewContextOptions();
			options.setRecordVideoDir(Paths.get("videos/"));
			BrowserContext context = browser.newContext(options);

			// コンテキストからページを作成
			Page page = context.newPage();
			page.navigate("https://www.google.co.jp");
			Locator inputBox = page.locator("textarea[name='q']");
			inputBox.fill("Javaのライブラリ");
			Thread.sleep(1000);
			page.getByLabel("Google 検索").first().click();

			Thread.sleep(5000);
			context.close();

		}
	}
}
