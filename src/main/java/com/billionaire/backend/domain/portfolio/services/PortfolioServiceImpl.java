package com.billionaire.backend.domain.portfolio.services;

import com.billionaire.backend.domain.acc.dto.AccMst;
import com.billionaire.backend.domain.acc.services.AccService;
import com.billionaire.backend.domain.portfolio.dto.PortfolioAssetDtl;
import com.billionaire.backend.domain.portfolio.dto.PortfolioAccDtl;
import com.billionaire.backend.domain.portfolio.dto.PortfolioMst;
import com.billionaire.backend.domain.portfolio.dto.PortfolioSearchDto;
import com.billionaire.backend.domain.portfolio.mappers.PortfolioMapper;
import com.billionaire.backend.domain.stock.dto.StockPrcDtl;
import com.billionaire.backend.domain.stock.mappers.StockMapper;
import com.billionaire.backend.global.exceptions.BnrException;
import com.billionaire.backend.global.exceptions.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioMapper portfolioMapper;
    @Override
    public PortfolioMst selectOnePortfolioMst(PortfolioMst param) {
        return portfolioMapper.selectOnePortfolioMst(param)
                .orElseThrow(BnrException.supplier(ErrorCode.PORTFOLIO_MST_NOT_FOUND, "해당 PortfolioNo에 일치하는 Portfolio가 없습니다."));
    }

    public List<PortfolioMst> selectManyPortfolioMst(PortfolioMst portfolioMst) {
        List<PortfolioMst> portfolioMstList = portfolioMapper.selectManyPortfolioMst(portfolioMst);
        if (portfolioMstList.isEmpty()) {
            return List.of();
        }
        return portfolioMstList;
    }
    public PortfolioAccDtl selectOnePortfolioAccDtl (PortfolioAccDtl portfolioAccDtl) {
        return portfolioMapper.selectOnePortfolioAccDtl(portfolioAccDtl)
                .orElseThrow(BnrException.supplier(ErrorCode.PORTFOLIO_ACC_DTL_NOT_FOUND, "해당 PortfolioNo에 해당하는 계좌가 없습니다."));
    }
    public PortfolioAccDtl updatePortfolioAccDtl(PortfolioAccDtl portfolioAccDtl) {
        portfolioMapper.updatePortfolioAccDtl(portfolioAccDtl);
        return selectOnePortfolioAccDtl(portfolioAccDtl);
    }

    public PortfolioAssetDtl updatePortfolioAssetDtl(PortfolioAssetDtl portfolioAssetDtl) {
        PortfolioAssetDtl dtl = portfolioMapper.selectPortfolioAssetDtl(portfolioAssetDtl);
        if (dtl == null) {
            throw BnrException.from(ErrorCode.PORTFOLIO_ASSET_DTL_NOT_FOUND, "해당 계좌에 변경 대상 주식이 없습니다.");
        }
        portfolioMapper.updatePortfolioAssetDtl(portfolioAssetDtl);
        return portfolioMapper.selectPortfolioAssetDtl(portfolioAssetDtl);
    }

    public PortfolioAssetDtl insertPortfolioAssetDtl(PortfolioAssetDtl portfolioAssetDtl) {
        PortfolioAssetDtl dtl = portfolioMapper.selectPortfolioAssetDtl(portfolioAssetDtl);
        if (dtl != null) {
            throw BnrException.from(ErrorCode.PORTFOLIO_ASSET_DTL_CONFLICT, "해당 계좌에 이미 동일한 주식이 존재합니다.");
        }
        portfolioMapper.insertPortfolioAssetDtl(portfolioAssetDtl);
        return portfolioMapper.selectPortfolioAssetDtl(portfolioAssetDtl);
    }

    public List<StockPrcDtl> selectStockPricesForPortfolioMst(long portfolioNo) {
        return portfolioMapper.selectStockPricesForPortfolioMst(portfolioNo);
    }

    public void deleteManyPortfolioAssetDtl(PortfolioSearchDto portfolioSearchDto) {
        portfolioMapper.deleteManyPortfolioAssetDtl(portfolioSearchDto);
    }
}
