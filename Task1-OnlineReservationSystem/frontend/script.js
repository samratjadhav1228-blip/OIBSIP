const API = "http://localhost:8080/api";

const loginForm = document.getElementById("loginForm");

if(loginForm){

loginForm.addEventListener("submit",function(e){

e.preventDefault();

const username=document.getElementById("username").value;
const password=document.getElementById("password").value;

fetch(API+"/login",{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify({username,password})
})
.then(res=>res.text())
.then(data=>{
document.getElementById("message").innerText=data;

if(data==="Login Successful"){
window.location="reservation.html";
}
});

});
}

const reservationForm=document.getElementById("reservationForm");

if(reservationForm){

reservationForm.addEventListener("submit",function(e){

e.preventDefault();

const reservation={
name:document.getElementById("name").value,
trainNumber:document.getElementById("trainNumber").value,
trainName:document.getElementById("trainName").value,
classType:document.getElementById("classType").value,
journeyDate:document.getElementById("journeyDate").value,
fromPlace:document.getElementById("fromPlace").value,
toPlace:document.getElementById("toPlace").value
};

fetch(API+"/reservation/book",{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify(reservation)
})
.then(res=>res.json())
.then(data=>{
document.getElementById("pnrMessage").innerText="Ticket Booked! PNR: "+data.pnr;
});

});
}

function cancelTicket(){

const pnr=document.getElementById("pnr").value;

fetch(API+"/cancel/"+pnr,{
method:"DELETE"
})
.then(res=>res.text())
.then(data=>{
document.getElementById("cancelMessage").innerText=data;
});

}
