import React, {Component} from 'react';
import {View, Text, StyleSheet} from 'react-native';

export default class Login extends Component {
    render() {
        return (
            <View style={styles.container}>
                <Text>登录页面</Text>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
});
