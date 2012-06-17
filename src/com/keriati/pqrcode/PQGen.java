/*
 * Copyright 2007 Attila Kerekes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.keriati.pqrcode;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.IOException;

public class PQGen {

    private PQOptions options = null;

    public PQGen() {

    }

    public void generate() {
        if (this.options != null) {
            BitMatrix matrix = null;
            com.keriati.pqrcode.PQRCodeWriter writer = new PQRCodeWriter();

            writer.setQuietZoneSize(this.options.getQuietZoneSize());

            try {
                matrix = writer.encode(this.options.getData(), com.google.zxing.BarcodeFormat.QR_CODE, this.options.getWidth(), this.options.getHeight());
            } catch (com.google.zxing.WriterException e) {
                System.out.println(e.getMessage());
            }

            File file = new File(this.options.getOutput());

            try {
                MatrixToImageWriter.writeToFile(matrix, this.options.getFormat(), file);
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
