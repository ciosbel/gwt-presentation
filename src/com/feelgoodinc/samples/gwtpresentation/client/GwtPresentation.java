package com.feelgoodinc.samples.gwtpresentation.client;

import com.feelgoodinc.samples.gwtpresentation.client.mvp.AppPlaceHistoryMapper;
import com.feelgoodinc.samples.gwtpresentation.client.mvp.SlideActivityMapper;
import com.feelgoodinc.samples.gwtpresentation.client.place.SlidePlace;
import com.feelgoodinc.samples.gwtpresentation.client.ui.Slide;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtPresentation implements EntryPoint {

  private Place defaultPlace = new SlidePlace("1");
  private DeckLayoutPanel deckPanel = new DeckLayoutPanel();
  private FocusPanel focusPanel = new FocusPanel(deckPanel);
  private ClientFactory clientFactory = GWT.create(ClientFactoryImpl.class);

  @Override
  public void onModuleLoad() {

    //GlobalResources.INSTANCE.css().ensureInjected();
    EventBus eventBus = clientFactory.getEventBus();
    PlaceController placeController = clientFactory.getPlaceController();

    SlideActivityMapper slideActivityMapper = new SlideActivityMapper(clientFactory);
    ActivityManager slideActivityManager = new ActivityManager(slideActivityMapper, eventBus);
    slideActivityManager.setDisplay(deckPanel);

    // Start PlaceHistoryHandler with our PlaceHistoryMapper
    AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, defaultPlace);

    focusPanel.setStyleName("ladybug");
    focusPanel.setSize("100%", "100%");
    RootLayoutPanel.get().add(focusPanel);

    deckPanel.getElement().getStyle().clearPosition();
    // insert all slides
    for (Slide slide : clientFactory.getSlides()) {
      deckPanel.add(slide);
    }

    focusPanel.addKeyUpHandler(new KeyUpHandler() {
      @Override
      public void onKeyUp(KeyUpEvent event) {
        if(event.getNativeKeyCode() == KeyCodes.KEY_LEFT) {
          clientFactory.getPlaceController().goTo(prevSlide());
        }
        if(event.getNativeKeyCode() == KeyCodes.KEY_RIGHT) {
          clientFactory.getPlaceController().goTo(nextSlide());
        }
      }
    });

    //set stuff
    deckPanel.setAnimationVertical(false);
    deckPanel.setAnimationDuration(500);
    // Goes to place represented on URL or default place
    historyHandler.handleCurrentHistory();

  }

  protected Place prevSlide() {
    int current = Integer.parseInt(((SlidePlace) clientFactory.getPlaceController().getWhere()).getSlide());
    if(current != 1)
      return new SlidePlace(current - 1 + "");
    return clientFactory.getPlaceController().getWhere();
  }

  protected Place nextSlide() {
    int current = Integer.parseInt(((SlidePlace) clientFactory.getPlaceController().getWhere()).getSlide());
    if(current != clientFactory.getSlides().size())
      return new SlidePlace(current + 1 + "");
    return clientFactory.getPlaceController().getWhere();
  }

}
