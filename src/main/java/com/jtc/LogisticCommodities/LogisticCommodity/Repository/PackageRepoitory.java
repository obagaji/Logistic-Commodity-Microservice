package com.jtc.LogisticCommodities.LogisticCommodity.Repository;

import com.jtc.LogisticCommodities.LogisticCommodity.Entity.DeliveryPackage;
import com.jtc.LogisticCommodities.LogisticCommodity.Entity.SizeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepoitory extends JpaRepository<DeliveryPackage,Long> {

	public String findByPackageName(String packageName);
	public List<DeliveryPackage>findBySecondaryLocation(String location);
	public String findByPackageStatus(String status );


}
