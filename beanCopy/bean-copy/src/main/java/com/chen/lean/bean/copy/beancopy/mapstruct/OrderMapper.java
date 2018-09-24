package com.chen.lean.bean.copy.beancopy.mapstruct;

import com.chen.lean.bean.copy.beancopy.model.Order;
import com.chen.lean.bean.copy.beancopy.util.MapstructUtil;
import com.chen.lean.bean.copy.beancopy.vo.OrderVo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = MapstructUtil.class)
public interface OrderMapper {

    OrderMapper  MAPPER = Mappers.getMapper( OrderMapper.class );
    @Mappings({
            @Mapping(source = "id", target = "orderId"),
            @Mapping(source = "good.id", target = "goodVo.goodId"),
            @Mapping(source = "good.goodName", target = "goodVo.goodName"),
            @Mapping(source = "amount", target = "amount")
    })
   public OrderVo toOrderVo(Order order);


    @InheritInverseConfiguration
    public Order fromOrderVo(OrderVo orderVo);


}
