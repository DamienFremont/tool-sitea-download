package org.sitea.downloader;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageAnnuaire extends Page {

	public PageAnnuaire(WebDriver driver) {
		super(driver);
	}

	@Override
	void isAt() {
		await().atMost(3, SECONDS).until(() -> {
			String url = driver.getCurrentUrl();
			return url.contains("ensim-alumni_annuaire.html");
		});
	}

}
