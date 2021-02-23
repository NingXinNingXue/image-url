package com.example.img.url.model.dto;

/**
 * @Description: 用于返回图片链接的类
 * @author: 凝血
 **/
public class JsonResult<T> {
    private T data;
    private String code;
    private String msg;

    public JsonResult() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
