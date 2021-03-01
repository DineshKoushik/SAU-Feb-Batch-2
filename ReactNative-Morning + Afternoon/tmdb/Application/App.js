import React from 'react';
import 'react-native-gesture-handler';
import {NavigationContainer} from '@react-navigation/native';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import TopRated from './src/screens/TopRated';
import Upcoming from './src/screens/Upcoming';
import Popular from './src/screens/Popular';
import {StatusBar} from 'react-native';


const btn = createBottomTabNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <StatusBar
      animated={true}
        barStyle="light-content"
        networkActivityIndicatorVisible={true}
        showHideTransition='slide'
        translucent={true}
        hidden={false}
        backgroundColor="#000000"
        translucent={true}
      />
      <btn.Navigator
        initialRouteName="Popular"
        backBehavior="history"
        tabBarOptions={{
          activeBackgroundColor:'#ffa500',
          labelStyle: {
            marginBottom: 15,
            fontWeight: 'bold',
            fontSize: 18,
            color:'#ffffff'
          },
          style: {
            backgroundColor:'#000000'
          },
        }}>
        <btn.Screen name="Popular" component={Popular} />
        <btn.Screen name="Upcoming" component={Upcoming} />
        <btn.Screen name="TopRated" component={TopRated} />
      </btn.Navigator>
    </NavigationContainer>
  );
}