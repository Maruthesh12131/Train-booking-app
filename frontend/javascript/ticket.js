const trainNumber = new URLSearchParams(window.location.search).get("trainNumber");
fetch(`http://localhost:9999/train/${trainNumber}`,{
    method: "GET",
    headers:{
        "Content-type" : "application/JSON"
    }   
}).then(res => res.json())
.then(data => ticket(data))

function ticket(data){
    populateDropdown(data.seatsAvailable);
}
function populateDropdown(seatsAvailable) {
    const classDropdown = document.getElementById("classType");

    for (const cls in seatsAvailable) {
        const option = document.createElement("option");
        option.value = cls;
        option.textContent = `${cls} (${seatsAvailable[cls]} seats)`;
        classDropdown.appendChild(option);
    }
}
document.getElementById("bookticket").innerHTML=`<label> Enter the number of Seats:  </label>
            <input type="number" id = "seats"><br><br>
            <button onclick = enableBook()> Book Now</button>`;
function enableBook(){
    const trainNumber = new URLSearchParams(window.location.search).get("trainNumber");
    const noOfSeats = parseInt(document.getElementById("seats").value);
    const container = document.getElementById("details");
    container.innerHTML="";
    for(let i=0;i<noOfSeats;i++){
        container.innerHTML+= `<label> Passenger Name: </label>
        <input type="text" id = "name"><br><br>
        <label> Passenger Age: </label>
        <input type="number" id="age"><br><br>`;

    }
    container.innerHTML += `<button onclick="submitPassengers(${trainNumber},${noOfSeats})">Submit Passengers</button>`;
}
function submitPassengers(trainNumber,noOfSeats){
    const classType = document.getElementById("classType").value;
    const data = {
        trainNumber: trainNumber,
        noOfSeats: noOfSeats,
        classType:classType
    };
    fetch(`http://localhost:9999/trains/${trainNumber}`,{
        method : "POST",
        headers: {
            "Content-type" : "application/JSON"
        },
        body: JSON.stringify(data)
    }).then(res=> res.json()).then(ans=> showans(ans));

}
function showans(ans){
    document.getElementById("answer").innerText="Updated Successfully"
    document.getElementById("back").innerHTML=`<button onclick = enableBack()> Back </button>`
    
}
function enableBack(){
    window.location.href ="frontend.html";
}

