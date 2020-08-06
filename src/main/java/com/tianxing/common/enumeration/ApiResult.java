package com.tianxing.common.enumeration;

import lombok.Getter;
import lombok.Setter;

/**
 * <p> 返回码 </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-07 16:46
 **/

@Getter
@Setter
public class ApiResult<T> {
    /** 成功 */
    public static final int SUCCESS = 200;

    /** 没有登录 */
    public static final int NOT_LOGIN = 400;

    /** 发生异常 */
    public static final int EXCEPTION = 401;

    /** 系统错误 */
    public static final int SYS_ERROR = 402;

    /** 参数错误 */
    public static final int PARAMS_ERROR = 403;

    /** 不支持或已经废弃 */
    public static final int NOT_SUPPORTED = 410;

    /** AuthCode错误 */
    public static final int INVALID_AUTHCODE = 444;

    /** 太频繁的调用 */
    public static final int TOO_FREQUENT = 445;

    /** 未知的错误 */
    public static final int UNKNOWN_ERROR = 499;

    private int code;
    private String message;
    private T data;



    public static ApiResult fail(String message) {
        return new ApiResult();
    }
    public static ApiResult fail(int code) {
        return new ApiResult().code(code);
    }
    public static ApiResult fail(int code, String message) {
        return new ApiResult<String>().code(code).message(message);
    }
    public static <T> ApiResult<T> fail(int code, T data) {
        return new ApiResult<T>().code(code).data(data);
    }
    public static <T> ApiResult<T> fail(int code, String message, T data) {
        return new ApiResult<T>().code(code).message(message).data(data);
    }

    public ApiResult<T> code(int code) {
        this.code = code;
        return this;
    }
    public ApiResult<T> message(String message) {
        this.message = message;
        return this;
    }
    public ApiResult<T> data(T data) {
        this.data = data;
        return this;
    }


    public static ApiResult ok() {
        return fail(SUCCESS);
    }
    public static ApiResult ok(String message) {
        return fail(SUCCESS, message);
    }
    public static <T> ApiResult<T> ok(T data) {
        return fail(SUCCESS, data);
    }
    public static <T> ApiResult<T> ok(String message, T data) {
        return fail(SUCCESS, message, data);
    }
    public static ApiResult err() {
        return fail(EXCEPTION);
    }
    public static ApiResult err(String message) {
        return fail(EXCEPTION, message);
    }

    @Override
    public String toString() {
        return JsonUtil.to(this);
    }
}
