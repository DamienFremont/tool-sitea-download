package org.sitea.downloader;

import static com.google.common.base.Preconditions.checkArgument;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		checkArgument(args.length > 0, "args are needed");
		String url = getArg(args, "-url", null);
		String login = getArg(args, "-login", null);
		String pass = getArg(args, "-pass", null);
		String target = targetFolder();
		new MainJob().execute(//
				target, //
				url, //
				login, //
				pass);
	}

	private static String targetFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String ts = sdf.format(new Date());
		String target = String.format("target/%s", ts);
		return target;
	}

	private static String getArg(String[] args, String param, String defaultValue) {
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			if (param.equals(arg)) {
				int iValue = i + 1;
				checkArgument(args.length > iValue, param + " arg value must not be null");
				String iChapter = args[iValue];
				checkArgument(iChapter != null, param + " arg value must not be null");
				checkArgument(!iChapter.isEmpty(), param + " arg value must not be empty");
				return iChapter;
			}
		}
		return defaultValue;
	}
}
