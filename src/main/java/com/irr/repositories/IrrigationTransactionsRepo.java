package com.irr.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.irr.model.IrrigationTransactions;
import com.irr.model.LandConfiguration;

@Repository
public interface IrrigationTransactionsRepo extends JpaRepository<IrrigationTransactions , Long> {
	@Query("select COUNT (irrigationTransactions) from IrrigationTransactions irrigationTransactions where irrigationTransactions.landConfiguration=:landIrrigation AND irrigationTransactions.status=1  ")
	  public Long countIrr(@Param("landIrrigation") LandConfiguration landIrrigation);
}
