import React, {Component} from 'react';
import {View, StyleSheet, ScrollView,YellowBox} from 'react-native';
//导如组件
import HomeHeader from './HomeHeader';
import HomeMenu from './HomeMenu';
import HomeNotice from './HomeNotice';
import HomeBanner from './HomeBanner';
import Request from '../../common/Request';
import HomeRecommend from './HomeRecommend';
import Config from '../../common/Config';

//弹窗提示
import {toastShort} from '../../common/Toast';
import Swiper from 'react-native-swiper';
//用于消除警告
YellowBox.ignoreWarnings(['VirtualizedLists should never be nested']);
export default class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            noticeList: [],//公告列表
            menuList: [],//菜单列表
            bannerList: [],//首页轮播图
            recommendList: [],//推荐列表
        };
    }

    //加载数据
    componentDidMount() {
        this.loadHome();
    }

    //加载数据:
    loadHome = () => {
        let params = {};
        //加载轮播图
        Request.post(Config.api.base + Config.api.home.findHomeBannerList, params)
            .then(result => {
                if (result.code != 0) {
                    toastShort(result.message);
                } else {
                    this.setState({
                        bannerList: result.data,
                    });
                }
            });
        //加载首页菜单
        Request.post(Config.api.base + Config.api.home.findHomeMenuList, params)
            .then(result => {
                if (result.code != 0) {
                    toastShort(result.message);
                } else {
                    this.setState({
                        menuList: result.data,
                    });
                }
            });
        //加载首页公告
        Request.post(Config.api.base + Config.api.home.findHomeNoticeList, params)
            .then(result => {
                if (result.code != 0) {
                    toastShort(result.message);
                } else {
                    this.setState({
                        noticeList: result.data,
                    });
                }
            });
        //加载首页推荐
        Request.post(Config.api.base + Config.api.home.findRecommendList, params)
            .then(result => {
                if (result.code != 0) {
                    toastShort(result.message);
                } else {
                    this.setState({
                        recommendList: result.data,
                    });
                }
            });
    };

    render() {

        return (
            <View>
                <ScrollView>
                    <HomeHeader/>
                    {/*公告*/}
                    <HomeNotice noticeList={this.state.noticeList} navigation={this.props.navigation}/>
                    {/*轮播图*/}
                    <HomeBanner bannerList={this.state.bannerList} navigation={this.props.navigation}/>

                    {/*菜单*/}
                    <HomeMenu menuList={this.state.menuList} navigation={this.props.navigation}/>
                    {/*推荐列表*/}
                    <HomeRecommend recommendList={this.state.recommendList} recommendTitle='推荐列表'
                                   navigation={this.props.navigation}/>
                </ScrollView>
            </View>

        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#ffffff',
    },
});

