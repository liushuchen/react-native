import React, {Component} from 'react';
import {Image, Text, View, StyleSheet, Dimensions, TouchableOpacity} from 'react-native';
import Swiper from 'react-native-swiper';

const mWidth = Dimensions.get('window').width;  //整个屏幕的宽度
import {
    ScaleSize,
} from '../../common/ScaleSize';

export default class HomeMenu extends Component {
    constructor(props) {
        super(props);
        this.state = {
            menuSize: 8,
            menuListItem: [],
        };
    }

    //处理跳转
    _onJump = (jump) => {
        console.info('菜单跳转:', jump);
    };

    //渲染组件
    render() {
        //获取菜单列表,如果没有数据就不处理直接返回null
        const {menuList,navigation} = this.props;
        if (menuList.length === 0) {
            return null;
        }
        let newMenuListItem = [];
        //封装数据
        menuList.map((info, index) => {
            newMenuListItem.push(<TouchableOpacity key={index}
                                                   style={styles.menuItem}
                                                   onPress={() => {
                                                       this._onJump(info);
                                                   }}>
                <Image style={styles.menuImage} source={{uri: info.imagePrefix + info.menuImage}}/>
                <Text style={styles.menuName}>
                    {info.menuName}
                </Text>
            </TouchableOpacity>);
        });
        let menuListItem = [];
        while (newMenuListItem.length > 0) {
            if (newMenuListItem.length > 8) {
                menuListItem.push(newMenuListItem.slice(0, 8));
                newMenuListItem.splice(0, this.state.menuSize);
            } else {
                menuListItem.push(newMenuListItem);
                newMenuListItem = [];
            }
        }
        return (
            <View style={[styles.container, {height: menuList.length > 4 ? ScaleSize(390) : ScaleSize(190)}]}>
                <Swiper>
                    {
                        menuListItem.map((info, index) => {
                            return (<View key={index}
                                          style={[styles.menuListItem,
                                              {height: menuList.length > 4 ? ScaleSize(390) : ScaleSize(190)}]}>
                                {info}
                            </View>);
                        })
                    }
                </Swiper>
            </View>
        );
    }
}
const styles = StyleSheet.create({
    container: {
        flex:1,
        borderWidth: 1,
        borderColor: '#ededed',
        backgroundColor: '#ffffff',
        marginBottom:ScaleSize(20),
    },
    menuListItem: {
        width: mWidth,
        flexDirection: 'row',
        alignItems: 'center',
        flexWrap: 'wrap',
    },
    menuItem: {
        marginTop: ScaleSize(20),
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        width: mWidth / 4,
    },
    menuImage: {
        height: ScaleSize(80),
        width: ScaleSize(80),
    },
    menuName: {
        marginTop: ScaleSize(10),
        fontSize: ScaleSize(22),
        color:'#333333'
    },
});
