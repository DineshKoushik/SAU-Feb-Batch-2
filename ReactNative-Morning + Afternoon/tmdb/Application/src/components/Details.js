import React from 'react';
import {StyleSheet, Text, View, Image, Button} from 'react-native';

function Detail({item, closeModal}) {
  let imageUrl = 'https://image.tmdb.org/t/p/w500' + item.poster_path;
  return (
    <View style={styles.h1}>
      <View style={styles.h2}>
        <View style={styles.h3}>
          <Text style={styles.title}>{item.title}</Text>
        </View>
      </View>

      <Image style={styles.image} source={{uri: imageUrl}} />

      <Text style={styles.Release}>Release Date : {item.release_date}</Text>

      <Text style={styles.header}>Description:</Text>

      <Text style={styles.description}>{item.overview}</Text>

      <View style={styles.button}>
        <Button
          onPress={() => {
            closeModal();
          }}
          title="Back"
          color="#ffa500"
          accessibilityLabel="Go back to the movies list"
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  description: {
    marginTop: 3,
    textAlign: 'center',
    fontWeight: 'bold',
    fontSize: 17,
    fontFamily: 'serif'
  },
  button:{
    marginTop: 100,
    width: 200,
  },
  header: {
    color: '#fffafa',
    marginTop: 20,
    textAlign: 'left',
    fontWeight: 'bold',
    fontSize: 20
  },
  h1: {
    flex: 1,
    backgroundColor: '#a9a9a9',
    alignItems: 'center',
    marginTop: 20,
    marginLeft: 5,
    marginRight: 5,
  },
  h2: {
    marginBottom: 20,
  },
  h3: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  image: {
    width: 350,
    height: 350,
    marginBottom: 20,
    borderRadius: 5,
  },
  title: {
    textAlign: 'center',
    fontSize: 30,
    fontWeight: 'bold',
    color: '#000000',
    width: 300,
  },
  Release: {
    fontWeight: 'bold',
    marginTop: 10,
    fontSize: 18,
    color: '#000000',
  },
});

export default Detail;