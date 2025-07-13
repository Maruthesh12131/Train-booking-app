const trainNumber = new URLSearchParams(window.location.search).get("trainNumber");
fetch(`http://localhost:9999/train/${trainNumber}`,{
    method : "GET",
    headers:{
        "Content-type" : "application/JSON"
    } 
}).then(response => response.json())
.then(data => traindetail(data))

function traindetail(traindet){
    document.getElementById("success").innerHTML = `<label> Train Number: ${traindet.trainNumber} </label><br><br>
    <label> Train Name: ${traindet.trainName}</label> <br><br>
    <label> Date of Journey: ${traindet.dateOfJourney}</label><br><br>
    <label> Time of Journey: ${traindet.timeOfJourney}</label><br><br>
    <label> Seats Available:<br> ${Object.entries(traindet.seatsAvailable).map(([cls, seats]) => `${cls}: ${seats}`).join("<br>")}</label><br><br>
    <label> Seat Available: <br> ${Object.entries(traindet.prices).map(([cls, prices]) => `${cls}: ${prices}`).join("<br>")}</label><br><br>
    <button onclick = "window.location.href='ticket.html?trainNumber=${traindet.trainNumber}'">Book ticket</button><br><br>
    <button onclick = "enableback()">Back </button>`;
}

function enableback(){
    window.location.href = "frontend.html";  
}
