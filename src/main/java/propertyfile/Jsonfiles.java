package propertyfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import config.FrameworkConfig;




public class Jsonfiles {
	
private static Map<String, String> CONFIGMAP;
	
	private Jsonfiles() {
		
	}
	static {
		try {
			CONFIGMAP=new ObjectMapper().readValue(new File(FrameworkConfig.getJsonpath()),
					new TypeReference<HashMap<String ,String>>(){});
			
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String get(String key) throws Exception {
		if(Objects.isNull(key) ||Objects.isNull(key)) {
			throw new Exception("Property Name" + key +" is not found.Please found the property");
		}
		return CONFIGMAP.get(key);
	}


}
