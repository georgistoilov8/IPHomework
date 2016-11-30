var cars = [];
var uniqueCarBrands = [];
$(document).ready(function() {	
	$("#b").focus(function() {
		$.get({
			url: "http://localhost:8080/rst2/api/cars?page=0&perPage=0&filterByBrand=&filterByModel=&filterByYearOfManufacture=&filterByHorsePower=&filterByTransmission=&filterByDoors=&filterByFuel=&filterByRegion=&filterByCondition=&filterByPrice=",
			dataType: "json",
			success: function(data){
				var jsonData = JSON.stringify(data);
				$.each(data["data"], function(index){
					cars[index] = data["data"][index]["carBrand"];
				});
				$.each(cars, function(i, el){
				    if($.inArray(el, uniqueCarBrands) === -1) uniqueCarBrands.push(el);
				});
				console.log(uniqueCarBrands);
			},
			error: function(){
				alert("Error");
			}
		});
		
		$("#b").autocomplete({
	    	source: uniqueCarBrands
	    });
	});
});

$( document ).on("click", ".showCars", function() {
	$("#carList #cars").remove();
	$("#pagination #pages").remove();
	var page = 0;
	if(this.id != ""){
		page = parseInt(this.id);
	}
	var perPage = $("#perPage").val();
	if(perPage == 0 || perPage == ""){
		alert("Please input valid Cars per Page value");
		return;
	}
	var filterByBrand = $("#b").val();
	var filterByModel = $("#m").val();
	var filterByYear = 0;
	if($("#y").val() != ""){
		filterByYear = $("#y").val();
	}
	var filterByHorsePower = 0;
	if($("#hp").val() != ""){
		filterByHorsePower = $("#hp").val();
	}
	var filterByTransmission = $("#t option:selected").val();
	var filterByDoors = 0;
	if($("#d").val() != ""){
		filterByDoors = $("#d").val()
	}
	var filterByFuel = $("#f option:selected").val();
	var filterByRegion = $("#r").val();
	var filterByCondition = $("#c option:selected").val();
	var filterByPrice = 0;
	if($("#pr").val() != ""){
		filterByPrice = $("#pr").val()
	}
	$.get({
		url: "http://localhost:8080/rst2/api/cars?page="+page+"&perPage="+perPage+"&filterByBrand="+filterByBrand
		+"&filterByModel="+filterByModel+"&filterByYearOfManufacture="+filterByYear+"&filterByHorsePower="+filterByHorsePower
		+"&filterByTransmission="+filterByTransmission+"&filterByDoors="+filterByDoors+"&filterByFuel="+filterByFuel
		+"&filterByRegion="+filterByRegion+"&filterByCondition="+filterByCondition+"&filterByPrice="+filterByPrice,
		dataType: "json",
		success: function(data){
			var jsonData = JSON.stringify(data);
			$.each(data["data"], function(index){
				var tr = $('<tr id="cars">');
				tr.append(
						"<td> " + 
							"<th>" + data["data"][index]["carBrand"] + "</th>" +
							"<th>" + data["data"][index]["carModel"] + "</th>" +
							"<th>" + data["data"][index]["carYearOfManufacture"] + "</th>" +
							"<th>" + data["data"][index]["carHorsePower"] + "</th>" +
							"<th>" + data["data"][index]["carTransmission"] + "</th>" +
							"<th>" + data["data"][index]["carDoors"] + "</th>" +
							"<th>" + data["data"][index]["carFuel"] + "</th>" +
							"<th>" + data["data"][index]["carRegion"] + "</th>" +
							"<th>" + data["data"][index]["carCondition"] + "</th>" +
							"<th>" + data["data"][index]["carPrice"] + " $</th>" + 
						"</td>");
				$("#carList").append(tr);
			});
			var pagination = $('<div id="pages">');
			for(var i = 0; i < data["totalPages"]; i++){
				pagination.append('<button class="showCars" id="'+i+'">' + i + '</button>');
			}
			pagination.append('</div>');
			$("#pagination").append(pagination);
		},
		error: function(){
			alert("Error");
		} 

	});
});

$(document).ready(function() {
	$("#hideCars").click(function (){
		$("#carList #cars").remove();
		$("#pagination #pages").remove();
	});
});

$(document).ready(function() {
	$("#SubmitButton").click(function () {
		var brand = $("#carBrand").val();
		var model = $("#carModel").val();
		var year = $("#carYear").val();
		var power = $("#carPower").val();
		var transmission = $("#carTransmission option:selected").val();
		var doors = $("#carDoors").val();
		var fuel = $("#fuel option:selected").val();
		var region = $("#carRegion").val();
		var condition = $("#condition option:selected").val();
		var price = $("#carPrice").val();
		var jsonObj = '{\n' + 
		' "carBrand" : "' + brand + 
		'",\n "carModel" : "' + model + 
		'",\n "carYearOfManufacture" : "' + year + 
		'",\n "carHorsePower" : "' + power +
		'",\n "carTransmission" : "' + transmission +
		'",\n "carDoors" : "' + doors +
		'",\n "carFuel" : "' + fuel +
		'",\n "carRegion" : "' + region +
		'",\n "carCondition" : "' + condition +
		'",\n "carPrice" : "' + price + 
		'"\n}';
		$.post({
			url: "http://localhost:8080/rst2/api/cars/",
			data: jsonObj,
			contentType: "application/json",
			success: function(data) {
				alert("Success");
			}
		});
	});
});