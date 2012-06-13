//The very portable qr code generator!
// by Attila Kerekes @keriati

package com.keriati.pqrcode;

public class PQRCode {
    public static void main(String[] args) {
        System.out.println("PQRCode - The portable QR Code generator!");

        PQOptions options = new PQOptions();
        options.parse(args);

        PQGen generator = new PQGen();
        generator.setOptions(options);
        generator.generate();
        System.out.println("Finished.");
    }
}
