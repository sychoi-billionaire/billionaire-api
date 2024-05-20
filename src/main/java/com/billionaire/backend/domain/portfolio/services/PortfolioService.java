package com.billionaire.backend.domain.portfolio.services;

import com.billionaire.backend.domain.portfolio.dto.PortfolioAssetDtl;
import com.billionaire.backend.domain.portfolio.dto.PortfolioAccDtl;
import com.billionaire.backend.domain.portfolio.dto.PortfolioMst;
import com.billionaire.backend.domain.portfolio.dto.PortfolioSearchDto;
import com.billionaire.backend.domain.stock.dto.StockPrcDtl;

import java.util.List;

public interface PortfolioService {
    PortfolioMst selectOnePortfolioMst(PortfolioMst portfolioMst);
    List<PortfolioMst> selectManyPortfolioMst(PortfolioMst portfolioMst);
    PortfolioAccDtl selectOnePortfolioAccDtl (PortfolioAccDtl portfolioAccDtl);
    PortfolioAccDtl updatePortfolioAccDtl(PortfolioAccDtl portfolioAccDtl);
    PortfolioAssetDtl updatePortfolioAssetDtl(PortfolioAssetDtl portfolioAssetDtl);
    PortfolioAssetDtl insertPortfolioAssetDtl(PortfolioAssetDtl portfolioAssetDtl);
    List<StockPrcDtl> selectStockPricesForPortfolioMst(long portfolioNo);

    void deleteManyPortfolioAssetDtl(PortfolioSearchDto portfolioSearchDto);
}
