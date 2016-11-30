package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Car {
	
	@ApiModelProperty(required = true, value = "This will show the car brand.", example = "Brabus")
	private String carBrand;
	@ApiModelProperty(required = true, value = "This will show the model of a car brand.", example = "GLE 850")
	private String carModel;
	@ApiModelProperty(required = true, value = "This will show the year of manufactue of the car.", example = "2016")
	private int carYearOfManufacture;
	@ApiModelProperty(required = true, value = "This will show the horse power of the car", example = "850")
	private int carHorsePower;
	@ApiModelProperty(required = true, value = "This will show the car transmission.", example = "Automatic")
	private String carTransmission;
	@ApiModelProperty(required = true, value = "This will show the number of doors of the car", example = "4")
	private int carDoors;
	@ApiModelProperty(required = true, value = "This will show on what type of fuel the car is running on.", example = "diesel")
	private String carFuel;
	@ApiModelProperty(required = true, value = "This will show the region of the car, i.e. where the car is selling from.", example = "Varna")
	private String carRegion;
	@ApiModelProperty(required = true, value = "This will show if the car is new or seconhand.", example = "new")
	private String carCondition;
	@ApiModelProperty(required = true, value = "This will show the car price in dollars.", example = "400000")
	private int carPrice;
	
	public Car (String brand, String model, int year, int power, String transmission, 
			int doors, String fuel, String region, String condition, int price) {
		this.carBrand = brand;
		this.carModel = model;
		this.carYearOfManufacture = year;
		this.carHorsePower = power;
		this.carTransmission = transmission;
		this.carDoors = doors;
		this.carFuel = fuel;
		this.carRegion = region;
		this.carCondition = condition;
		this.carPrice = price;
	}
	
	public Car() {
		super();
	}
	
	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	
	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
	public int getCarYearOfManufacture(){
		return carYearOfManufacture;
	}
	
	public void setCarYearOfManufacture(int carYearOfManufacture){
		this.carYearOfManufacture = carYearOfManufacture;
	}
	
	public int getCarHorsePower(){
		return carHorsePower;
	}
	
	public void setCarHorsePower(int carHorsePower){
		this.carHorsePower = carHorsePower;
	}
	
	public String getCarTransmission() {
		return carTransmission;
	}

	public void setCarTransmission(String carTransmission) {
		this.carTransmission = carTransmission;
	}
	
	public int getCarDoors(){
		return carDoors;
	}
	
	public void setCarDoors(int carDoors){
		this.carDoors = carDoors;
	}
	
	public String getCarFuel(){
		return carFuel;
	}
	
	public void setCarFuel(String carFuel){
		this.carFuel = carFuel;
	}
	
	public String getCarRegion(){
		return carRegion;
	}
	
	public void setCarRegion(String carRegion){
		this.carRegion = carRegion;
	}
	
	public String getCarCondition(){
		return carCondition;
	}
	
	public void setCarCondition(String carCondition){
		this.carCondition = carCondition;
	}
	
	public int getCarPrice(){
		return carPrice;
	}
	
	public void setCarPrice(int carPrice){
		this.carPrice = carPrice;
	}

}
