package com.billionaire.backend.domain.currency.services;

import com.billionaire.backend.domain.currency.dto.CurrencyMst;

public interface CurrencyService {
    CurrencyMst selectCurrencyMst(CurrencyMst currencyMst);
}
