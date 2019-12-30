package com.tianxing.common.exception;

/**
 * @program: tianxing
 * @author: 许仕昊
 * @create: 2019-12-30 10:31
 **/

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -2057022192639563821L;

    public ServiceException() {
        super();

    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}