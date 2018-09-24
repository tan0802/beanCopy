package com.chen.lean.bean.copy.beancopy.service;

import com.chen.lean.bean.copy.beancopy.mapstruct.OrderMapper;
import com.chen.lean.bean.copy.beancopy.model.Good;
import com.chen.lean.bean.copy.beancopy.model.Order;
import com.chen.lean.bean.copy.beancopy.vo.GoodVo;
import com.chen.lean.bean.copy.beancopy.vo.OrderVo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Service
public class OrderService {
    public OrderVo toOrderVo() {
        Good good = new Good(2L, "商品名称");
        Order order = new Order(1L, new BigDecimal(12.216), new Date(), good);

        return OrderMapper.MAPPER.toOrderVo(order);


    }

    public Order fromOrderVo() {
        GoodVo goodVo = new GoodVo("22", "商品名");
        OrderVo orderVo = new OrderVo("11", "12.345", "2018-09-24 12:30:05", goodVo);

        return OrderMapper.MAPPER.fromOrderVo(orderVo);
    }
}
