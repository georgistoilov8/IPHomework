package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
		//userList.add(new User(1, "George"));
		//userList.add(new User(2, "John"));
		//userList.add(new User(3, "Ivan"));
		//carList.add(new Car(1, "Ferrari"));

	} 

	public List<Car> getCars() {
		return Collections.unmodifiableList(carList);
	}

	public void addCar(Car car) {
		carList.add(car);
	}
}