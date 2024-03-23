<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Weather-Info</title>
	<link rel="stylesheet" href="jsp.css">
</head>
<body>
	<div class="mCont">
		<form action="myServlet" method="post" class="formCont">
			<input class="srBar" type="text" placeholder="Enter the city name" name="city">
			<button class="srBtn"><img src="images\search-26242.png" class="srLogo"></button>
		</form>

		<div class="tempDiv">
			<div class="pic">
				<img src="" id="wc-icon">
			</div>
			<h2>${temp}</h2>
			<input type="hidden" value="${wCond}" id="w-c">
		</div>

		<div class="cityDet">
			<p class="cityNm"><strong>${city}</strong></p>

		</div>

		<div class="date-time">
			<p>${date}</p>
		</div>

		<div class="addInfo">
			<div class="humidity">
				<div class="hmLgDiv">
					<img src="images/humidity.png" class="humidityLg">
				</div>
				<div class="hmOuter">
					<div class="hmTxts">Humidity</div>
					<div class="hmVal">${humidity}%</div>
				</div>
			</div>
			<div class="windSpeed">
				<div class="hmLgDiv">
					<img src="images/wind.png" class="humidityLg">
				</div>
				<div class="hmOuter">
					<div class="hmTxts">Wind Speed</div>
					<div class="hmVal">${wind} km/h</div>
				</div>
			</div>
		</div>
	</div>
	
	<script src="jsp.js"></script>
</body>
</html>