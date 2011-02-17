package com.example.gwtpresentation.client.activity;

import com.example.gwtpresentation.client.ClientFactory;
import com.example.gwtpresentation.client.place.SlidePlace;
import com.example.gwtpresentation.client.ui.Slide;
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