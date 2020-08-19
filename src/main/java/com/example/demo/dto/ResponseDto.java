package com.example.demo.dto;

import java.util.List;

public class ResponseDto<T>{
    private String message;
    private int status;

    private T data;
    private List<T> datas;

    public ResponseDto() {
    }

    public ResponseDto(String message, int status, T data, List<T> datas) {
        this.message = message;
        this.status = status;
        this.data = data;
        this.datas = datas;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }



}
