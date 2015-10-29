package org.sitea.downloader;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageFiche extends Page {

	public PageFiche(WebDriver driver) {
		super(driver);
	}

	@Override
	void isAt() {
		await().atMost(30, SECONDS).until(() -> {
			return titre() != null;
		});
	}
	
	public WebElement titre() {
		return driver.findElement(By.cssSelector(".titreindex"));
	}

}
