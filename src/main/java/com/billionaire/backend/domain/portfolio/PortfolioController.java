package com.billionaire.backend.domain.portfolio;

import com.billionaire.backend.domain.portfolio.dto.PortfolioAssetDtl;
import com.billionaire.backend.domain.portfolio.dto.PortfolioAccDtl;
import com.billionaire.backend.domain.portfolio.dto.PortfolioMst;
import com.billionaire.backend.domain.portfolio.dto.PortfolioSearchDto;
import com.billionaire.backend.domain.portfolio.services.PortfolioService;
import com.billionaire.backend.domain.stock.dto.StockPrcDtl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolios")
@RequiredArgsConstructor
@Slf4j
public class PortfolioController {

    private final PortfolioService portfolioService;

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioMst> getOnePortfolioMst(@PathVariable long id) {

        PortfolioMst param = new PortfolioMst();
        param.setPortfolioNo(id);
        PortfolioMst result = portfolioService.selectOnePortfolioMst(param);

        return ResponseEntity.ok(result);
    }
//
//    @GetMapping("/{id}/stocks/prices")
//    public ResponseEntity<List<StockPrcDtl>> getStockPricesForPortfolioMst(@PathVariable long id) {
//
//        List<StockPrcDtl> result = portfolioService.selectStockPricesForPortfolioMst(id);
//        return ResponseEntity.ok(result);
//    }

    @PatchMapping("/{portfolioNo}/accounts/{accNo}")
    public ResponseEntity<PortfolioAccDtl> updatePortfolioAccDtl(@PathVariable long portfolioNo, @PathVariable long accNo, @RequestBody PortfolioAccDtl portfolioAccDtl){
        portfolioAccDtl.setPortfolioNo(portfolioNo);
        portfolioAccDtl.setAccNo(accNo);

        PortfolioAccDtl updateResult = portfolioService.updatePortfolioAccDtl(portfolioAccDtl);
        return ResponseEntity.ok(updateResult);
    }

    @GetMapping("/{portfolioNo}/accounts/{accNo}")
    public ResponseEntity<PortfolioAccDtl> getOnePortfolioAccDtl(
            @PathVariable long portfolioNo,
            @PathVariable long accNo
    ) {
        PortfolioAccDtl accDtl = PortfolioAccDtl.builder()
                                                .portfolioNo(portfolioNo)
                                                .accNo(accNo)
                                                .build();
        PortfolioAccDtl result = portfolioService.selectOnePortfolioAccDtl(accDtl);
        return ResponseEntity.ok(result);
    }


    @PatchMapping("/{portfolioNo}/accounts/{accNo}/stocks/{ticker}")
    public ResponseEntity<PortfolioAssetDtl> updatePortfolioAssetDtl(
            @PathVariable long portfolioNo,
            @PathVariable long accNo,
            @PathVariable String ticker,
            @RequestBody PortfolioAssetDtl portfolioAssetDtl
    ) {
        portfolioAssetDtl.setPortfolioNo(portfolioNo);
        portfolioAssetDtl.setAccNo(accNo);
        portfolioAssetDtl.setTicker(ticker);

        PortfolioAssetDtl result = portfolioService.updatePortfolioAssetDtl(portfolioAssetDtl);
        return ResponseEntity.ok(result);
    }


    @PostMapping("/{portfolioNo}/accounts/{accNo}/stocks")
    public ResponseEntity<PortfolioAssetDtl> createPortfolioAssetDtl(
            @PathVariable long portfolioNo,
            @PathVariable long accNo,
            @RequestBody PortfolioAssetDtl portfolioAssetDtl
    ) {
        portfolioAssetDtl.setPortfolioNo(portfolioNo);
        portfolioAssetDtl.setAccNo(accNo);

        PortfolioAssetDtl result = portfolioService.insertPortfolioAssetDtl(portfolioAssetDtl);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{portfolioNo}/accounts/{accNo}/stocks")
    public ResponseEntity<?> deleteManyPortfolioAssetDtl(
            @PathVariable long portfolioNo,
            @PathVariable long accNo,
            @RequestParam List<String> tickers
    ) {
        PortfolioSearchDto portfolioSearchDto = PortfolioSearchDto.builder()
                                                .portfolioNo(portfolioNo)
                                                .accNo(accNo)
                                                .tickers(tickers)
                                                .build();
        portfolioService.deleteManyPortfolioAssetDtl(portfolioSearchDto);
        return ResponseEntity.ok().build();
    }

}
