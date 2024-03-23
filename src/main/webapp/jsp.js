const wIcon=document.getElementById("wc-icon");
const srcOp=document.getElementById("w-c").value;

switch(srcOp){
  case 'Haze': wIcon.src="images/Haze.png"; break;
  case 'Clear': wIcon.src="images/Clear.png"; break;
  case 'Clouds': wIcon.src="images/Clouds.png"; break;
  case 'Mist': wIcon.src="images/Mist.png"; break;
  case 'Rain': wIcon.src="images/Rain.png"; break;
  case 'Snow': wIcon.src="images/Snow.png"; break;
}


