package com.example.gwtpresentation.client;

import java.util.List;

import com.example.gwtpresentation.client.ui.Slide;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory {
	EventBus getEventBus();
	PlaceController getPlaceController();
	Slide getSlideView(String slideNumber);
	List<Slide> getSlides();
}
