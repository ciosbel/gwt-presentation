package com.example.gwtpresentation.client;

import java.util.ArrayList;
import java.util.List;

import com.example.gwtpresentation.client.ui.Slide;
import com.example.gwtpresentation.client.ui.Slide1;
import com.example.gwtpresentation.client.ui.Slide2;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;

public class ClientFactoryImpl implements ClientFactory {

	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
  private static final List<Slide> slides = new ArrayList<Slide>();

  public ClientFactoryImpl() {
    slides.add(new Slide1());
    slides.add(new Slide2());
    slides.add(new Slide2());
    slides.add(new Slide2());
  }

	@Override
	public EventBus getEventBus()	{
		return eventBus;
	}

	@Override
  public PlaceController getPlaceController() {
    return placeController;
  }

  @Override
  public Slide getSlideView(String slideNumber) {
    try {
      return slides.get(Integer.parseInt(slideNumber) - 1);
    } catch(IndexOutOfBoundsException e) {
      Window.alert("no such slide exists");
      return slides.get(0);
    }
  }

  @Override
  public List<Slide> getSlides() {
    // be immutable
    return new ArrayList<Slide>(slides);
  }

}
