import React, {Component} from 'react';
import {View, StyleSheet, Image} from 'react-native';
//底部tab样式
import TabNavigator from 'react-native-tab-navigator';
//字体库
import {
    ScaleSize,
} from '../../common/ScaleSize';
import Home from '../home/Home';
import Me from '../me/Me';
import Search from '../search/Search';

export default class TabBar extends Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedTab: 'home',
            loginStatus: false,//登录状态
            tabBarHeight:ScaleSize(90),
        };
    }

    render() {
        return (
            <View style={styles.container}>
                <TabNavigator>
                    <TabNavigator.Item
                        selected={this.state.selectedTab === 'home'}
                        title="首页"
                        renderIcon={() => <Image
                            style={styles.imageStytle}
                            source={require('../../assets/icon/tabbar/home.png')}
                        />}
                        renderSelectedIcon={() => <Image
                            style={styles.selectedImageStytle}
                            source={require('../../assets/icon/tabbar/home.png')}
                        />}
                        badgeText="1"
                        onPress={() => this.setState({selectedTab: 'home'})}>
                        <Home/>
                    </TabNavigator.Item>
                    <TabNavigator.Item
                        selected={this.state.selectedTab === 'search'}
                        title="搜索"
                        renderIcon={() => <Image
                            style={styles.imageStytle}
                            source={require('../../assets/icon/tabbar/search.png')}
                        />}
                        renderSelectedIcon={() => <Image
                            style={styles.selectedImageStytle}
                            source={require('../../assets/icon/tabbar/search.png')}
                        />}
                        // renderBadge={() => <CustomBadgeView />}
                        onPress={() => this.setState({selectedTab: 'search'})}>
                        <Search/>
                    </TabNavigator.Item>
                    <TabNavigator.Item
                        selected={this.state.selectedTab === 'me'}
                        title="我的"
                        renderIcon={() => <Image
                            style={styles.imageStytle}
                            source={require('../../assets/icon/tabbar/me.png')}
                        />}
                        renderSelectedIcon={() => <Image
                            style={styles.selectedImageStytle}
                            source={require('../../assets/icon/tabbar/me.png')}
                        />}
                        onPress={() => this.setState({selectedTab: 'me'})}>
                        <Me/>
                    </TabNavigator.Item>
                </TabNavigator>
            </View>
        );
    }
}
const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    imageStytle: {
        tintColor: '#d3d7d4',
        width: ScaleSize(50),
        height: ScaleSize(50),
    },
    selectedImageStytle: {
        tintColor: '#33a3dc',
        width: ScaleSize(50),
        height: ScaleSize(50),
    },
});
