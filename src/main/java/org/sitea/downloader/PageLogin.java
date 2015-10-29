package org.sitea.downloader;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLogin extends Page {

	public PageLogin(WebDriver driver) {
		super(driver);
	}

	@Override
	void isAt() {
		await().atMost(3, SECONDS).until(() -> {
			return login() != null;
		});
	}

	public WebElement login() {
		return driver.findElement(By.cssSelector("input.login_password[name='log_email']"));
	}

	public WebElement pass() {
		return driver.findElement(By.cssSelector("input.login_password[name='log_pass']"));
	}

	public WebElement submit() {
		return driver.findElement(By.cssSelector(".bouton_connexion"));
	}

}
