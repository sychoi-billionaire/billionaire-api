package com.billionaire.backend.domain.currency.dto;

import com.billionaire.backend.global.common.BaseAuditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class CurrencyMst extends BaseAuditDto {
    private String code;
    private String currencyCode;
    private String currencyName;
    private String country;
    private Double lastPrice;
    private Date recordedAt;
    private Integer currencyUnit;
}

