package org.sitea.downloader;

import org.junit.Test;

public class MainTest {

	@Test
	public void test_args_url_ok() {
		Main.main(new String[] { //
				"-url", "http://webensim.univ-lemans.fr/", //
				"-login", "brice.amiard", //
				"-pass", "877RFL" //
		});
	}
}
