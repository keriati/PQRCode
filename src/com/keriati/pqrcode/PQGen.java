package com.keriati.pqrcode;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;

public class PQGen {

    private PQOptions options = null;

    public PQGen() {

    }

    public void generate() {
        if (this.options != null) {
            BitMatrix matrix = null;
            com.google.zxing.Writer writer = new QRCodeWriter();

            try {
                matrix = writer.encode(this.options.getData(), com.google.zxing.BarcodeFormat.QR_CODE, this.options.getWidth(), this.options.getHeight());
            } catch (com.google.zxing.WriterException e) {
                System.out.println(e.getMessage());
            }

            File file = new File(this.options.getOutput());

            try {
                MatrixToImageWriter.writeToFile(matrix, "PNG", file);
                System.out.println("Printing to: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setOptions(PQOptions options) {
        this.options = options;
    }
}
