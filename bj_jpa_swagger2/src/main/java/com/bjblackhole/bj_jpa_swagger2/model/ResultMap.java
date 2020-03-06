package com.bjblackhole.bj_jpa_swagger2.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:ResultMap
 * Package:com.bjblackhole.bj_jpa_swagger2.model
 * Description:
 *
 * @Date:2020/03/04 0004 17:33
 * @Author:mavin001@163.com
 */
@Data
public class ResultMap implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 业务状态码
     */
    private Integer code;
    /**
     * 业务信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    public ResultMap() {
    }
    /**
     * 构造可自定义返回
     *
     * @param code
     * @param message
     * @param data
     */
    public ResultMap(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 无返回数据操作成功
     *
     * @return
     */
    public static ResultMap success() {
        return new ResultMap(Constants.SUCCESS_CODE, Constants.SUCCESS, null);
    }

    /**
     * 无返回数据操作成功返回自定义信息
     *
     * @param message
     * @return
     */
    public static ResultMap success(String message) {
        return new ResultMap(Constants.SUCCESS_CODE, message, null);
    }

    /**
     * 有返回数据操作成功返回
     *
     * @param data
     * @return
     */
    public static ResultMap successData(Object data) {
        if(data==null){
            data="";
        }
        return new ResultMap(Constants.SUCCESS_CODE, Constants.SUCCESS, data);
    }

    /**
     * 有返回数据操作成功需要自定义返回信息
     *
     * @param message
     * @param data
     * @return
     */
    public static ResultMap success(String message, Object data) {
        return new ResultMap(Constants.SUCCESS_CODE, message, data);
    }

    /**
     * 未知错误 操作失败
     *
     * @return
     */
    public static ResultMap error() {
        return new ResultMap(Constants.ERROR_CODE, Constants.ERROR, null);
    }

    /**
     * 错误 自定义状态码和返回信息
     *
     * @param code
     * @param message
     * @return
     */
    public static ResultMap error(Integer code, String message) {
        return new ResultMap(code, message, null);
    }
    /**
     * 成功 自定义状态码和返回信息
     *
     * @param code
     * @param message
     * @return
     */
    public static ResultMap success(Integer code, String message) {
        return new ResultMap(code, message, null);
    }
    /**
     * 未知错误 自定义返回信息
     *
     * @param message
     * @return
     */
    public static ResultMap error(String message) {
        return new ResultMap(Constants.ERROR_CODE, message, null);
    }

    /**
     * 未找到数据
     *
     * @return
     */
    public static ResultMap notFind() {
        return new ResultMap(Constants.NOT_FIND_CODE, Constants.NOT_FIND, null);
    }

    /**
     * 未找到数据 自定义返回信息
     *
     * @param message
     * @return
     */
    public static ResultMap notFind(String message) {
        return new ResultMap(Constants.NOT_FIND_CODE, message, null);
    }

    /**
     *
     * @param resultMap
     * @return
     */
    public static JSONArray analysis(ResultMap resultMap) {
        String s = JSONObject.toJSONString(resultMap);
        JSONObject jsonObject = JSONArray.parseObject(s);
        JSONObject data = (JSONObject)jsonObject.get("data");
        Object rows = data.get("rows");
        String page = JSONObject.toJSONString(rows);
        JSONArray pageRows = JSONArray.parseArray(page);
        return  pageRows;
    }
}

