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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import io.swagger.util.Json;
//import jdk.nashorn.internal.parser.JSONParser;

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
		CarService.getInstance().addCar(car);
		return Response.ok().status(Status.CREATED).build();
	}
}
