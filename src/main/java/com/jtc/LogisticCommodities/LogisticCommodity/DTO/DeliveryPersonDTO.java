package com.jtc.LogisticCommodities.LogisticCommodity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliveryPersonDTO {
	
	private String delivereName;
	private Long packageId;
	private String itemStopLocation;
	

}
