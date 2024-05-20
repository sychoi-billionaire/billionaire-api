package com.billionaire.backend.domain.acc.services;

import com.billionaire.backend.domain.acc.dto.AccMst;

public interface AccService {
    AccMst selectAccountWithAccNo(AccMst accMst);
    AccMst updateAccountWithAccNo(AccMst accMst);
}
