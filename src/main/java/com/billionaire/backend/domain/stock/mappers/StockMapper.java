package com.billionaire.backend.domain.stock.mappers;

import com.billionaire.backend.domain.stock.dto.StockMst;
import com.billionaire.backend.domain.stock.dto.StockPrcDtl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {

    StockMst selectStockMstWithTicker(String ticker);

    void updateStockMst(StockMst stockMst);

    List<StockMst> searchStocksByKeyword(String keyword);

    List<StockMst> searchStocksByTickers(List<String> tickers);
}
