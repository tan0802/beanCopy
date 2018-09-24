package com.chen.lean.bean.copy.beancopy;

//import org.dozer.DozerBeanMapper;

import com.chen.lean.bean.copy.beancopy.mapstruct.mapper.OrderMapper;
import com.chen.lean.bean.copy.beancopy.mapstruct.mapper.OrderMapper2;

import java.math.BigDecimal;
import java.util.Date;

public class Test {

    public static void  main(String[] args){

//        OrderDetail orderDetail = new OrderDetail();
////        orderDetail.setCreateTime(new Date());
//        orderDetail.setAmount(new BigDecimal(20.00));
//        orderDetail.setId(1L);
//        orderDetail.setOrderId(2L);
//        OrderDetailVo orderDetailVo = OrderMapper2.MAPPER.toOrderDetailVo(orderDetail);
//                System.out.println("==="+ orderDetailVo);

        OrderDetailVo orderDetailVo = new OrderDetailVo("1", "2", "", "20.01");

        OrderDetail orderDetail = OrderMapper2.MAPPER.fromOrderDetailVo(orderDetailVo);
        System.out.println("orderDetail="+orderDetail);
    }

}