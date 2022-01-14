package test.com.br;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.awt.windows.ThemeReader;

import java.util.concurrent.TimeUnit;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drives/chromedriver.exe");
        if (browser == null) {
            this.browser = new ChromeDriver();
        } else {
            this.browser = browser;
        }
        this.browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void fechar() {
        this.browser.quit();
    }
    public void esperarCarregar() throws InterruptedException {
        Thread.sleep(3000);

    }
}
