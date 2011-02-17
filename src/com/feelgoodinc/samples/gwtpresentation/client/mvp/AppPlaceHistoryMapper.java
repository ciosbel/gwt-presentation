package com.feelgoodinc.samples.gwtpresentation.client.mvp;

import com.feelgoodinc.samples.gwtpresentation.client.place.SlidePlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers( { SlidePlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
