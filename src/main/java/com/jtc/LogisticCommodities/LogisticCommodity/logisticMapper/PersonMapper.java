package com.jtc.LogisticCommodities.LogisticCommodity.logisticMapper;

import com.jtc.LogisticCommodities.LogisticCommodity.DTO.DeliveryDto;
import com.jtc.LogisticCommodities.LogisticCommodity.Entity.DeliveryPackage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    DeliveryPackage deliveryPackageDto(DeliveryDto dtoDeliveryPackage);

    DeliveryDto dtoDeliveryPackage(DeliveryPackage deliveryPackageDto);

}
