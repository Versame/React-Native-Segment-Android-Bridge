package com.segmentpoc;

import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.segment.analytics.Analytics;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            // Create an analytics client with the given context and Segment write key.
            // TODO: replace "xxxxxxxxxxxxxxxxxxxxxxxxxxx" with api key from segment!
            Analytics analytics = new Analytics.Builder(this.getApplicationContext(), "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                    .trackApplicationLifecycleEvents() // Enable this to record certain application events automatically!
                    .recordScreenViews() // Enable this to record screen views automatically!
                    .build();

// Set the initialized instance as a globally accessible instance.
            Analytics.setSingletonInstance(analytics);
        } catch (Exception e ) {}
    }

    @Override
    protected String getMainComponentName() {
        return "segmentPOC";
    }
}
