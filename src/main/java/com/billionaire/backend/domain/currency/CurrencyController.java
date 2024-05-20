package com.billionaire.backend.domain.currency;

import com.billionaire.backend.domain.currency.dto.CurrencyMst;
import com.billionaire.backend.domain.currency.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
@Slf4j
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping("/{code}")
    public ResponseEntity<CurrencyMst> getCurrency(@PathVariable String code){
        CurrencyMst currencyMst = new CurrencyMst();
        currencyMst.setCode(code);
        CurrencyMst result = currencyService.selectCurrencyMst(currencyMst);
        return ResponseEntity.ok(result);
    }
}
