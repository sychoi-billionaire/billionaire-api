package com.billionaire.backend.domain.stock.dto;

import lombok.Data;

import java.util.List;

@Data
public class StockSearchDto {
    String keyword;
    List<String> tickers;
}
