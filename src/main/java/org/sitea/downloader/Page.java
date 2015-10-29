package org.sitea.downloader;

import org.openqa.selenium.WebDriver;

public abstract class Page {

	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	abstract void isAt();

}
