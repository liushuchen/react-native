import {
    Platform
} from 'react-native';
import Toast from 'react-native-root-toast';//导入组件
let toast;
//短时间提示的方法
export const toastShort = (content) => {
    if (toast !== undefined) {
        Toast.hide(toast);
    }
    toast = Toast.show(content.toString(), {
        duration: Toast.durations.SHORT,
        position: Platform.OS === 'android' ? Toast.positions.BOTTOM : Toast.positions.CENTER,
        shadow: true,
        animation: true,
        hideOnPress: true,
        delay: 0
    });
};
//长时间提示的方法
export const toastLong = (content) => {
    if (toast !== undefined) {
        Toast.hide(toast);
    }
    toast = Toast.show(content.toString(), {
        duration: Toast.durations.LONG,
        position: Platform.OS === 'android' ? Toast.positions.BOTTOM : Toast.positions.CENTER,
        shadow: true,
        animation: true,
        hideOnPress: true,
        delay: 0,

    });
};
