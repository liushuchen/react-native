package com.httd.api.base;


import com.httd.api.enums.ResultEnum;

public class BaseController {

    protected BaseResult response(String code, String message, Object obj) {
        return new BaseResult(code, message, obj);
    }

    protected BaseResult response(String code, String message) {
        return response(code, message, null);
    }

    /**
     * 返回指定错误状态信息
     */
    protected BaseResult responseFail(ResultEnum resultEnum) {
        return response(resultEnum.getCode(), resultEnum.getMsg());
    }

    /**
     * 成功返回数据体
     */
    protected BaseResult responseSuccess() {
        return responseFail(ResultEnum.SUCCESS);
    }

    /**
     * 成功返回数据体
     */
    protected BaseResult responseSuccess(Object obj) {
        return response(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), obj);
    }


    /**
     * 返回分页数据
     *
     * @param obj
     * @param page
     * @return
     */
    protected BaseResult responseSuccess(Object obj, Page page) {
        return new BaseResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), obj, page);
    }

    /**
     * 成功 返回自定义提示信息
     */
    protected BaseResult responseSuccess(String message) {
        return response(ResultEnum.SUCCESS.getCode(), message);
    }

    /**
     * 失败 返回自定义提示信息
     */
    protected BaseResult responseToastError(String message) {
        return response(ResultEnum.TOAST_ERROR.getCode(), message);
    }

}
