/**
 * @format
 */
import {AppRegistry} from 'react-native';
import {name as appName} from './app.json';
import Navigator from './navigation/navigation';

AppRegistry.registerComponent(appName, () => Navigator);
