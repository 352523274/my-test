package com.qy25.sm.common.http;

import lombok.Data;

@Data
public class AxiosResult<T> {
    private String message;
    private int status;
    private T data;


    private AxiosResult() {
    }

    /**
     * 给Axiosresult 赋值
     * @param axiosResult
     * @param data
     * @return
     */
    private static<T> AxiosResult<T> setAxiosResult(AxiosStatus axiosResult,T data){
        AxiosResult<T> tAxiosResult = new AxiosResult<>();
        tAxiosResult.setMessage(axiosResult.getMessage());
        tAxiosResult.setStatus(axiosResult.getStatus());
        tAxiosResult.setData(data);
        return tAxiosResult;
    }
    /**
     * 成功不返回数据
     */
    public static <T> AxiosResult<T> success(){
        return setAxiosResult(AxiosStatus.OK, null);
    }
    /**
     * 成功返回数据
     */
    public static <T> AxiosResult<T> success(T data){
        return setAxiosResult(AxiosStatus.OK, data);
    }
    /**
     * 成功返回自定义状态码
     */
    public static <T> AxiosResult<T> success(AxiosStatus axiosStatus){
        return setAxiosResult(AxiosStatus.OK, null);
    }

    /**
     * 加数据
     */
    public static <T> AxiosResult<T> success(AxiosStatus axiosStatus,T data){
        return setAxiosResult(AxiosStatus.OK, data);
    }
    /**
     * 失败不返回数据
     */
    public static <T> AxiosResult<T> error(){
        return setAxiosResult(AxiosStatus.ERROR, null);
    }
    /**
     * 失败返回数据
     */
    public static <T> AxiosResult<T> error(T data){
        return setAxiosResult(AxiosStatus.ERROR, data);
    }
    /**
     * 失败返回自定义状态码
     */
    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus){
        return setAxiosResult(AxiosStatus.ERROR, null);
    }

    /**
     * 加数据
     */
    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus,T data){
        return setAxiosResult(AxiosStatus.ERROR, data);
    }

}
