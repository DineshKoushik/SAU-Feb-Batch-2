import React from 'react';
import { FlatList } from 'react-native';
import Card from './Card';

function List(props) {
  return (
    <FlatList
      numColumns={2}
      horizontal={false}
      keyExtractor={(item) => item.id.toString()}
      data={props.movies.results}
      renderItem={({item}) => {
        return <Card item={item}/>;
      }}
    />
  );
}

export default List;