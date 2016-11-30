package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
	private static CarService instance;

	public static CarService getInstance() {
		if (instance == null) {
			instance = new CarService();
		}
		return instance;
	}

	private List<Car> carList = new ArrayList<>();

	public CarService() {
		carList.add(new Car("Ferrari", "F12", 2012, 350, "Automatic", 4, "Petrol", "Sofia", "New", 100000));
		carList.add(new Car("Opel", "Astra", 2001, 80, "Manual", 4, "Petrol", "Sofia", "Secondhand", 2500));
		carList.add(new Car("Opel", "Astra", 2002, 105, "Manual", 4, "Petrol", "Sofia", "Secondhand", 2600));
		carList.add(new Car("Opel", "Astra", 2003, 105, "Manual", 4, "Petrol", "Sofia", "Secondhand", 2600));
		carList.add(new Car("Opel", "Astra", 2002, 105, "Manual", 2, "Petrol", "Sofia", "Secondhand", 2600));
		carList.add(new Car("Opel", "Astra", 2016, 105, "Automatic", 2, "Petrol", "Plovdiv", "New", 2600));
		carList.add(new Car("Opel", "Astra", 2010, 150, "Automatic", 4, "Petrol", "Varna", "Secondhand", 10000));
		carList.add(new Car("Opel", "Corsa", 2012, 170, "Manual", 4, "Petrol", "Sofia", "Secondhand", 12000));
		carList.add(new Car("Skoda", "Octavia", 2008, 105, "Manual", 4, "Diesel", "Sofia", "Secondhand", 5000));
		carList.add(new Car("Skoda", "Octavia", 2008, 125, "Manual", 4, "Diesel", "Sofia", "Secondhand", 5100));
		carList.add(new Car("Skoda", "Octavia", 2008, 135, "Manual", 4, "Diesel", "Sofia", "Secondhand", 5200));
		carList.add(new Car("Skoda", "Superb", 2015, 150, "Automatic", 4, "Diesel", "London", "New", 5200));
		carList.add(new Car("Audi", "A8", 2016, 350, "Automatic", 4, "Petrol", "Plovdiv", "New", 100000));
		carList.add(new Car("Audi", "RS7", 2015, 300, "Automatic", 4, "Petrol", "Plovdiv", "New", 90000));
		carList.add(new Car("Audi", "Q7", 2016, 350, "Automatic", 4, "Diesel", "London", "New", 100000));
		carList.add(new Car("BMW", "740", 2008, 175, "Automatic", 4, "Petrol", "Plovdiv", "Secondhand", 10000));
		carList.add(new Car("BMW", "328XI", 2009, 250, "Manual", 2, "Petrol", "Plovdiv", "Secondhand", 16000));
		carList.add(new Car("BMW", "320", 2009, 250, "Manual", 2, "Petrol", "Sofia", "Secondhand", 15000));
		carList.add(new Car("Mercedes-Benz", "S63AMG", 2016, 350, "Automatic", 4, "Petrol", "Sofia", "New", 130000));
		carList.add(new Car("Mercedes-Benz", "S63AMG", 2016, 350, "Manual", 4, "Petrol", "Sofia", "New", 100000));
		carList.add(new Car("Mercedes-Benz", "S63AMG", 2016, 350, "Automatic", 4, "Petrol", "Sofia", "Secondhand", 90000));
	} 

	public List<Car> getCars() {
		return Collections.unmodifiableList(carList);
	}
	
	public PagedResponse getCarsInPagesFiltered(int page, int perPage, String byBrand, String byModel,
			int byYear, int byHP, String byTransmission, int byDoors, String byFuel, String byRegion,
			String byCondition, int byPrice) {
		
		PagedResponse response;
		List<Car> pageOfCars = carList;
		System.out.println("Page="+page);
		System.out.println("perPage="+perPage);
		long previousEntries = page * perPage;
		int totalPages;
		
		if(byBrand.equals("")){
			System.out.println("without brand");
			totalPages = carList.size();
			pageOfCars = carList.stream().collect(Collectors.toList());
		}else{
			System.out.println("with brand");
			
			pageOfCars = carList.stream().filter((u) -> u.getCarBrand().equals(byBrand) || byBrand == null)
					.collect(Collectors.toList());
			totalPages = pageOfCars.size();
		}
		
		if(byModel.equals("")){
			System.out.println("without model");
		}else{
			System.out.println("with model");
			pageOfCars = pageOfCars.stream().filter((u) -> u.getCarModel().equals(byModel) || byModel==null)
					.collect(Collectors.toList());
		}
		
		if(byYear == 0){
			System.out.println("without filtering by year of manufacture");
		}else{
			System.out.println("with filtering by year of manufacture");
			pageOfCars = pageOfCars.stream().filter((u) -> u.getCarYearOfManufacture() == byYear || byYear==0)
					.collect(Collectors.toList());		
		}
		
		if(byHP == 0){
			System.out.println("without filtering by horse power");
		}else{
			System.out.println("with filtering by horse power");
			pageOfCars = pageOfCars.stream().filter((u) -> u.getCarHorsePower() == byHP || byHP==0)
					.collect(Collectors.toList());		
		}
		
		if(byTransmission.equals("")){
			System.out.println("without filtering by transmission");
		}else{
			System.out.println("with filtering by transmission");
			pageOfCars = pageOfCars.stream().filter((u) -> u.getCarTransmission().equals(byTransmission) || byTransmission==null)
					.collect(Collectors.toList());
		}
		
		if(byDoors == 0){
			System.out.println("without filtering by number of doors");
		}else{
			System.out.println("with filtering by number of doors");
			pageOfCars = pageOfCars.stream().filter((u) -> u.getCarDoors() == byDoors || byDoors==0)
					.collect(Collectors.toList());
		}
		
		if(byFuel.equals("")){
			System.out.println("without filtering by fuel");
		}else{
			System.out.println("with filtering by fuel");
			pageOfCars = pageOfCars.stream().filter((u) -> u.getCarFuel().equals(byFuel) || byFuel==null)
					.collect(Collectors.toList());		
		}
		
		if(byRegion.equals("")){
			System.out.println("without filtering by region");
		}else{
			System.out.println("with filtering by region");
			pageOfCars = pageOfCars.stream().filter((u) -> u.getCarRegion().equals(byRegion) || byRegion==null)
					.collect(Collectors.toList());		
		}
		
		if(byCondition.equals("")){
			System.out.println("without filtering by car condition");
		}else{
			System.out.println("with filtering by car condition");
			pageOfCars = pageOfCars.stream().filter((u) -> u.getCarCondition().equals(byCondition) || byCondition==null)
					.collect(Collectors.toList());		
		}
		
		if(byPrice == 0){
			System.out.println("without filtering by car price");
		}else{
			System.out.println("with filtering by car price");
			pageOfCars = pageOfCars.stream().filter((u) -> u.getCarPrice() == byPrice || byPrice==0)
					.collect(Collectors.toList());		
		}
		
		if(perPage != 0){
			totalPages = (int) Math.ceil(( (double) pageOfCars.size() ) / perPage);
			pageOfCars = pageOfCars.stream().skip(previousEntries).limit(perPage).collect(Collectors.toList());
		}
		response = new PagedResponse(pageOfCars, page, totalPages);
		return response;
	}
	
	public void addCar(Car car) {
		carList.add(car);
	}
}
