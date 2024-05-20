package com.billionaire.backend.domain.stock.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class StockPrcDtl {
    private String ticker;
    private Timestamp tradeTimestamp;
    private Double price;
    private int volume;
}
