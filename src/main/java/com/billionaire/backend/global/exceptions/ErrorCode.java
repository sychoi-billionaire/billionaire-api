package com.billionaire.backend.global.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    /* 400 */
    BAD_BODY_REQUEST(HttpStatus.BAD_REQUEST, "Wrong Body Format.", "C4001"), // C4001 <- C (Common) 400 (Status code)  1 (SEQ)
    BAD_QUERY_REQUEST(HttpStatus.BAD_REQUEST, "Wrong Query Format.", "C4002"),

    /* 404 */
    PORTFOLIO_MST_NOT_FOUND(HttpStatus.NOT_FOUND, "PORTFOLIO_MST Not Found.", "P4041"), // P4041 <- P (Portfolio) 404 (Status code) 1 (SEQ)
    PORTFOLIO_ACC_DTL_NOT_FOUND(HttpStatus.NOT_FOUND, "PORTFOLIO_ACC_DTL Not Found.", "P4042"),
    PORTFOLIO_ASSET_DTL_NOT_FOUND(HttpStatus.NOT_FOUND, "PORTFOLIO_ASSET_DTL Not Found.", "P4043"),
    ACC_MST_NOT_FOUND(HttpStatus.NOT_FOUND, "Account Not Found.", "P4044"),
    CURRENCY_MST_NOT_FOUND(HttpStatus.NOT_FOUND, "Currency Not Found.", "P4045"),

    /* 409 */
    PORTFOLIO_ASSET_DTL_CONFLICT(HttpStatus.CONFLICT, "PORTFOLIO_ASSET_DTL Conflicts.", "P4091")


    ;

    private final HttpStatus status;
    private final String message;
    private final String code;

    @Override
    public String toString() {
        return this.status + " " + message + " " + code;
    }
}
