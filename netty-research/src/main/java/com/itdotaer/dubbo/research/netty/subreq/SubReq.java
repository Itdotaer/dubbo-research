package com.itdotaer.dubbo.research.netty.subreq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * SubReq
 *
 * @author jt_hu
 * @date 2018/9/28
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private long orderId;
    private String productName;
    private BigDecimal price;

    @Override
    public String toString() {
        return String.format("OrderId: %s; ProductName: %s; Price: %s;",
                this.getOrderId(), this.getProductName(), this.getPrice().toString());
    }
}
