package org.sitea.downloader;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.WebDriver;

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

}
