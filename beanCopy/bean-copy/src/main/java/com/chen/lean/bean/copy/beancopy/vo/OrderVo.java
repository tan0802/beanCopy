package com.chen.lean.bean.copy.beancopy.vo;


import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {

    private String orderId;
    private String amount;
    private String createTime;
    private GoodVo goodVo;


//    public String getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(String orderId) {
//        this.orderId = orderId;
//    }
//
//    public String getAmount() {
//        return amount;
//    }
//
//    public void setAmount(String amount) {
//        this.amount = amount;
//    }
//
//    public String getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(String createTime) {
//        this.createTime = createTime;
//    }
//
//    public GoodVo getGoodVo() {
//        return goodVo;
//    }
//
//    public void setGoodVo(GoodVo goodVo) {
//        this.goodVo = goodVo;
//    }
//
//    public OrderVo(String orderId, String amount, String createTime, GoodVo goodVo) {
//        this.orderId = orderId;
//        this.amount = amount;
//        this.createTime = createTime;
//        this.goodVo = goodVo;
//    }
//
//    public OrderVo() {
//    }
//
//    @Override
//    public String toString() {
//        return "OrderVo{" +
//                "orderId='" + orderId + '\'' +
//                ", amount='" + amount + '\'' +
//                ", createTime='" + createTime + '\'' +
//                ", goodVo=" + goodVo +
//                '}';
//    }


}
