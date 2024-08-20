package com.jtc.LogisticCommodities.LogisticCommodity.Controller;

import com.jtc.LogisticCommodities.LogisticCommodity.DTO.DeliveryDto;
import com.jtc.LogisticCommodities.LogisticCommodity.Entity.DeliveryPackage;
import com.jtc.LogisticCommodities.LogisticCommodity.Repository.PackageRepoitory;
import com.jtc.LogisticCommodities.LogisticCommodity.Service.CommodityService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/commodity")
@Slf4j

public class CommodityController {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(CommodityController.class);
	@Autowired
    CommodityService commodityService;
	@GetMapping("/{packageId}")
	public ResponseEntity<DeliveryPackage> getPackageInfo(@PathVariable("packageId") long packageId)
	{
		LOGGER.info("Inside getPackageInfo Method");
		DeliveryPackage deliveryPackage = commodityService.getPackageInfo(packageId);
		LOGGER.info("Inside the get mapping responseEntity getPackageInfo method");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{packageId}")
				.build(deliveryPackage);
		HttpHeaders header = new HttpHeaders();
		header.setLocation(location);
		return ResponseEntity.status(HttpStatus.CREATED).headers(header).body(deliveryPackage);
	}

	@PostMapping("/package")
	public ResponseEntity<DeliveryPackage> savePackageInformation(@RequestBody @Valid DeliveryDto packageToSave)
	{
		DeliveryPackage packageSaved = commodityService.savePackage(packageToSave);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/package").build(packageToSave);
		HttpHeaders header = new HttpHeaders();
		header.setLocation(location);
		return ResponseEntity.status(HttpStatus.CREATED).headers(header).body(packageSaved);
	}
	@GetMapping("/package/{Location}")
	public ResponseEntity<List<String>> getPackageBySecondaryLocation(@PathVariable("Location") String location)
	{
		List<String> secondaryLocation = commodityService.allPackageSecondaryLocation(location);
		URI locations = ServletUriComponentsBuilder.fromCurrentRequest().path("/package/{Location}").build(secondaryLocation);
		HttpHeaders header = new HttpHeaders();
		header.setLocation(locations);
		return ResponseEntity.status(HttpStatus.CREATED).headers(header).body(secondaryLocation);
	}
	@PostMapping("/{packageId}/{deliveryStatus}")
	public ResponseEntity<Void> upDatePackageDeliveryStatus(@PathVariable("packageId") Long packageId, @Valid @PathVariable("deliveryStatus") String  status)
	{
		String deliveryStatus = status.toUpperCase();
		commodityService.upDatePackageStatus(deliveryStatus,packageId);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{packageId}/{deliveryStatus}").build("");
		HttpHeaders header = new HttpHeaders();
		header.setLocation(location);
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(null);

	}
	@GetMapping("/package/view")
	public ResponseEntity<List<DeliveryPackage>> showAllPackages()
	{
		LOGGER.info("show all the packages in data base");
		List<DeliveryPackage> deliveryPackage = commodityService.allPackage();
		return ResponseEntity.ok(deliveryPackage);
	}
/*
	@GetMapping("/package/")
	public ResponseEntity<List<DeliveryPackage>> showAllPackages()
	{
		LOGGER.info("show all the packages in data base");
		List<DeliveryPackage> deliveryPackage = commodityService.allPackage();
		return ResponseEntity.ok(deliveryPackage);
	}*/



}
