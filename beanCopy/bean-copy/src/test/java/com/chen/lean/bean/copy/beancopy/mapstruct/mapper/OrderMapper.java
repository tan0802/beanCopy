package com.chen.lean.bean.copy.beancopy.mapstruct.mapper;

import com.chen.lean.bean.copy.beancopy.OrderDetail;
import com.chen.lean.bean.copy.beancopy.OrderDetailVo;
import com.chen.lean.bean.copy.beancopy.util.DateUtils;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper MAPPER = Mappers.getMapper( OrderMapper.class );


//    @Mapping(target = "createTime", expression = "java(com.chen.lean.bean.copy.beancopy.util.DateUtils.dateToString(orderDetail.getCreateTime(),\"yyyy-MM-dd HH:mm:ss\"))")
//    OrderDetailVo toOrderDetailVo(OrderDetail orderDetail);

    @InheritInverseConfiguration
//    @Mapping(target = "createTime", expression = "java(com.chen.lean.bean.copy.beancopy.util.DateUtils.stringToDate(orderDetailVo.getCreateTime(),\"yyyy-MM-dd HH:mm:ss\"))")
    OrderDetail fromOrderDetailVo(OrderDetailVo orderDetailVo);

    @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    OrderDetailVo toOrderDetailVo2(OrderDetail orderDetail);


}
