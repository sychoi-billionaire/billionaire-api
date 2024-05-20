package com.billionaire.backend.domain.currency.mappers;

import com.billionaire.backend.domain.currency.dto.CurrencyMst;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface CurrencyMapper {
    Optional<CurrencyMst> selectCurrencyMst(CurrencyMst accMst);
}
