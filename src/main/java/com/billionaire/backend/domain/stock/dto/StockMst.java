package com.billionaire.backend.domain.stock.dto;

import com.billionaire.backend.global.common.BaseAuditDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = true)
public class StockMst extends BaseAuditDto {
    private String ticker;
    private String kisCd;
    private String exchCd;
    private String stockNameKor;
    private String stockNameEng;
    private String stockCurrency;
    private String assetClassCd;
    private String assetClassName;
    private String assetCountryCd;
    private String assetCountryName;
    private String secTypeCd;
    private String stockBgColorHex;
    private String stockIconUrl;
    private Timestamp tradeTimestamp;
    private Double price;
    private int volume;
    private Double krwUsd;
}
