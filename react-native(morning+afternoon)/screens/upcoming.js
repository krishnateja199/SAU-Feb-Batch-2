import React, {Component} from 'react';
import {
  Text,
  View,
  StyleSheet,
  Image,
  TouchableOpacity,
  ScrollView,
  StatusBar,
} from 'react-native';
import {FlatList, ActivityIndicator} from 'react-native';
import Details from '../../components/details';
import {globalStyle} from '../../styles/globalStyle';
import {Colors} from '../../colors/Colors';

class upcoming extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
      clicked: false,
      clickeddata: null,
    };
  }

  baseuri = 'https://image.tmdb.org/t/p/w185_and_h278_bestv2';

  async getData() {
    const res = await fetch(
      'https://api.themoviedb.org/3/movie/upcoming?api_key=4cfbaf275e7c796eded0b452dbc74644&language=en-US&page=1',
    );
    const resJson = await res.json();
    this.setState({data: resJson.results});
  }

  componentDidMount() {
    this.getData();
  }

  showdetails(item) {
    console.log(item);
    this.setState({clicked: true});
    this.setState({clickeddata: item});
  }

  changeclicked() {
    this.setState({clicked: false});
    this.setState({clickeddata: null});
  }

  render() {
    if (this.state.clicked) {
      return (
        <Details
          changeclicked={this.changeclicked.bind(this)}
          clickeddata={this.state.clickeddata}
        />
      );
    }
    return (
      <View style={globalStyle.body}>
        <Text style={globalStyle.topview}> Popular Movies </Text>

        <ScrollView styles={globalStyle.results}>
          {this.state.data.map((item) => (
            <TouchableOpacity onPress={() => this.showdetails(item)}>
              <View key={item.id} style={globalStyle.result}>
                <Image
                  source={{uri: this.baseuri + item.poster_path}}
                  style={{
                    width: 300,
                    height: 300,
                    marginLeft: 50,
                    marginRight: 20,
                    marginBottom: 20,
                  }}
                  resizeMode="cover"
                />
                <Text style={globalStyle.heading}> {item.title} </Text>
              </View>
            </TouchableOpacity>
          ))}
        </ScrollView>
      </View>
    );
  }
}

export default upcoming;
