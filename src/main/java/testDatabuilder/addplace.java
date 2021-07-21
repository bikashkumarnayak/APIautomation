package testDatabuilder;

import java.util.ArrayList;
import java.util.List;

import pojo.Addplacebase;
import pojo.Location;

public class addplace {

	public Addplacebase addplaceTestdata() {
		Addplacebase ab=new Addplacebase();
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ab.setLocation(l);
		ab.setAccuracy(50);
		ab.setName("ximb squre");
		ab.setPhone_number("(+91) 7077880261");
		ab.setAddress("11/10, fourtune tower bhubaneswar");
		List<String> list=new ArrayList<>();
		list.add("Odisha");
		list.add("BBSR");
		ab.setTypes(list);
		ab.setWebsite("http://google.com");
		ab.setLanguage("odiya");
		return ab;
	}
}
