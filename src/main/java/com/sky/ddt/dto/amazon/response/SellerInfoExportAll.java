package com.sky.ddt.dto.amazon.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SellerInfoExportAll {
    String transaction_type;
    String price_type;
    String item_related_fee_type;
    String 	promotion_type;
    String 	direct_payment_type;
    BigDecimal amount;


}
