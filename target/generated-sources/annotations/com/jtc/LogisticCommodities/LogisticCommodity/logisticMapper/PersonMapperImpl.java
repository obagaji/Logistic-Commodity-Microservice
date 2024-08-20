package com.jtc.LogisticCommodities.LogisticCommodity.logisticMapper;

import com.jtc.LogisticCommodities.LogisticCommodity.DTO.DeliveryDto;
import com.jtc.LogisticCommodities.LogisticCommodity.Entity.DeliveryPackage;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T00:38:59+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public DeliveryPackage deliveryPackageDto(DeliveryDto dtoDeliveryPackage) {
        if ( dtoDeliveryPackage == null ) {
            return null;
        }

        DeliveryPackage deliveryPackage = new DeliveryPackage();

        deliveryPackage.setPackageId( dtoDeliveryPackage.getPackageId() );
        deliveryPackage.setPackageName( dtoDeliveryPackage.getPackageName() );
        deliveryPackage.setPrimaryLocation( dtoDeliveryPackage.getPrimaryLocation() );
        deliveryPackage.setSecondaryLocation( dtoDeliveryPackage.getSecondaryLocation() );
        deliveryPackage.setFinalLocation( dtoDeliveryPackage.getFinalLocation() );
        deliveryPackage.setPackageStatus( dtoDeliveryPackage.getPackageStatus() );
        deliveryPackage.setDeliveryPersonName( dtoDeliveryPackage.getDeliveryPersonName() );
        deliveryPackage.setNumberOfPackage( dtoDeliveryPackage.getNumberOfPackage() );
        deliveryPackage.setCostOfPackage( dtoDeliveryPackage.getCostOfPackage() );

        return deliveryPackage;
    }

    @Override
    public DeliveryDto dtoDeliveryPackage(DeliveryPackage deliveryPackageDto) {
        if ( deliveryPackageDto == null ) {
            return null;
        }

        DeliveryDto deliveryDto = new DeliveryDto();

        deliveryDto.setPackageId( deliveryPackageDto.getPackageId() );
        deliveryDto.setPackageName( deliveryPackageDto.getPackageName() );
        deliveryDto.setPrimaryLocation( deliveryPackageDto.getPrimaryLocation() );
        deliveryDto.setSecondaryLocation( deliveryPackageDto.getSecondaryLocation() );
        deliveryDto.setFinalLocation( deliveryPackageDto.getFinalLocation() );
        deliveryDto.setPackageStatus( deliveryPackageDto.getPackageStatus() );
        deliveryDto.setDeliveryPersonName( deliveryPackageDto.getDeliveryPersonName() );
        deliveryDto.setNumberOfPackage( deliveryPackageDto.getNumberOfPackage() );
        deliveryDto.setCostOfPackage( deliveryPackageDto.getCostOfPackage() );

        return deliveryDto;
    }
}
