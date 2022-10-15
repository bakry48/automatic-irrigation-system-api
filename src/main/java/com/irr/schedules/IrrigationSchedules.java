package com.irr.schedules;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.irr.model.IrrigationTransactions;
import com.irr.model.LandConfiguration;
import com.irr.repositories.IrrigationTransactionsRepo;
import com.irr.repositories.LandConfigRepo;
import com.irr.sensorStatus.IrrigationSensorStatus;

@Component
public class IrrigationSchedules {

	@Autowired
	LandConfigRepo landconfigRepo;
	@Autowired
	IrrigationTransactionsRepo irrigationTransactionsRepo;
	//number of check censor is ready or not
	@Value("${number.of.sensor.retries}")
    private int numberOfSensorRetries;
	
	@Scheduled(fixedRate = 10000)
	public void irregationSchedules() {
		try {
			
			List<LandConfiguration> landConfiguration = landconfigRepo.landToBeIrrigated(new Date());

			for (LandConfiguration la : landConfiguration) {
				System.out.println("Device Name: " + la.getDeviceName());
				Long transactionsCount = irrigationTransactionsRepo.countIrr(la);
				
				if (la.getIntervalInDays() > transactionsCount) {
					Integer irrigationstatus=0;
					int retries=0;
					String alertMessage;
					while(IrrigationSensorStatus.sensorReply()==false && retries < numberOfSensorRetries) {
						 
						 retries++;
					}
					if(IrrigationSensorStatus.sensorReply()==false) {
						irrigationstatus=0;
						 alertMessage="Thats Irrigate is failed because Seneor Reply Not Avilable for Irrigate Number  :";
					}else {
						irrigationstatus=1;
						alertMessage="Thats Irrigate number : ";
					}
					IrrigationTransactions irrigationTransactions = new IrrigationTransactions();
					irrigationTransactions.setRunDate(new Date());
					irrigationTransactions.setLandConfiguration(la);
					irrigationTransactions.setStatus(irrigationstatus);
					irrigationTransactionsRepo.save(irrigationTransactions);
					System.out.println(alertMessage + transactionsCount + " for Land Code : "
							+ la.getLand().getCode() );
				} else {
					System.out.println("This land have the maximum irrigation in this day : " + la.getLand().getCode());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
