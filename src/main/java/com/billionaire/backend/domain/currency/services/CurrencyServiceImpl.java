package com.billionaire.backend.domain.currency.services;

import com.billionaire.backend.domain.currency.dto.CurrencyMst;
import com.billionaire.backend.domain.currency.mappers.CurrencyMapper;
import com.billionaire.backend.global.exceptions.BnrException;
import com.billionaire.backend.global.exceptions.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyMapper currencyMapper;

    public CurrencyMst selectCurrencyMst(CurrencyMst currencyMst) {
        return currencyMapper.selectCurrencyMst(currencyMst)
                .orElseThrow(BnrException.supplier(ErrorCode.CURRENCY_MST_NOT_FOUND, "해당 Currency Code로 조회되는 환율정보가 없습니다"));
    }
}
