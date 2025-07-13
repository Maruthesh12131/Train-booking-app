package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Entity
public class trainList {
    @Id
    private int trainNumber;
    private String trainName;
    private String Source;
    private String Destination;
    @ElementCollection
    private List<String> intermediateStation;
    private LocalDate dateOfJourney;
    private LocalTime timeOfJourney;
    @ElementCollection
    @CollectionTable(
            name="train_class_seats", joinColumns = @JoinColumn(name = "train_number" )
    )
    @MapKeyColumn(name = "class_type")
    @Column(name= "SeatsAvailable")
    private Map<String,Integer> SeatsAvailable = new HashMap<>();

    @ElementCollection
    @CollectionTable(
            name="train_class_price", joinColumns = @JoinColumn(name = "train_number")
    )
    @MapKeyColumn(name = "class_type")
    @Column(name="Price")
    private Map<String,Double> Prices = new HashMap<>();


    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public List<String> getIntermediateStation() {
        return intermediateStation;
    }

    public void setIntermediateStation(List<String> intermediateStation) {
        this.intermediateStation = intermediateStation;
    }

    public LocalDate getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(LocalDate dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }



    public LocalTime getTimeOfJourney() {
        return timeOfJourney;
    }

    public void setTimeOfJourney(LocalTime timeOfJourney) {
        this.timeOfJourney = timeOfJourney;
    }
    public Map<String, Integer> getSeatsAvailable() {
        return SeatsAvailable;
    }

    public void setSeatsAvailable(Map<String, Integer> seatsAvailable) {
        SeatsAvailable = seatsAvailable;
    }

    public Map<String, Double> getPrices() {
        return Prices;
    }

    public void setPrices(Map<String, Double> prices) {
        Prices = prices;
    }
}
