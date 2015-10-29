package org.sitea.downloader;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.List;
import java.util.NoSuchElementException;

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

	public String adresse() {
		try {
			List<WebElement> es = driver
					.findElements(By.cssSelector("table[border='0'][cellspacing='0'][cellpadding='1']"));
			WebElement section1 = es.get(0);
			WebElement el = section1.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(2)"));
			String adr = el.getText();
			String adrWithoutCarriageReturn = adr.replaceAll("[\n\r]", " ");
			return adrWithoutCarriageReturn;
		} catch (NoSuchElementException e) {
			return "";
		}
	}

}
