'use strict';

const config = {
    api: {
        base: 'http://127.0.0.1:7706/',
        //首页模块
        home: {
            findHomeNoticeList: 'homeNotice/findHomeNoticeList',//获取首页公告
            findHomeBannerList: 'homeBanner/findHomeBannerList',//获取首页轮播图
            findHomeMenuList: 'homeMenu/findHomeMenuList',//获取首页菜单
            findRecommendList:'homeRecommend/findHomeRecommendList'//获取首页推荐列表
        },
        user: {},
    },
    map: {
        method: 'POST',
        header: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        timeout: 8000,
    },
};
module.exports = config;
