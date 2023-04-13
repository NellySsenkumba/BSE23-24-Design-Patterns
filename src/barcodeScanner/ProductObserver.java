package barcodeScanner;

public interface ProductObserver {
    void update(String barcode);

    void update(String barcode, int quantity);
}