package barcodeScanner;

public interface BarcodeScannerObserver {
    void update(String barcode);
}