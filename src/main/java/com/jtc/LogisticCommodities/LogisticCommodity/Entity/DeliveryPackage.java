package com.jtc.LogisticCommodities.LogisticCommodity.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "delivery_package")
public class DeliveryPackage {

	@Id
	@GeneratedValue
	private long packageId;
	@NonNull
	@NotBlank(message = "Package Name Must Not Be Blank")
	@Length(min = 3,max = 25,
			message = " Name Character Must be between 3 to 25 Characters")
	private String packageName;
	@NonNull
	@NotBlank(message = "Primary (Start Point) Location Name Must Not Be Blank")
	@Length(min = 3,max = 60,
			message = " Name Character Must be between 3 to 25 Characters")
	private String primaryLocation;
	private String secondaryLocation;
	private String finalLocation;
	/*@Enumerated
	private SizeCategory packageWeight;*/
	@NonNull
	@NotBlank(message = "Package delivery Status Must Not be Blank")
	private String packageStatus;
	@NotBlank(message = "Package delivery Person Status Must Not be Blank")
	private String deliveryPersonName;
	@Positive(message = " Number of package Must be Positive Value")
	private int numberOfPackage;
	private double costOfPackage;


	public long getPackageId() {
		return packageId;
	}

	public void setPackageId(long packageId) {
		this.packageId = packageId;
	}

	@NonNull
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(@NonNull String packageName) {
		this.packageName = packageName;
	}

	@NonNull
	public String getPrimaryLocation() {
		return primaryLocation;
	}

	public void setPrimaryLocation(@NonNull String primaryLocation) {
		this.primaryLocation = primaryLocation;
	}

	public String getSecondaryLocation() {
		return secondaryLocation;
	}

	public void setSecondaryLocation(String secondaryLocation) {
		this.secondaryLocation = secondaryLocation;
	}

	public String getFinalLocation() {
		return finalLocation;
	}

	public void setFinalLocation(String finalLocation) {
		this.finalLocation = finalLocation;
	}

/*	public SizeCategory getPackageWeight() {
		return packageWeight;
	}*/
// this method is required when an update is to be made. since what is stored
// in the table is an Enum of type SizeCategory
/*
	public void setPackageSize(SizeCategory size)
	{
		this.packageWeight = size;
	}
*/
// this method will be called when an initial user input will be required for
// processing into the table.
	/*public void setPackageWeight(double packageWeight) {
		double weight = packageWeight;
		if (10 > weight) {
			this.packageWeight = SizeCategory.SMALL;
		}
		else if (20 > weight ) {
			this.packageWeight = SizeCategory.MEDIUM;
		}
		else if (30 > weight ) {
				this.packageWeight = SizeCategory.LARGE;
		} else if (40 > weight) {
			this.packageWeight = SizeCategory.EXTRALARGE;

		}
		else {
			this.packageWeight=SizeCategory.FULLSIZE;
		}

	}*/

	@NonNull
	public String getPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(@NonNull String packageStatus) {
		this.packageStatus = packageStatus;
	}

	public String getDeliveryPersonName() {
		return deliveryPersonName;
	}

	public void setDeliveryPersonName(String deliveryPersonName) {
		this.deliveryPersonName = deliveryPersonName;
	}

	public int getNumberOfPackage() {
		return numberOfPackage;
	}

	public void setNumberOfPackage(int numberOfPackage) {
		this.numberOfPackage = numberOfPackage;
	}

	public double getCostOfPackage() {
		return costOfPackage;
	}

	public void setCostOfPackage(double costOfPackage) {
		this.costOfPackage = costOfPackage;
	}

	public void setCostOfPackage(SizeCategory costForSize)
	{
		this.costOfPackage = totalCostOfPackage(costForSize);
	}

	public double totalCostOfPackage(SizeCategory sizeCategory)
	{
		double totalCost =100;
		SizeCategory size = sizeCategory;
		switch (size)
		{
			case SMALL -> totalCost = totalCost + (totalCost * 0.2);
			case MEDIUM -> totalCost = totalCost + (totalCost * 0.3);
			case LARGE -> totalCost = totalCost + (totalCost * 0.4);
			case EXTRALARGE -> totalCost = totalCost + (totalCost * 0.5);
			case FULLSIZE -> totalCost = totalCost + (totalCost * 0.6);
			default -> totalCost = totalCost * 1;

		}
		return totalCost;

	}
}
