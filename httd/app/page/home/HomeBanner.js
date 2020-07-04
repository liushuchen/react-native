import React, {Component} from 'react';
import {Image, Text, View, StyleSheet, Dimensions, TouchableWithoutFeedback} from 'react-native';
import Swiper from 'react-native-swiper';

const mWidth = Dimensions.get('window').width;  //整个屏幕的宽度
import {
    ScaleSize,
} from '../../common/ScaleSize';

export default class HomeBanner extends Component {
    constructor(props) {
        super(props);
        this.state = {};
    }

    //处理点击图片事件
    _onImage = (info) => {
        console.info('点击了轮播图:', info);
    };

    render() {
        //获取传递进来的数据
        const {bannerList, navigation} = this.props;
        if (bannerList.length == 0) {
            return null;
        }
        return (
            <View style={styles.wrapper}>
                <Swiper showsButtons={true} autoplay={true}>
                    {
                        bannerList.map((info, index) => {
                            return (
                                <Image style={styles.bannerImage}
                                       resizeMode='cover'
                                       source={{uri: info.imagePrefix + info.bannerImage}}
                                       key={index}
                                       onPress={() => {
                                           this._onImage(info);
                                       }}
                                />
                            );
                        })
                    }
                </Swiper>
            </View>


        );
    }
}
const styles = StyleSheet.create({
    wrapper: {
        flex: 1,
        borderWidth: 1,
        borderColor: '#ededed',
        backgroundColor: '#ffffff',
        height: ScaleSize(400),
        marginBottom: ScaleSize(20),
    },
    bannerImage: {
        height: ScaleSize(400),
        width: mWidth,
    },
});
