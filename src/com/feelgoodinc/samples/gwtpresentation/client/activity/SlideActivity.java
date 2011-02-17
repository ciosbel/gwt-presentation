package com.feelgoodinc.samples.gwtpresentation.client.activity;

import com.feelgoodinc.samples.gwtpresentation.client.ClientFactory;
import com.feelgoodinc.samples.gwtpresentation.client.place.SlidePlace;
import com.feelgoodinc.samples.gwtpresentation.client.ui.Slide;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SlideActivity extends AbstractActivity {

  private ClientFactory clientFactory;
  private String slideNumber;

  public SlideActivity(SlidePlace place, ClientFactory clientFactory) {
    this.slideNumber = place.getSlide();
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
    Slide view = clientFactory.getSlideView(slideNumber);
    containerWidget.setWidget(view.asWidget());
  }
}