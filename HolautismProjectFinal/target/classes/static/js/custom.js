function greeting(){
	
	date = new Date();
	time = date.getHours();
	
	if(time >= 0 && time <12){
		text = "Good morning"
		image = "img/day.png";
	}
	
	if(time >= 12 && time <18){
		text = "Good afternoon"
		image = "img/after.png";
	}
	
	if(time >= 18 && time <24){
		text = "Good evening"
		image = "img/night.png";
	}
	
	document.images["timeoftheday"].src = image;
	document.getElementById('txtgreeting').innerHTML = text;
	
}