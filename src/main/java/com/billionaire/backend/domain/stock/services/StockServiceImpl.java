package com.billionaire.backend.domain.stock.services;

import com.billionaire.backend.domain.stock.dto.StockMst;
import com.billionaire.backend.domain.stock.dto.StockPrcDtl;
import com.billionaire.backend.domain.stock.dto.StockSearchDto;
import com.billionaire.backend.domain.stock.mappers.StockMapper;
import com.billionaire.backend.global.exceptions.BnrException;
import com.billionaire.backend.global.exceptions.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockMapper stockMapper;

    public StockMst selectStockMstWithTicker(String ticker) {

        return stockMapper.selectStockMstWithTicker(ticker.toUpperCase());
    }
    public StockMst updateStockMst(String ticker, StockMst stockMst) {
        if (stockMst.getTicker().trim().isEmpty()) {
            throw BnrException.from(ErrorCode.BAD_BODY_REQUEST, "Ticker는 필수값입니다.");
        }
        if (!ticker.trim().equalsIgnoreCase(stockMst.getTicker().trim())) {
            throw BnrException.from(ErrorCode.BAD_BODY_REQUEST, "요청하는 URL의 Ticker와 Body의 Ticker가 일치하지 않습니다.");
        }
        stockMst.setModifiedBy("000000");
        stockMst.setTicker(stockMst.getTicker().trim().toUpperCase());
        stockMapper.updateStockMst(stockMst);
        return stockMapper.selectStockMstWithTicker(ticker);
    }
    public List<StockMst> searchStocks(StockSearchDto searchDto) {
        if (searchDto.getKeyword() != null && searchDto.getTickers() != null) {
            throw BnrException.from(ErrorCode.BAD_QUERY_REQUEST, "Keyword와 Ticker를 동시에 명시할 수 없습니다.");
        }
        if (searchDto.getKeyword() != null) {
            return stockMapper.searchStocksByKeyword(searchDto.getKeyword().toUpperCase());
        }
        else {
            return stockMapper.searchStocksByTickers(searchDto.getTickers()
                                                                    .stream()
                                                                    .map(String::toUpperCase)
                                                                    .distinct()
                                                                    .toList()
            );
        }
    }
}
