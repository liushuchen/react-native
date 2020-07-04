import React, {Component} from 'react';
import {
    View,
    Text,
    StyleSheet,
    FlatList,
    TouchableWithoutFeedback,
    Image,
    Dimensions,
} from 'react-native';

const mWidth = Dimensions.get('window').width;  //整个屏幕的宽度

import {
    ScaleSize,
} from '../../common/ScaleSize';


export default class HomeRecommend extends Component {

    //处理推荐列表
    _renderItem = ({item, index, separators}) => {
        return (
            <TouchableWithoutFeedback
                onPress={() => this._onPress(item)}
                style={{flex: 1, alignItems: 'center'}}>
                <View style={styles.renderItem}>
                    <Image style={styles.recommendImage} source={{uri: item.imagePrefix + item.recommendImage}}/>
                    <Text style={styles.recommendName}>{item.recommendName}</Text>
                </View>
            </TouchableWithoutFeedback>
        );
    };

    //图片的点击事件
    _onPress = (item) => {
        console.info('图片的点击事件:', item);
    };

    render() {
        //获取推荐列表
        const {recommendList, recommendTitle, navigation} = this.props;
        if (recommendList.length === 0) {
            return null;
        }
        return (
            <View style={styles.container}>
                <View style={styles.recommendTitleView}>
                    <Text style={styles.recommendTitle}>{recommendTitle}</Text>
                </View>
                <FlatList
                    style={{backgroundColor: '#ffffff'}}
                    numColumns={2}
                    data={recommendList}
                    keyExtractor={(item, index) => index.toString()}
                    renderItem={(item) => {
                        return this._renderItem(item);
                    }}
                />
            </View>
        );
    }
}
const styles = StyleSheet.create({
    container: {
        flex:1,
        backgroundColor: '#ffffff',
    },
    recommendTitleView: {
        height: ScaleSize(100),
        width: mWidth,
        justifyContent: 'center',
        backgroundColor: '#ffffff',
    },
    recommendTitle: {
        fontSize: ScaleSize(32),
        marginLeft: ScaleSize(20),
        color:'#333333',
    },
    renderItem: {
        backgroundColor: '#ffffff',
        height: ScaleSize(390),
        width: mWidth / 2,        borderWidth: 1,
        borderColor: '#ededed',

        margin: ScaleSize(3),
    },
    recommendImage: {
        height: ScaleSize(300),
        width: '100%',
    },
    recommendName: {
        fontSize: ScaleSize(28),
        color:'#333333',
    },

});
