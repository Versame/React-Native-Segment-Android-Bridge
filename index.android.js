/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  TouchableHighlight,
  NativeModules,
} from 'react-native';

class segmentPOC extends Component {

  constructor(props) {
    super(props);
    this._identifyUser = this._identifyUser.bind(this);
    this._trackEvent = this._trackEvent.bind(this);
  }

  _identifyUser() {
    console.log('attempting to identify user');
    NativeModules.Segment.identifyUserWithNameAndEmail("TestUser", "TestName", "TestEmail@Email.com");
  }

  _trackEvent() {
    console.log('attempting to track event');
    NativeModules.Segment.trackEvent("Opened app");
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Shake or press menu button for dev menu
        </Text>

        <TouchableHighlight
        onPress={this._identifyUser}
        style={styles.button}>
          <Text>
            Identify user
          </Text>
        </TouchableHighlight>

        <TouchableHighlight
        onPress={this._trackEvent}
        style={styles.button}>
          <Text>
            Track Event
          </Text>
        </TouchableHighlight>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  button: {
    backgroundColor: 'lavender',
    marginTop: 5,
    height: 30,
    alignItems: 'center',
    marginLeft: 20,
    marginRight: 20,
    borderRadius: 5,
    paddingHorizontal: 10,
    marginHorizontal: 2,
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('segmentPOC', () => segmentPOC);
