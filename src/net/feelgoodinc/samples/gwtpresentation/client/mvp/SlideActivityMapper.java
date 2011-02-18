package net.feelgoodinc.samples.gwtpresentation.client.mvp;

import net.feelgoodinc.samples.gwtpresentation.client.ClientFactory;
import net.feelgoodinc.samples.gwtpresentation.client.activity.SlideActivity;
import net.feelgoodinc.samples.gwtpresentation.client.place.SlidePlace;

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
