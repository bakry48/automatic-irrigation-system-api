# automatic-irrigation-system-api
 Description : This is an irrigation scheduling system that automate the scheduling of land irrigation base on period date and amount of water configuration 
## Dependencies
```
The system make use of MySql database as such an isntance of mysql database is required to run the application so ensure the application.properties configuration is updated with database configuration before running the application

## To run the app 

```
mvn spring-boot:run
```
...and navigate your browser to  http://localhost:8080/

1 - Add new plot of land Create POST request  http://localhost:8080/api/v1/land
{
    "code": "73732823y723899",
    "area": 2000,
    "landType": "Sandy",
    "agricType": "Rice farming"
}
2- To Edit a plot of land Create put request  http://localhost:8080/api/v1/land/{landId}
{
    "code": "73732823y723899",
    "area": 2000,
    "landType": "Sandy",
    "agricType": "Mango farming"

    
}
3- Configure a plot of land Create POST request  http://localhost:8080/api/v1/land/{landId}/configure
{
    "deviceName": "Sensor 2",
    "startDate":"2022-09-30T22:09:32.000+00:00",
    "endDate":"2022-10-19T22:09:32.000+00:00",
    "intervalInDays": 2,
    "amountOfWater": 2000
    
    }
4- List all plots and it's details navigate to http://localhost:8080/api/v1/land/
{
        "id": 1,
        "code": "2938833",
        "landType": "sandy",
        "agricType": "Rice farming",
        "area": 2000.0,
        "landConfigurations": [
            {
                "id": 1,
                "deviceName": "Sensor 1",
                "startDate": "2022-09-30T22:09:32.000+00:00",
                "endDate": "2022-10-19T22:09:32.000+00:00",
                "intervalInDays": 5,
                "amountOfWater": 2000,
                "irrigationTransactions": null,
                "createdOn": "2022-10-13T22:00:00.000+00:00",
                "modifiedOn": null
            }
## How it works
```
After setting up the land and land configuration a task scheduler is run every 10 seconds to check the 
land that is due for irrigation base on startDate and endDate column in the land configuration table if found, and check if Land have maximum irrigation in this day or less if less then call Sensor ,  if Sensor Status Not Available retries call it No. of times if Still Not Available then record it in irrigation transactions by irrigation status is ( 0 ) but if Sensor Status is Available then record it in irrigation transactions by irrigation status is 1 
And if have a maximum irrigation for that day then 
This land have the maximum irrigation in this day and not record any irrigation transactions
