package com.jtc.LogisticCommodities.LogisticCommodity.ExceptionController;

import com.jtc.LogisticCommodities.LogisticCommodity.Entity.DeliveryPackage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Supplier;


@AllArgsConstructor
public class NoValueFoundException extends RuntimeException implements Supplier<DeliveryPackage>
{

    @Override
    public DeliveryPackage get() {
        return returnDefaultPackage( );
    }
    private DeliveryPackage returnDefaultPackage( )
    {
        DeliveryPackage defaultPackage = new DeliveryPackage();
        String finalLocation = "Not Registered";
        defaultPackage.setPackageId(00000);
        defaultPackage.setPackageName("Item Not Found");
    //    defaultPackage.setPackageWeight(000L);
        defaultPackage.setPrimaryLocation("Not Registered");
        defaultPackage.setSecondaryLocation(finalLocation);
        defaultPackage.setFinalLocation("Not Registered");
        return defaultPackage;
    }
}
