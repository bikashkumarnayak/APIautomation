package testDatabuilder;

import java.util.ArrayList;
import java.util.List;

import pojo.Addplacebase;
import pojo.DeleteplaceAPI;
import pojo.Location;
import pojo.UpdateplaceAPI;

public class AddPlaceApi {
	
	public Addplacebase adplaceAPI(String name,String language,String address) {
		Addplacebase ab=new Addplacebase();
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ab.setLocation(l);
		ab.setAccuracy(50);
		ab.setName(name);
		ab.setPhone_number("(+91) 7077880261");
		ab.setAddress(address);
		List<String> list=new ArrayList<>();
		list.add("Odisha");
		list.add("BBSR");
		ab.setTypes(list);
		ab.setWebsite("http://google.com");
		ab.setLanguage(language);
		return ab;
	}
	public DeleteplaceAPI deletedata(String placeid) {
		DeleteplaceAPI da=new DeleteplaceAPI();
		da.setPlace_id(placeid);
		return da;
	}
	public UpdateplaceAPI updateplace(String place_id,String address) {
		UpdateplaceAPI ua=new UpdateplaceAPI();
		ua.setPlace_id(place_id);
		ua.setAddress(address);
		ua.setKey("qaclick123");
		return ua;
	}

}
