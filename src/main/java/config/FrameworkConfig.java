package config;

public class FrameworkConfig {

	private final static String RESOURCEPATH=System.getProperty("user.dir");
	private final static String PROJECTMAINPATH=RESOURCEPATH.concat("\\src\\main\\java");
	private final static String PROPERTYPATH=RESOURCEPATH.concat("\\src\\main\\resource\\globlpropetyData\\Global.properties");
	private final static String JSONPATH=RESOURCEPATH.concat("\\src\\main\\resource\\globlpropetyData\\Global.json");
	
	
	
	public static String getPropertypath() {
		return PROPERTYPATH;
	}
	public static String getJsonpath() {
		return JSONPATH;
	}


}
