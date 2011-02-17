package com.example.gwtpresentation.client.mvp;

import com.example.gwtpresentation.client.ClientFactory;
import com.example.gwtpresentation.client.activity.SlideActivity;
import com.example.gwtpresentation.client.place.SlidePlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class SlideActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	public SlideActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/**
	 * Map each Place to its corresponding Activity. This would be a great use
	 * for GIN.
	 */
	@Override
	public Activity getActivity(Place place) {

		if (place instanceof SlidePlace) {
			return new SlideActivity((SlidePlace) place, clientFactory);
		}

		return null;
	}

}
