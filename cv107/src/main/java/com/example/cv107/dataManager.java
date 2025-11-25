package com.example.cv107;

import org.example.cv107.cvModel;
import com.example.cv107.cvRepo;
import com.example.cv107.CVObserver;

import java.util.ArrayList;
import java.util.List;

public class dataManager {
    private static dataManager instance;
    private cvModel currentCVData;
    private List<cvModel> savedCVs;
    private List<CVObserver> observers;
    private cvRepo repository;
    private String navigationSource;

    private dataManager() {
        this.savedCVs = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.repository = cvRepo.getInstance();
    }

    public static dataManager getInstance() {
        if (instance == null) {
            instance = new dataManager();
        }
        return instance;
    }

    public void addObserver(CVObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(CVObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (CVObserver observer : observers) {
            observer.onCVListChanged();
        }
    }

    public void refreshCVList() {
        savedCVs = repository.getAllCVs();
        notifyObservers();
    }

    public List<cvModel> getSavedCVs() {
        return new ArrayList<>(savedCVs);
    }

    public cvModel getCurrentCVData() {
        return currentCVData;
    }

    public void setCurrentCVData(cvModel data) {
        this.currentCVData = data;
    }

    public void clearCurrentCVData() {
        this.currentCVData = null;
    }

    public boolean hasCurrentCVData() {
        return currentCVData != null;
    }

    public String getNavigationSource() {
        return navigationSource;
    }

    public void setNavigationSource(String source) {
        this.navigationSource = source;
    }
}
