package org.sitea.downloader;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageHome extends Page {

	public PageHome(WebDriver driver) {
		super(driver);
	}

	@Override
	void isAt() {
		await().atMost(3, SECONDS).until(() -> {
			String url = driver.getCurrentUrl();
			return url.contains("?alu=1");
		});
	}

	public WebElement menuAnnuaire() {
		return driver.findElement(By.cssSelector(".menu_gauche tr:nth-child(5) a.menu3"));
	}

}
