package com.billionaire.backend.domain.portfolio.mappers;

import com.billionaire.backend.domain.portfolio.dto.PortfolioAssetDtl;
import com.billionaire.backend.domain.portfolio.dto.PortfolioAccDtl;
import com.billionaire.backend.domain.portfolio.dto.PortfolioMst;
import com.billionaire.backend.domain.portfolio.dto.PortfolioSearchDto;
import com.billionaire.backend.domain.stock.dto.StockPrcDtl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PortfolioMapper {
    Optional<PortfolioMst> selectOnePortfolioMst(PortfolioMst portfolioMst);
    List<PortfolioMst> selectManyPortfolioMst(PortfolioMst portfolioMst);

    void updatePortfolioAccDtl(PortfolioAccDtl portfolioAccDtl);

    PortfolioAssetDtl selectPortfolioAssetDtl(PortfolioAssetDtl portfolioAssetDtl);

    void insertPortfolioAssetDtl(PortfolioAssetDtl portfolioAssetDtl);

    void updatePortfolioAssetDtl(PortfolioAssetDtl portfolioAssetDtl);

    List<StockPrcDtl> selectStockPricesForPortfolioMst(long portfolioNo);

    void deleteManyPortfolioAssetDtl(PortfolioSearchDto portfolioSearchDto);

    Optional<PortfolioAccDtl> selectOnePortfolioAccDtl(PortfolioAccDtl portfolioAccDtl);
}
