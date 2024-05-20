package com.billionaire.backend.domain.portfolio.dto;

import com.billionaire.backend.global.common.BaseAuditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PortfolioMst extends BaseAuditDto {
    private Long portfolioNo;
    private String userNo;
    private String portfolioName;
    private Date baseDate;
    private String planYn;
    private List<PortfolioAccDtl> accounts;
}
