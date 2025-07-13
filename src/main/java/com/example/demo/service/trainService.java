package com.example.demo.service;


import com.example.demo.model.trainList;
import com.example.demo.repository.trainrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class trainService {
    @Autowired
    trainrepository rep;
    private List<trainList> alltrains;

    public List<trainList> allTrains() {

        return rep.findAll();
    }

    public List<trainList> filterTrains(String Source, String Destination, LocalDate doj) {
        System.out.println(Source);
        System.out.println(Destination);
        alltrains = rep.findAll();
        List<trainList> filtertrains = new ArrayList<>();
        for (trainList l : alltrains) {
            if (l.getSource().equalsIgnoreCase(Source) && l.getDestination().equalsIgnoreCase(Destination) && l.getDateOfJourney().equals(doj)) {
                filtertrains.add(l);
            } else {
                List<String> Stations = l.getIntermediateStation();
                int userSourceindex = -1;
                int userDestinationindex = -1;

                for (int i = 0; i < Stations.size(); i++) {
                    if (l.getSource().equalsIgnoreCase(Source)) {
                        userSourceindex = 0;
                        //System.out.println("UserSourceIndex" + userSourceindex);
                    } else if (Stations.get(i).equalsIgnoreCase(Source)) {
                        userSourceindex = i + 1;
                        //System.out.println("UserSourceIndex" + userSourceindex);
                    }

                    if (l.getDestination().equalsIgnoreCase(Destination)) {
                        userDestinationindex = Stations.size() + 1;
                        System.out.println("UserDestinationIndex" + userDestinationindex);
                    } else if (Stations.get(i).equalsIgnoreCase(Destination)) {
                        userDestinationindex = i + 1;
                        System.out.println("UserDestinationIndex" + userDestinationindex);
                    }
                    if (userSourceindex != -1 && userDestinationindex != -1 && userSourceindex <= userDestinationindex) {
                        filtertrains.add(l);
                        break;
                    }
                }
                System.out.println(filtertrains.size());
            }
        }
        return filtertrains;
    }

    public trainList trainDetails(int trainNumber) {
        for (trainList l : alltrains) {
            if (l.getTrainNumber() == trainNumber) {
                return l;
            }
        }
        return null;
    }

    public trainList trainBooking(int trainNumber, int NoOfSeats, String Classtype) {
        System.out.println(NoOfSeats);
        System.out.println(Classtype);
        for (trainList l : alltrains) {
            if (l.getTrainNumber() == trainNumber) {
                Map<String, Integer> ticketRemaining = l.getSeatsAvailable();
                int Available = ticketRemaining.getOrDefault(Classtype, 0);
                if (Available < NoOfSeats) {
                    System.out.println("No of Seats is less than the user asking");
                } else {
                    int remaining = ticketRemaining.get(Classtype) - NoOfSeats;
                    ticketRemaining.replace(Classtype, ticketRemaining.get(Classtype), remaining);
                    l.setSeatsAvailable(ticketRemaining);
                    rep.save(l);
                }
            }
            return l;
        }
        return null;
    }
}