$(document).ready(function() {
	$("#showCars").click(function (){
		$.get({
			url: "http://localhost:8080/rst2/api/cars/getcars",
			dataType: "json",
			success: function(data){
				console.log(data);
				$.each(data, function(index){
					var tr = $('<tr>');
					tr.append("<td> " + data[index].price + "</td>");
					$("#usersTable").append(tr);
				});
			}

		});
	});
});
$(document).ready(function() {
	$("#SubmitButton").click(function () {
		//var json;
		//$(function(e){
			//json = $("#addCar").serializeObject();
		//});
		var formdata = $("#addCar").serializeObject;
		alert(formdata);
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
		alert(jsonObj);
		var j = JSON.stringify($("#addCar").serializeArray());
		//var jsonData = JSON.parse(jsonObj);
		var sendInfo = {
		           brand: brand,
		           model: model,
		           year: year
		       };
		//alert(jsonData);
		//alert("2");
		alert(j);
		$.ajax({
			type:"POST",
			url:"http://localhost:8080/rst2/api/cars/createcar",
			data:jsonObj,
			contentType: "application/json",
			success: function(data) {
				alert("KORRRR");
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