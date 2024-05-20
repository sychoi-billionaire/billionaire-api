package com.billionaire.backend.global.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Supplier;

@Getter
@AllArgsConstructor
@ToString
public class BnrException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String remark;

    public static BnrException from(ErrorCode errorCode, String remark) {
        return new BnrException(errorCode, remark);
    }
    public static BnrException from(ErrorCode errorCode) {
        return new BnrException(errorCode, null);
    }
    public static Supplier<BnrException> supplier(ErrorCode errorCode) {
        return () -> BnrException.from(errorCode);
    }
    public static Supplier<BnrException> supplier(ErrorCode errorCode, String remark) {
        return () -> BnrException.from(errorCode, remark);
    }
}