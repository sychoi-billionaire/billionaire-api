package com.billionaire.backend.domain.stock.services;

import com.billionaire.backend.domain.stock.dto.StockMst;
import com.billionaire.backend.domain.stock.dto.StockSearchDto;

import java.util.List;

public interface StockService {
    List<StockMst> searchStocks(StockSearchDto stockSearchDto);

    StockMst selectStockMstWithTicker(String ticker);

    StockMst updateStockMst(String ticker, StockMst stockMst);
}
