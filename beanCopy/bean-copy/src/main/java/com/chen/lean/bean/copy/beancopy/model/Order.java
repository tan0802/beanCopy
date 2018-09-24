package com.chen.lean.bean.copy.beancopy.model;


import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private BigDecimal amount;
    private Date createTime;
    private Good good;

//
//    public Order(Long id, BigDecimal amount, Date createTime, Good good) {
//        this.id = id;
//        this.amount = amount;
//        this.createTime = createTime;
//        this.good = good;
//    }
//
//
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public BigDecimal getAmount() {
//        return amount;
//    }
//
//    public void setAmount(BigDecimal amount) {
//        this.amount = amount;
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Good getGood() {
//        return good;
//    }
//
//    public void setGood(Good good) {
//        this.good = good;
//    }
//
//    public Order() {
//    }
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "id=" + id +
//                ", amount=" + amount +
//                ", createTime=" + createTime +
//                ", good=" + good +
//                '}';
//    }




}
