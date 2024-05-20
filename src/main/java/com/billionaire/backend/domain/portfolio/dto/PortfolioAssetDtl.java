package com.billionaire.backend.domain.portfolio.dto;

import com.billionaire.backend.global.common.BaseAuditDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = true)
public class PortfolioAssetDtl extends BaseAuditDto {
    @JsonInclude(Include.NON_NULL)
    private Long portfolioNo;
    @JsonInclude(Include.NON_NULL)
    private Long accNo;
    @JsonInclude(Include.NON_NULL)
    private String ticker;
    private int quantity;
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
    @JsonInclude(Include.NON_NULL)
    private Timestamp tradeTimestamp;
    @JsonInclude(Include.NON_NULL)
    private Double price;
    @JsonInclude(Include.NON_NULL)
    private int volume;
    @JsonInclude(Include.NON_NULL)
    private int krwUsd;
}
