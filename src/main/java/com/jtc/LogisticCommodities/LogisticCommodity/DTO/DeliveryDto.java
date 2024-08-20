package com.jtc.LogisticCommodities.LogisticCommodity.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class DeliveryDto {
    private long packageId;
    private String packageName;
    private String primaryLocation;
    private String secondaryLocation;
    private String finalLocation;
    private String packageStatus;
    private String deliveryPersonName;
    private int numberOfPackage;
    private double costOfPackage;
}
