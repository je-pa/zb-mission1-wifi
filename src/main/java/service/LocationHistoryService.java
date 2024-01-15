package service;

import entity.LocationHistory;
import repository.LocationHistoryRepository;

import java.util.List;

public class LocationHistoryService {
    private LocationHistoryRepository locationHistoryRepository;

    public LocationHistoryService(LocationHistoryRepository locationHistoryRepository) {
        this.locationHistoryRepository = locationHistoryRepository;
    }

    public int addHistory(double lat, double lnt) {
        return locationHistoryRepository.addHistory(lat, lnt);
    }

    public List<LocationHistory> getList() {
        return locationHistoryRepository.getList();
    }

    public int deleteById(int id) {
        return locationHistoryRepository.deleteById(id);
    }
}
