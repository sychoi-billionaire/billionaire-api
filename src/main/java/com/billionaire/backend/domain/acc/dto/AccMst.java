package com.billionaire.backend.domain.acc.dto;

import com.billionaire.backend.domain.portfolio.dto.PortfolioAccDtl;
import com.billionaire.backend.global.common.BaseAuditDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class AccMst extends BaseAuditDto {
    private Long accNo;
    private String userNo;
    private String accName;
    private String accIssuer;
    private String accCurrency;
    private String accBgColorHex;
    private String accIconUrl;

    public static AccMst from(PortfolioAccDtl portfolioAccDtl) {
        return AccMst.builder()
                .accNo(portfolioAccDtl.getAccNo())
                .accName(portfolioAccDtl.getAccName())
                .accCurrency(portfolioAccDtl.getAccCurrency())
                .accBgColorHex(portfolioAccDtl.getAccBgColorHex())
                .accIconUrl(portfolioAccDtl.getAccIconUrl())
                .accIssuer(portfolioAccDtl.getAccIssuer())
                .createdBy(portfolioAccDtl.getCreatedBy())
                .modifiedBy(portfolioAccDtl.getModifiedBy())
                .build();
    }
}

