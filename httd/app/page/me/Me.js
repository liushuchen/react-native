import React, {Component} from 'react';
import {Text, View} from 'react-native';
import MeHeader from './MeHeader';

export default class Me extends Component {
    render() {
        return (
            <View>
                <MeHeader/>
                <Text>我的页面</Text>
            </View>
        );
    }
}
