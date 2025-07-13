function enableSearch(){
    const from = document.getElementById("from").value;
    console.log(from);
    const to = document.getElementById("to").value;
    console.log(to);
    const date = document.getElementById("date").value;
    console.log(date);
    const data = { source : from ,
        destination : to,
        dateOfJourney :  date
    };
    
   fetch("http://localhost:9999/trains",{method:"POST",
        headers:{
            "Content-type" : "application/JSON"
        },
        body: JSON.stringify(data)
    }).then(response => response.json())
    .then(result =>{ displaytrain(result)});


        
      
    //console.log(typeof(data));
}
function displaytrain(trains){
    console.log(trains.length);
    if(trains.length === 0){
        document.getElementById("success").innerHTML = "<p>No Trains found.</p>";
        return;
    }
    else{
            let tableHTML = `
                <table>
                    <thead>
                        <tr>
                            <th>Train_No.</th>
                            <th>Train_Name</th>
                            <th>Source</th>
                            <th>Destination</th>
                            <th>Seats_Available</th>
                            <th>Price</th>
                            <th>Date_of_Journey</th>
                            <th>Time_of_Journey</th>                          
                        </tr>
                    </thead>
                    <tbody>
            `;

            trains.forEach(train => {
                tableHTML += 
                `   <tr>
                        <td><a href="details.html?trainNumber=${train.trainNumber}">${train.trainNumber}</a></td>
                        <td><a href="details.html?trainNumber=${train.trainNumber}">${train.trainName}</a></td>
                        <td>${train.source}</td>
                        <td>${train.destination}</td>
                        <td>${Object.entries(train.seatsAvailable).map(([cls, seats]) => `${cls}: ${seats}`).join("<br>")}</td>
                        <td>${Object.entries(train.prices).map(([cls, prices]) => `${cls}: ${prices}`).join("<br>")}</td>
                
                        <td>${train.dateOfJourney}</td>
                        <td>${train.timeOfJourney}</td>
                    </tr>
                `;
            });

            tableHTML += `
                    </tbody>
                </table>
            `;

            document.getElementById("success").innerHTML = tableHTML;
        }
}

