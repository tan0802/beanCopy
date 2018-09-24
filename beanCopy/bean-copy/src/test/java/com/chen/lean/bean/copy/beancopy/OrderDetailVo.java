package com.chen.lean.bean.copy.beancopy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@NoArgsConstructor
//@ToString
public class OrderDetailVo {
    private String id;
    private String OrderId;
    private String createTime;
    private String amount;

    public OrderDetailVo(String id, String orderId, String createTime, String amount) {
        this.id = id;
        OrderId = orderId;
        this.createTime = createTime;
        this.amount = amount;
    }

    public OrderDetailVo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDetailVo{" +
                "id='" + id + '\'' +
                ", OrderId='" + OrderId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }





}
