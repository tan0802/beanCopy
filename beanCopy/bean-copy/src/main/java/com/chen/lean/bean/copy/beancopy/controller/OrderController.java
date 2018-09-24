package com.chen.lean.bean.copy.beancopy.controller;

import com.chen.lean.bean.copy.beancopy.model.Order;
import com.chen.lean.bean.copy.beancopy.service.OrderService;
import com.chen.lean.bean.copy.beancopy.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


    private  final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/vo")
    public OrderVo toOrderVO(){
       return orderService.toOrderVo();
    }

    @GetMapping("/order/do")
    public Order fromOrder(){
        return orderService.fromOrderVo();
    }
}
