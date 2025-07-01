package cc.elvea.boot.crawler;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Proxy;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class PlaywrightTests {
    @Test
    public void test() {
        Proxy proxy = new Proxy("http://127.0.0.1:7890");
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setProxy(proxy);

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.webkit().launch(options);
            Page page = browser.newPage();
            page.navigate("https://www.tiktok.com/login");
            page.waitForTimeout(5000L);
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
        }
    }
}
