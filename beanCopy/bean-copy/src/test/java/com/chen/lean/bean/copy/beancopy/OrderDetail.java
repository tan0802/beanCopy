package com.chen.lean.bean.copy.beancopy;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class OrderDetail {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OrderDetail(Long id, Long orderId, Date createTime, BigDecimal amount) {
        this.id = id;
        OrderId = orderId;
        this.createTime = createTime;
        this.amount = amount;
    }

    public OrderDetail() {
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", OrderId=" + OrderId +
                ", createTime=" + createTime +
                ", amount=" + amount +
                '}';
    }

    private Long id;
    private Long OrderId;
    private Date createTime;
    private BigDecimal amount;

}
