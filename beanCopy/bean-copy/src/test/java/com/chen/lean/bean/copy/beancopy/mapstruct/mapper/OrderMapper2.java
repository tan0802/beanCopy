package com.chen.lean.bean.copy.beancopy.mapstruct.mapper;

import com.chen.lean.bean.copy.beancopy.DateMapper;
import com.chen.lean.bean.copy.beancopy.OrderDetail;
import com.chen.lean.bean.copy.beancopy.OrderDetailVo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)
public interface OrderMapper2 {

    OrderMapper2 MAPPER = Mappers.getMapper( OrderMapper2.class );


    OrderDetailVo toOrderDetailVo(OrderDetail orderDetail);

    @InheritInverseConfiguration
    OrderDetail fromOrderDetailVo(OrderDetailVo orderDetailVo);




}
