import React from 'react';
//import { createDrawerNavigator } from '@react-navigation/drawer';


//import { createStackNavigator } from '@react-navigation/stack';
import { createMaterialBottomTabNavigator } from 'react-navigation-material-bottom-tabs';

import popular from '../screens/popular';
import toprated from '../screens/toprated';
import upcoming from '../screens/upcoming';


import {
  SafeAreaView,
  StyleSheet,
  View,
  Text,
  Button,
  ScrollView,
  StatusBar,
} from 'react-native';



const TabNavigator= createMaterialBottomTabNavigator(
  {
    popular:{
      screen : popular,
    },
    toprated:{
      screen:toprated,
    },
    upcoming:{
      screen:upcoming
    },
  },
  {
     initialRouterName :'DetailsScreen' ,
     activeColor:'#f0edf6',
     inactiveColor:'#E8A317',
     barStyle:{backgroundColor:'#8C001A',marginTop:60},
  }
);

export default createAppContainer(TabNavigator);