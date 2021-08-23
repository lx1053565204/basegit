package com.luxu.basegit.exception;

/**
 * @author luxu
 * @version 1.0
 * @date 2021/6/25 16:20
 */
public class LoginBaseException extends Exception{
    private String code;

    private String message;

    public LoginBaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
