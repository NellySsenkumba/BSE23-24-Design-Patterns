package barcodeScanner;

public interface ProductObserver {
    void update(String barcode) throws CloneNotSupportedException;

    void update(String barcode, int quantity) throws CloneNotSupportedException;
}