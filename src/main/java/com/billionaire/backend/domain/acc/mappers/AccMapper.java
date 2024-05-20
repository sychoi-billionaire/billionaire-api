package com.billionaire.backend.domain.acc.mappers;

import com.billionaire.backend.domain.acc.dto.AccMst;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AccMapper {
    void updateAccountWithAccNo(AccMst accMst);
    Optional<AccMst> selectAccountWithAccNo(AccMst accMst);
}
