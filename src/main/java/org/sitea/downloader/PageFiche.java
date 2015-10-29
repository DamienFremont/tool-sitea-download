package org.sitea.downloader;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageFiche extends Page {

	public PageFiche(WebDriver driver) {
		super(driver);
	}

	@Override
	void isAt() {
		await().atMost(30, SECONDS).until(() -> {
			return driver.getCurrentUrl().contains("fiche");
		});
	}

	public String titre() {
		try {
			return driver.findElement(By.cssSelector(".titreindex")).getText();
		} catch (NoSuchElementException e) {
			return "";
		}
	}

}
