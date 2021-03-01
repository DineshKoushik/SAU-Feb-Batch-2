import React, {useEffect, useState} from 'react';
import {StyleSheet, Text, View} from 'react-native';
import List from '../components/List';

function Upcoming() {
  const [upcomingMovies, setUpcomingMovies] = useState([]);

  const getUpcomingMovies = async () => {
    try {
      const url =
        'https://api.themoviedb.org/3/movie/upcoming?api_key=fe4c4372217c7188089f334449eacc5b&language=en-US&page=1';
      const resp = await fetch(url);
      setUpcomingMovies(await resp.json());
    } catch (err) {
      console.log('upcoming movies fetching error ------ ');
      console.log(err);
    }
  };

  useEffect(() => {
    getUpcomingMovies();
  }, []);

  return (
    <View style={styles.MainView}>
      <List movies={upcomingMovies}></List>
    </View>
  );
}

const styles = StyleSheet.create({
  MainView: {
    marginTop: 40,
    flex: 1,
    alignItems: 'center',
  }
});

export default Upcoming;