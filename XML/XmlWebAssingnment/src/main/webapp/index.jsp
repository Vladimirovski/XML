<%@page isELIgnored="false" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/index.css">
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body style="background-color:#6033e8;">
<header>
<form class="forms1" action="SearchServlet" method="post" >
<div class="pre-header">
<div class="container">
    	<div class="row">

    <div class="col-md-4">
    			<div class="service-item">

    			    <h4 style="color:white;">Manufacturer</h4>
    				<select id="cars" name="cars">
                      <option value=""></option>
    				  <option value="Audi">Audi</option>
                      <option value="Chevrolet">Chevrolet</option>
                      <option value="Aston Martin">Aston Martin</option>
                      <option value="Volkswagen">Volkswagen</option>
                      <option value="Kia">Kia</option>
                      <option value="Mazda">Mazda</option>
                      <option value="BMW">BMW</option>
                      <option value="Toyota">Toyota</option>
                      <option value="Dacia">Dacia</option>
                      <option value="Fiat">Fiat</option>
                      <option value="Ford">Ford</option>
                    </select>

    			</div>
    		</div>

    		<div class="col-md-4">
    			<div class="service-item">

    				<h4 style="color:white;">The year of production</h4>
    				<label for="years">From:</label>
                      <input type="text" id="year" name="from"><br><br>
                      <label for="lname">To:</label>
                      <input type="text" id="yearTo" name="to">

    			</div>
    		</div>

    		<div class="col-md-4">
    			<div class="service-item">

    				<h4 style="color:white;">Fuel</h4>
    				<select id="fuel" name="fuel">
    				  <option value=""></option>
                      <option value="electric">Electric</option>
                      <option value="fuel">Fuel</option>
                      <option value="hybrid">Hybrid</option>

                     </select>

    			</div>
    		</div>
            </div>
    	</div>
    </div>

    			  <button style="background-color:#67b046;" type="submit" class="allCars">All cars</button>
<button style="background-color:#67b046;" type="submit" class="search">Search</button>
    	</form>
    </header>






</body>

</html>