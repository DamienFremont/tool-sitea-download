package org.sitea.downloader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;

public class MainJob {

	private WebDriver driver;

	void execute(String target, String url, String login, String pass) {
		try {
			driver = driverInit();
			System.out.println("starting at " + url);

			// LOGIN

			driver.get(url);
			PageLogin pageLogin = new PageLogin(driver);

			pageLogin.isAt();

			System.out.println(login);
			System.out.println(pass);
			pageLogin.login().sendKeys(login);
			pageLogin.pass().sendKeys(pass);
			pageLogin.submit().click();

			// HOME

			// PageHome pageHome = new PageHome(driver);
			// pageHome.isAt();
			//
			// pageHome.menuAnnuaire().click();

			// ANNUAIRE

			driver.get(url + "/ensim-alumni_annuaire.html");
			PageAnnuaire pageAnnuaire = new PageAnnuaire(driver);
			pageAnnuaire.isAt();

			List<String> personneUris = pageAnnuaire.personneUris();
			System.out.println(personneUris);
			for (String uri : personneUris) {
				System.out.println(uri);
				driver.get(url + "/" + uri);
				
//				Page
			}

		} catch (Exception e) {
			takeScreenshot(target);
			System.out.println("error at " + url);
			Throwables.propagate(e);
		} finally {
			driver.quit();
		}
	}

	private void takeScreenshot(String target) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(target + "/screenshot_failed.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	WebDriver driverInit() {
		driver = new PhantomJSDriver(
				new DesiredCapabilities(ImmutableMap.of(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
						new PhantomJsDownloader().downloadAndExtract().getAbsolutePath())));
		// driver.manage().timeouts().implicitlyWait(10, SECONDS);
		return driver;
	}
}
