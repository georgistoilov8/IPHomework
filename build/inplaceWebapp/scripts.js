$(document).ready(function() {
	$("#showCars").click(function (){ 
		$.get({
			url: "http://localhost:8080/rst2/api/cars/getcars",
			dataType: "json",
			success: function(data){
				console.log(data);
				$.each(data, function(index){
					var tr = $('<tr>');
					tr.append(
							"<td> " + 
								"<th>" + data[index].carBrand + "</th>" +
								"<th>" + data[index].carModel + "</th>" +
								"<th>" + data[index].carYearOfManufacture + "</th>" +
								"<th>" + data[index].carHorsePower + "</th>" +
								"<th>" + data[index].carTransmission + "</th>" +
								"<th>" + data[index].carDoors + "</th>" +
								"<th>" + data[index].carFuel + "</th>" +
								"<th>" + data[index].carRegion + "</th>" +
								"<th>" + data[index].carCondition + "</th>" +
								"<th>" + data[index].carPrice + "</th>" + 
							"</td>");
					$("#carList").append(tr);
				});
			}

		});
		document.getElementById("showCars").disabled = true;
	});
});
$(document).ready(function() {
	$("#SubmitButton").click(function () {
		//var formdata = $("#addCar").serializeObject;
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
		alert(brand+model+year+power+transmission+doors+fuel+region+condition+price);
		//alert(transmission);
		var jsonObj = '{\n' + ' "brand" : "' + brand + '",\n "model" : "' +model+'",\n "year" : "'+year+'",\n "power" : "'+power+
		'",\n "transmission" : "'+transmission+'",\n "doors" : "'+ doors+'",\n "fuel" : "'+fuel+'",\n "region" : "'+region+
		'",\n "condition" : "'+condition+'",\n "price" : "'+price+'"\n}';
		//alert(jsonObj);
		var j = JSON.stringify($("#addCar").serializeArray());
		//var jsonData = JSON.parse(jsonObj);
		var sendInfo = {
		           brand: brand,
		           model: model,
		           year: year
		       };
		alert(j);
		$.ajax({
			type:"POST",
			url:"http://localhost:8080/rst2/api/cars/createcar",
			data:jsonObj,
			contentType: "application/json",
			success: function(data) {
				alert("Success");
			},
			error: function(xhr, status, error) {
	            console.log(xhr);
	            if (xhr == 'undefined' || xhr == undefined) {
	                alert('undefined');
	            } else {
	                alert('object is there');
	            }
	            alert(status);
	            alert(error);
	        },
		})
	})
})