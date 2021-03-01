import React, {useEffect, useState} from 'react';
import {StyleSheet, Text, View} from 'react-native';
import List from '../components/List';

function Popular() {
  const [popularMovies, setPopularMovies] = useState([]);

  const getPopularMovies = async () => {
    try {
      const url =
        'https://api.themoviedb.org/3/movie/popular?api_key=fe4c4372217c7188089f334449eacc5b&language=en-US&page=1&region=us';
      const resp = await fetch(url);
      setPopularMovies(await resp.json());
    } catch (err) {
      console.log(err);
    }
  };

  useEffect(() => {
    getPopularMovies();
  }, []);

  return (
    <View style={styles.view}>
      <List movies={popularMovies}></List>
    </View>
  );
}

const styles = StyleSheet.create({
  view: {
    flex: 1,
    alignItems: 'center',
    marginTop: 40
  }
});

export default Popular;