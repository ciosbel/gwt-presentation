package com.example.gwtpresentation.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Slide1 extends Composite implements Slide {

  @UiTemplate("Slide1.ui.xml")
  interface SlideBinder extends UiBinder<Widget, Slide1> { }
  private static SlideBinder binder = GWT.create(SlideBinder.class);

  public Slide1() {
    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public Widget asWidget() {
    return this;
  }
}
