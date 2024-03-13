package seminar.sample.C3.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScreenshotSample {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			// Chromiumを指定
			BrowserType browerType = playwright.chromium();
			Browser browser = browerType.launch();
			// 新しいページを開く
			Page page = browser.newPage();
			// 指定URLに遷移
			page.navigate("https://www.google.co.jp");
			// HTMLからテキストボックスを選択
			Locator inputBox = page.locator("textarea[name='q']");
			// テキスト入力
			inputBox.fill("Javaのライブラリ");
			// 検索ボタンをクリック
			page.getByLabel("Google 検索").first().click();
			// 検索結果をスクリーンショットに納める
			page.screenshot(new Page.ScreenshotOptions().setFullPage(true)
					.setPath(Paths.get("screenshot-" + browerType.name() + ".png")));
			browser.close();
		}
	}
}
