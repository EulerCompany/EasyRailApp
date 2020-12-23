var toDate = document.getElementById('to-date');
var fromDate = document.getElementById('from-date');
var butt = document.getElementsByClassName('btn search-butt');
var calendar = document.getElementById('calendar');

butt[0].addEventListener("click", async() =>
{
  if ((document.getElementById('to-date').value == "") || (document.getElementById('to-date').value == null)) {
  toDate.style.borderColor = "red";
  }
  else {
    toDate.style.borderColor = "rgba(0,0,0,0.2)";
  }

  if ((document.getElementById('from-date').value == "") || (document.getElementById('from-date').value == null)){
    fromDate.style.borderColor = "red";
  }
  else {
    fromDate.style.borderColor = "rgba(0,0,0,0.2)";
  }
});
//логика под подгрузку с бэка
