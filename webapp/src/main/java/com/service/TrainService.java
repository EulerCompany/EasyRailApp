package com.service;

import com.entity.Train;
import com.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public Train findByTrainName(String name) {
        return trainRepository.findByTrainName(name);
    }

    public boolean saveTrain(String trainName, Date departureTime, Date arrivalTime) {
        Train trainFromDb = trainRepository.findByTrainName(trainName);

        Train train = new Train(trainName, departureTime, arrivalTime);

        if(trainFromDb == null) {
            trainRepository.save(train);
            return true;
        }


        //Check if dates overlaps
        boolean firstOverlapCheck = trainFromDb.getDepartureTime().compareTo(arrivalTime) <= 0;
        boolean secondOverlapCheck = departureTime.compareTo(trainFromDb.getArrivalTime())  > 0;

        if(!(firstOverlapCheck && secondOverlapCheck)) {

            trainRepository.save(train);
            return true;
        }

        return false;
    }
    public boolean saveTrain(String trainName) {
        Train trainFromDb = trainRepository.findByTrainName(trainName);

        Train train = new Train();
        train.setTrainName(trainName);

        if (trainFromDb == null) {
            trainRepository.save(train);
            return true;
        }
        return false;
    }
}
