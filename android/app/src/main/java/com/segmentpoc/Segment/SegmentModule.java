package com.segmentpoc.Segment;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.segment.analytics.*;

/**
 * Created by joelwasserman on 7/20/16.
 */
public class SegmentModule extends ReactContextBaseJavaModule {

    public SegmentModule(ReactApplicationContext reactContext) {
        super(reactContext);

    }

    @Override
    public String getName() {
        return "Segment";
    }

    @ReactMethod
    public void identifyUserWithNameAndEmail(String user, String name, String email) {
        Analytics.with(this.getReactApplicationContext()).identify(user, new Traits().putName(name).putEmail(email), null);
    }

    @ReactMethod
    public void trackEvent(String event) {
        Analytics.with(this.getReactApplicationContext()).track(event, null);
    }

    @ReactMethod
    public void logEventWithProps(String identifier, ReadableMap map) {

        ReadableMapKeySetIterator it = map.keySetIterator();
        Properties properties = new Properties();

        while (it.hasNextKey()) {
            String key = it.nextKey();
            ReadableType type = map.getType(key);
            String val = map.getString(key);
            properties.putValue(key,val);
        }

        Analytics.with(this.getReactApplicationContext()).track(identifier, properties);

    }

    @ReactMethod
    public void setUserId(String id) {
        Analytics.with(this.getReactApplicationContext()).identify(id, null, null);
    }

}
