package com.fsd.owner.property.global;

public enum JsonParam {
	BuildingID("BuildingID"),
	BuildingName("BuildingName"),
	FloorID("FloorID"),
	FloorName("FloorName"),
	PrecinctID("PrecinctID"),
	RoomID("RoomID"),
	PrecinctName("PrecinctName");
	private String name;
	private JsonParam(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
}
