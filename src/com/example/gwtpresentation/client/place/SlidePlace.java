package com.example.gwtpresentation.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * Place for selection section.
 */
public class SlidePlace extends Place {

  private String slideNumber;

  public SlidePlace(String slideNumber) {
    this.slideNumber = slideNumber;
  }

  public String getSlide() {
    return this.slideNumber;
  }
  @Prefix("slide")
  public static class Tokenizer implements PlaceTokenizer<SlidePlace> {

    @Override
    public SlidePlace getPlace(String slideNumber) {
      return new SlidePlace(slideNumber);
    }

    @Override
    public String getToken(SlidePlace place) {
      return place.getSlide();
    }
  }

}
