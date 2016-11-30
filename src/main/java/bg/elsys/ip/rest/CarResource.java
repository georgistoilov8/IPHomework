package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/cars")
@Api("cars")
public class CarResource {

	@GET
	@Path("/")
	@ApiOperation(value = "get list of cars", response = Car.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public PagedResponse getCars(@QueryParam("page") int page, @QueryParam("perPage") int perPage, 
			@QueryParam("filterByBrand") String byBrand,
			@QueryParam("filterByModel") String byModel,
			@QueryParam("filterByYearOfManufacture") int byYear,
			@QueryParam("filterByHorsePower") int byHP,
			@QueryParam("filterByTransmission") String byTransmission,
			@QueryParam("filterByDoors") int byDoors,
			@QueryParam("filterByFuel") String byFuel,
			@QueryParam("filterByRegion") String byRegion,
			@QueryParam("filterByCondition") String byCondition,
			@QueryParam("filterByPrice") int byPrice){
		CarService carService = CarService.getInstance();
		PagedResponse carsInPages = carService.getCarsInPagesFiltered(page, perPage, byBrand, byModel, byYear, byHP, 
				byTransmission, byDoors, byFuel, byRegion, byCondition, byPrice);
		return carsInPages;
	}

	@POST
	@Path("/")
	@ApiOperation(value = "create new car", response = Car.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCar(Car car) {
		CarService.getInstance().addCar(car);
		return Response.ok().status(Status.CREATED).build();
	}
}
