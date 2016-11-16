package bg.elsys.ip.rest;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

//import org.codehaus.jackson.annotate.JsonAutoDetect;

//import com.fasterxml.jackson.databind.util.JSONPObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import io.swagger.util.Json;
//import jdk.nashorn.internal.parser.JSONParser;

//import com.google.gson.*;
//import com.google.gson.Gson;
@Path("/cars")
@Api("cars")
public class CarResource {

	@GET
	@Path("/getcars")
	@ApiOperation(value = "get list of cars", response = Car.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		CarService carService = CarService.getInstance();
		return Response.ok(carService.getCars()).build();
	}

	@POST
	@Path("/createcar")
	@ApiOperation(value = "create new car", response = Car.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCar(Car car) {
		System.out.println("NEEEE");
		//Car newCar = new Car(); 
		//JSONParser parser = new JSONParser(json, null, false);
		//JsonAutoDetect jsonObject = (JsonAutoDetect) parser.parse();
		/*Map jsonObject = new Gson().fromJson(json, Map.class);
		String brand = jsonObject.get("carBrand").toString();
		String model = jsonObject.get("carModel").toString();
		int year = Integer.parseInt(jsonObject.get("carYear").toString());
		int power = Integer.parseInt(jsonObject.get("carPower").toString());
		String transmission = jsonObject.get("carTransmission").toString();
		int doors = Integer.parseInt(jsonObject.get("carDoors").toString());
		String fuel = jsonObject.get("carFuel").toString();
		String region = jsonObject.get("carRegion").toString();
		String condition = jsonObject.get("carCondition").toString();
		int price = Integer.parseInt(jsonObject.get("carPrice").toString());
		newCar.setCarBrand(brand);
		newCar.setCarModel(model);
		newCar.setCarYearOfManufacture(year);
		newCar.setCarHorsePower(power);
		newCar.setCarTransmission(transmission);
		newCar.setCarDoors(doors);
		newCar.setCarFuel(fuel);
		newCar.setCarRegion(region);
		newCar.setCarCondition(condition);
		newCar.setCarPrice(price);*/
		CarService.getInstance().addCar(car);
		return Response.ok().status(Status.CREATED).build();
	}
}
