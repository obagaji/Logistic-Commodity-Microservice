package com.jtc.LogisticCommodities.LogisticCommodity.Service;

import com.jtc.LogisticCommodities.LogisticCommodity.DTO.DeliveryDto;
import com.jtc.LogisticCommodities.LogisticCommodity.Entity.DeliveryPackage;
import com.jtc.LogisticCommodities.LogisticCommodity.ExceptionController.NoValueFoundException;
import com.jtc.LogisticCommodities.LogisticCommodity.Repository.PackageRepoitory;
import com.jtc.LogisticCommodities.LogisticCommodity.logisticMapper.PersonMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommodityService {
	@Autowired
	PackageRepoitory packageRepository;
	@Autowired
	DeliveryPackage newPackage;

// method  to return a default DeliveryPackage object.
	public void sendDeliveryInfo()
	{

	}
	public DeliveryPackage getPackageInfo(Long deliveryItemId)
	{
		return packageRepository
				.findById(deliveryItemId)
				.orElseGet(()-> new NoValueFoundException().get());
	}
	public DeliveryPackage savePackage(DeliveryDto deliveryPackage) {

	 return  packageRepository.save(PersonMapper.INSTANCE.deliveryPackageDto( deliveryPackage));
	}

// returning a list of all the secondary locations that packages has been taken to.
// util class is used to select all the locations
// return type is a list of string.
	public List<String> allPackageSecondaryLocation(String secondaryLocation)
	{
		return (packageRepository.findBySecondaryLocation(secondaryLocation).stream()
				.map( DeliveryPackage::getSecondaryLocation)
				.collect(Collectors.toList()));
	}

	public List<DeliveryPackage> allPackage()
	{
		return packageRepository.findAll();
	}
	@Transactional
	public void upDatePackageStatus( String status,Long packageId)
	{
		List<String> listOfString = List.of("START","FAIL","RETURN","DELIVERED","LOST");
		DeliveryPackage packageToUpDate= getPackageInfo( packageId);
		newPackage.setPackageName(packageToUpDate.getPackageName());
		newPackage.setFinalLocation(packageToUpDate.getFinalLocation());
		newPackage.setSecondaryLocation(packageToUpDate.getSecondaryLocation());

// getting the index value of the list for comparison
		// the index value will be used in the switch statement
		int indexNumber = listOfString.indexOf(listOfString.stream()
				.dropWhile(e -> e.equalsIgnoreCase(status))
				.limit(1)
				.toList().toString());

// switch statement use to select the available options
		switch (indexNumber)
		{	case 1 -> newPackage.setPackageStatus("FAIL");
			case 2 ->  newPackage.setPackageStatus("RETURNED");
			case 3 -> newPackage.setPackageStatus("DELIVERED");
			case 4 -> newPackage.setPackageStatus("LOST");
			default -> newPackage.setPackageStatus("START");
		}
		packageRepository.save(newPackage);
	}



}
