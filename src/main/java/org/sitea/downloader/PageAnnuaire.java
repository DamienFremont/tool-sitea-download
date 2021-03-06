package org.sitea.downloader;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageAnnuaire extends Page {

	public PageAnnuaire(WebDriver driver) {
		super(driver);
	}

	@Override
	void isAt() {
		await().atMost(30, SECONDS).until(() -> {
			return personnesField() != null;
		});
	}

	public List<String> personneUris() {
		String urlPreffix = "ensim-alumnus_fiche.html?alu=1&id=";
		WebElement e = personnesField();
		String val = e.getAttribute("value");
		System.out.println(val);
		String[] array = val.split(",");
		List<String> list = Arrays.asList(array);
		List<String> urls = list.stream().map(i -> {
			return urlPreffix + i;
		}).collect(Collectors.toList());
		return urls;
	}

	private WebElement personnesField() {
		return driver.findElement(By.cssSelector("input[name='ListeId']"));
	}

}
