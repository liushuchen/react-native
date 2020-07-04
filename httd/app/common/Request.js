import {toastLong} from '../common/Toast';
export default class request {
    /**
     * 利用 Promise 的 get 方式请求
     * @param url
     * @returns {Promise}
     */
    static get(url) {
        return new Promise((resolve, reject) => {
            fetch(url)
                .then(response => response.json())
                .then(result => resolve(result))
                .catch(error => reject(error));
        });
    }

    /**
     * 利用 Promise 的 post 方式请求
     * @param url
     * @param params
     * @returns {Promise}
     */
    static post(url, params) {
        return new Promise((resolve, reject) => {
            fetch(url, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(params),
            })
                .then(response => response.json())
                .then(result => {
                    //判断token是否超时
                    if (result.code === 6) {
                        console.info('应该跳转到首页');
                    }
                    resolve(result);
                })
                .catch(error => {
                    toastLong('网咯异常,请稍后再试');
                    //reject(error)
                }).done();
        });
    }
}
