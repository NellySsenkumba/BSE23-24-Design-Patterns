package barcodeScanner;

public interface BarcodeScannerSubject {
    void attach(BarcodeScannerObserver observer);
    void detach(BarcodeScannerObserver observer);
    void notifyObservers(String barcode);
}