package enaum;

public enum AllResource {

	AddPlaceAPI("maps/api/place/add/json"),
	DeleteplaceAPI("/maps/api/place/delete/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	UpdateplaceAPI("/maps/api/place/update/json");
	private String resource;

	AllResource(String resource){
		this.resource=resource;
	}

	public String getResource() {
		return resource;
	}
}
