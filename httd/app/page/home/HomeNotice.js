import React, {Component} from 'react';
import {View, StyleSheet, Dimensions, Image,Text} from 'react-native';
import {NoticeBar, WhiteSpace} from '@ant-design/react-native';
//走马灯
import {
    ScaleSize,
} from '../../common/ScaleSize';

const mWidth = Dimensions.get('window').width;  //整个屏幕的宽度

//首页公告
export default class HomeNotice extends Component {
    constructor(props) {
        super(props);
        this.state = {};
    }

    //渲染数据
    render() {
        const customIcon = (
            <Image
                source={{
                    uri: 'https://zos.alipayobjects.com/rmsportal/bRnouywfdRsCcLU.png',
                }}
                style={{width: 12, height: 12}}
            />
        );
        //获取菜单列表,如果没有数据就不处理直接返回null
        const {noticeList, navigation} = this.props;
        noticeList.map((info, index) => {

        });
        if (noticeList.length === 0) {
            return null;
        }
        return (
            <View style={styles.container}>
                <NoticeBar>
                    <Text>121212</Text>
                </NoticeBar>

            </View>
        );
    }
}
//样式
const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
});
