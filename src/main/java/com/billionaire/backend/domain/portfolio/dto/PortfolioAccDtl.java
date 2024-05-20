package com.billionaire.backend.domain.portfolio.dto;

import com.billionaire.backend.global.common.BaseAuditDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PortfolioAccDtl extends BaseAuditDto {
    @JsonInclude(Include.NON_NULL)
    private Long portfolioNo;
    private Long accNo;
    private Long budgetAmount;
    private String userNo;
    private String accName;
    private String accIssuer;
    private String accCurrency;
    private String accBgColorHex;
    private String accIconUrl;
    private List<PortfolioAssetDtl> stocks;

}
