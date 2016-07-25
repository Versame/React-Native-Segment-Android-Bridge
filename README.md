# React-Native-Segment-Android-Bridge
# Introduction

This is a react native android bridge example project for <a href="https://segment.com/">Segment IO</a>. The example project has native Android dependencies and is strictly an Android example project. 

# Setup

* $ ```git clone git@github.com:Versame/React-Native-Segment-Android-Bridge.git```
* In the file project_source/android/app/src/main/java/com/segmentpoc/Segment/SegmentModule.java:
  replace ```"xxxxxxxxxxxxxxxxxxxxxxx"``` with your segment account api key.
* run on Android device with react-native run-android

# Test

Test with the two buttons, register user and track event on the react native application. You should see an identified user and a tracked event in your Segment debugger page.

# Documentation

```
public void identifyUserWithNameAndEmail(String user, String name, String email) {
        Analytics.with(this.getReactApplicationContext()).identify(user, new Traits().putName(name).putEmail(email), null);
    }
```
This method identifies the user with both a name and email. If you want to identify a user with just a userid, use the following method:

```
@ReactMethod
    public void setUserId(String id) {
        Analytics.with(this.getReactApplicationContext()).identify(id, null, null);
    }
```

Additionally, to log an event with just a name, use the following method:
```
@ReactMethod
    public void trackEvent(String event) {
        Analytics.with(this.getReactApplicationContext()).track(event, null);
    }
```

Or if you'd like to pass in props as well, use the following method:
```
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
```

# License

MIT
