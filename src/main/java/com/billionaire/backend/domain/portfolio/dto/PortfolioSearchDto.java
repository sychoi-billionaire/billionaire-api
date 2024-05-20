package com.billionaire.backend.domain.portfolio.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PortfolioSearchDto {
    private Long portfolioNo;
    private Long accNo;
    private final List<String> tickers;
}
