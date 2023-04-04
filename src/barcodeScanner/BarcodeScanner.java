package barcodeScanner;

import java.util.ArrayList;
import java.util.List;

public class BarcodeScanner implements BarcodeScannerSubject {
    private List<BarcodeScannerObserver> observers = new ArrayList<>();

    public void attach(BarcodeScannerObserver observer) {
        observers.add(observer);
    }

    public void detach(BarcodeScannerObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String barcode) {
        for (BarcodeScannerObserver observer : observers) {
            observer.update(barcode);
        }
    }
}