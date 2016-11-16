package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Car {
	
	@ApiModelProperty(required = true)
	private int id;
	//@ApiModelProperty(value = "This will show the name of the c", example = "Pesho")
	//private String name;
	@ApiModelProperty(value = "This will show the car brand.", example = "Brabus")
	private String brand;
	@ApiModelProperty(value = "This will show the model of a car brand.", example = "GLE 850")
	private String model;
	@ApiModelProperty(value = "This will show the year of manufactue of the car.", example = "2016")
	private int yearOfManufacture;
	@ApiModelProperty(value = "This will show the horse power of the car", example = "850")
	private int horsePower;
	@ApiModelProperty(value = "This will show the car transmission.", example = "Automatic")
	private String transmission;
	@ApiModelProperty(value = "This will show the number of doors of the car", example = "4")
	private int doors;
	@ApiModelProperty(value = "This will show on what type of fuel the car is running on.", example = "diesel")
	private String fuel;
	@ApiModelProperty(value = "This will show the region of the car, i.e. where the car is selling from.", example = "Varna")
	private String carRegion;
	@ApiModelProperty(value = "This will show if the car is new or seconhand.", example = "new")
	private String condition;
	@ApiModelProperty(value = "This will show the car price in leva.", example = "400000")
	private int price;
	
	public Car (int id, String brand, String model, int year, int power, String transmission, 
			int doors, String fuel, String region, String condition, int price) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.yearOfManufacture = year;
		this.horsePower = power;
		this.transmission = transmission;
		this.doors = doors;
		this.fuel = fuel;
		this.carRegion = region;
		this.condition = condition;
		this.price = price;
	}
	
	public Car(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCarBrand() {
		return brand;
	}

	public void setCarBrand(String carBrand) {
		this.brand = carBrand;
	}
	
	public String getCarModel() {
		return model;
	}

	public void setCarModel(String carModel) {
		this.model = carModel;
	}
	
	public int getCarYearOfManufacture(){
		return yearOfManufacture;
	}
	
	public void setCarYearOfManufacture(int carYearOfManufacture){
		this.yearOfManufacture = carYearOfManufacture;
	}
	
	public int getCarHorsePower(){
		return horsePower;
	}
	
	public void setCarHorsePower(int carHorsePower){
		this.horsePower = carHorsePower;
	}
	
	public String getCarTransmission() {
		return transmission;
	}

	public void setCarTransmission(String carTransmission) {
		this.transmission = carTransmission;
	}
	
	public int getCarDoors(){
		return doors;
	}
	
	public void setCarDoors(int carDoors){
		this.doors = carDoors;
	}
	
	public String getCarFuel(){
		return fuel;
	}
	
	public void setCarFuel(String carFuel){
		this.fuel = carFuel;
	}
	
	public String getCarRegion(){
		return carRegion;
	}
	
	public void setCarRegion(String carRegion){
		this.carRegion = carRegion;
	}
	
	public String getCarCondition(){
		return condition;
	}
	
	public void setCarCondition(String carCondition){
		this.condition = carCondition;
	}
	
	public int getCarPrice(){
		return price;
	}
	
	public void setCarPrice(int carPrice){
		this.price = carPrice;
	}

}
