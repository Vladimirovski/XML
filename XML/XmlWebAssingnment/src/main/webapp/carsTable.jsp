<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<html>
<head>
<head>
<link rel="stylesheet" type="text/css" href="css/carsTable.css">
</head>
</head>
<body>
<div class="container">
	<table>

		<thead>

			<tr>
				<th>ID</th>
				<th>Manufacturer</th>
				<th>Model</th>
				<th>Production-year</th>
				<th>Horsepower</th>
				<th>Consumption</th>
				<th>Consumption-Type</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="car" items="${list}">
                <tr>
                    <td>${car.id}</td>
                    <td>${car.manufacturer}</td>
                    <td>${car.model}</td>
                    <td>${car.productionYear}</td>
                    <td>${car.horsepower}</td>
                    <td>${car.consumption.value}</td>
                    <td>${car.consumption.type}</td>
                    <td>${car.price}</td>
                </tr>
        	 </c:forEach>


		</tbody>

	</table>



</div>

</body>

</html>