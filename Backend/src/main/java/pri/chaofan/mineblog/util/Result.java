package pri.chaofan.mineblog.util;

import lombok.Data;

@Data
public class Result<T> {
    /*响应码*/
    private int code;
    /*响应消息*/
    private String msg;
    /*流水号*/
    private String flowcode;
    /*数据单元*/
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(int code, T data){
        this.code = code;
        this.data = data;
    }

    public Result(int code, T data, String message){
        this.code = code;
        this.data = data;
        this.msg = message;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * for success
     */
    public static <T> Result<T> success(int code, T data) {
        return new Result<T>(code,data);
    }
    public static <T> Result<T> success(int code, T data, String msg) {
        return new Result<T>(code,data, msg);
    }


    /**
     * for error
     */
    public static <T> Result<T> error(int code, String msg) {
        return new Result<T>(code, msg);
    }


}