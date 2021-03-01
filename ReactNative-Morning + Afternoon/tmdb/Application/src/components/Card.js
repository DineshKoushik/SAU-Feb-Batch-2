import React, {useState} from 'react';
import {
  StyleSheet,
  Text,
  View,
  Image,
  TouchableOpacity,
  Modal,
} from 'react-native';
import Detail from './Details';

function Card({item, navigation}) {
  let imageUrl = 'https://image.tmdb.org/t/p/w500' + item.poster_path;

  const [modalOpen, setModalOpen] = useState(false);

  const closeModal = () => {
    setModalOpen(false);
  };

  return (
    <View style={styles.main}>
      <Modal visible={modalOpen} animationType="slide">
        <Detail item={item} closeModal={closeModal} />
      </Modal>

      <TouchableOpacity style={styles.item} onPress={() => setModalOpen(true)}>
        <Image style={styles.image} source={{uri: imageUrl}} />
        <View>
        <Text style={styles.text}>{item.title}</Text>
        </View>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  text:{
    marginTop: 3,
    marginBottom: 3,
    fontWeight: 'bold',
    textAlign: 'center',
    width: 150
  },
  image: {
    marginLeft: 2,
    width: 150,
    height: 150,
    marginTop:5
  },
  item: {
    marginBottom: 10,
    marginHorizontal: 5,
    borderRadius: 10,
    elevation: 1,
    width: 169,
    paddingTop:7,
    paddingLeft:7,
    paddingBottom:7
  }
});

export default Card;