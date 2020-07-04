import React, {Component} from 'react';
import {Text, View, StyleSheet, Dimensions, Image} from 'react-native';
//字体库
import {
    ScaleSize,
} from '../../common/ScaleSize';
export default class MeHeader extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        const {title} = this.props;
        return (
            <View style={styles.container}>
                <Text>{title}</Text>
            </View>
        );
    }
}
const styles = StyleSheet.create({
    container: {
        height: ScaleSize(90),
        backgroundColor: '#33a3dc',
    },
});
