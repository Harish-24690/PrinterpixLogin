package test.utilities;

public class DriverFactory {
	
	private static String chromeDriverExePath;
	private static String geckoDriverExepath;
	private static String ieDriverExepath;
	private static String configPropertyFile;
	private static String gridPath;
	private static boolean isRemote;
	public static String getChromeDriverExePath() {
		return chromeDriverExePath;
	}
	public static void setChromeDriverExePath(String chromeDriverExePath) {
		DriverFactory.chromeDriverExePath = chromeDriverExePath;
	}
	public static String getGeckoDriverExepath() {
		return geckoDriverExepath;
	}
	public static void setGeckoDriverExepath(String geckoDriverExepath) {
		DriverFactory.geckoDriverExepath = geckoDriverExepath;
	}
	public static String getIeDriverExepath() {
		return ieDriverExepath;
	}
	public static void setIeDriverExepath(String ieDriverExepath) {
		DriverFactory.ieDriverExepath = ieDriverExepath;
	}
	public static String getConfigPropertyFile() {
		return configPropertyFile;
	}
	public static void setConfigPropertyFile(String configPropertyFile) {
		DriverFactory.configPropertyFile = configPropertyFile;
	}
	public static String getGridPath() {
		return gridPath;
	}
	public static void setGridPath(String gridPath) {
		DriverFactory.gridPath = gridPath;
	}
	public static boolean isRemote() {
		return isRemote;
	}
	public static void setRemote(boolean isRemote) {
		DriverFactory.isRemote = isRemote;
	}
	

}
