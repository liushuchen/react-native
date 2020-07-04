import React, {Component} from 'react';
import {createAppContainer} from 'react-navigation';
import {createStackNavigator} from 'react-navigation-stack';
import TabBar from './app/page/tabbar/TabBar';
import Login from './app/page/login/Login';
//设置路由导航
export const App = createStackNavigator({
    //底部tabbar
    TabBar: {
        screen: TabBar,
        navigationOptions: {
            headerShown: false,
        },
    },
    //首页
    Login: {
        screen: Login,
    },
}, {
    mode: 'modal',//modal模式
   /* headerMode: 'none',//不设置头s部*/
});
export default createAppContainer(App);
