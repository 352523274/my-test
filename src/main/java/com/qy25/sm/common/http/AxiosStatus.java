package com.qy25.sm.common.http;

public enum  AxiosStatus {
    OK("操作成功",20000),
    ERROR("操作失败",50000),
    ;
    private String message;
    private int status;

    AxiosStatus() {
    }

    AxiosStatus(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
