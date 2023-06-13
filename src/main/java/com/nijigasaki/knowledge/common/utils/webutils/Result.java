package com.nijigasaki.knowledge.common.utils.webutils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private T data;
    private String status = "200";
    private String message;
    private String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss SSSSSSSSS"));

    public Result(String message) {
        this.message = message;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> Result<T> success() {
        return new Result<>("成功");
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>("成功").setData(data);
    }

    public static  Result<String> error(Throwable throwable) {
        Result<String> result = new Result<>();
        result.setData(throwable.getMessage());
        result.setMessage("失败");
        return result;
    }

    public static Result<String> error(String status,String data) {
        Result<String> result = new Result<>();
        result.setData(data);
        result.setMessage("失败");
        result.setStatus(status);
        return result;
    }
}
