package com.billionaire.backend.domain.acc.services;

import com.billionaire.backend.domain.acc.dto.AccMst;
import com.billionaire.backend.domain.acc.mappers.AccMapper;
import com.billionaire.backend.global.exceptions.BnrException;
import com.billionaire.backend.global.exceptions.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccServiceImpl implements AccService {
    private final AccMapper accMapper;

    public AccMst selectAccountWithAccNo(AccMst accMst) {
        return accMapper.selectAccountWithAccNo(accMst)
                .orElseThrow(BnrException.supplier(ErrorCode.ACC_MST_NOT_FOUND, "해당 AccNo로 조회되는 계좌가 없습니다"));
    }
    public AccMst updateAccountWithAccNo(AccMst accMst) {
        accMapper.updateAccountWithAccNo(accMst);
        return selectAccountWithAccNo(accMst);
    }
}
