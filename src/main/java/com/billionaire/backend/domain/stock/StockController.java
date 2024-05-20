package com.billionaire.backend.domain.stock;

import com.billionaire.backend.domain.stock.dto.StockMst;
import com.billionaire.backend.domain.stock.dto.StockSearchDto;
import com.billionaire.backend.domain.stock.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping("")
    public ResponseEntity<List<StockMst>> searchStocks(StockSearchDto searchDto) {
        List<StockMst> searchResult = stockService.searchStocks(searchDto);
        return ResponseEntity.ok(searchResult);
    }

    @GetMapping("{ticker}")
    public ResponseEntity<StockMst> getOneStockMst(@PathVariable String ticker) {
        StockMst stock = stockService.selectStockMstWithTicker(ticker);
        return ResponseEntity.ok(stock);
    }

    @PatchMapping("{ticker}")
    public ResponseEntity<StockMst> updateStock(@PathVariable String ticker, @RequestBody StockMst stockMst) {
        StockMst updatedStock = stockService.updateStockMst(ticker, stockMst);
        return ResponseEntity.ok(updatedStock);
    }

}
