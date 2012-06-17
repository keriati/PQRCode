package com.keriati.pqrcode;

import org.apache.commons.cli.*;

public class PQOptions {

    private int height;
    private int width;
    private int quietZoneSize;
    private String data;
    private String output;
    private String format;

    public PQOptions() {}

    public void parse(String[] args) {
        Options options = new Options();

        options.addOption(OptionBuilder
                .withLongOpt("width")
                .withDescription("Output file width in pixels. Default: 250")
                .hasArgs(1)
                .withArgName("width")
                .create("w"));

        options.addOption(OptionBuilder
                .withLongOpt("height")
                .withDescription("Output file height in pixels. Default: 250")
                .hasArgs(1)
                .withArgName("height")
                .create("h"));

        options.addOption(OptionBuilder
                .isRequired()
                .withLongOpt("output")
                .withDescription("Output file name. (required)")
                .hasArgs(1)
                .withArgName("output")
                .create("o"));

        options.addOption(OptionBuilder
                .isRequired()
                .withLongOpt("data")
                .withDescription("Data to encode. (required)")
                .hasArgs(1)
                .withArgName("data")
                .create("d"));

        options.addOption(OptionBuilder
                .withLongOpt("format")
                .withDescription("Image format. Supported values: JPEG, PNG, GIF, BMP, WBMP. Default is: PNG")
                .hasArgs(1)
                .withArgName("format")
                .create("f"));

        options.addOption(OptionBuilder
                .withLongOpt("quietZoneSize")
                .withDescription("White border size arround the QR Code. Default: 4.")
                .hasArgs(1)
                .withArgName("quietZoneSize")
                .create("q"));

        GnuParser parser = new GnuParser();

        try {
            CommandLine line = parser.parse(options, args);

            width = Integer.parseInt(line.getOptionValue("width", "250"));
            height = Integer.parseInt(line.getOptionValue("height", "250"));
            quietZoneSize = Integer.parseInt(line.getOptionValue("quietZoneSize", "4"));
            format = line.getOptionValue("format", "PNG");

            if (line.hasOption("output")) {
                output = line.getOptionValue("output");
            }

            if (line.hasOption("data")) {
                data = line.getOptionValue("data");
            }

        } catch (ParseException exp) {
            System.out.println("ERROR:" + exp.getMessage());
        }

        if (output == null || data == null) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar PQRCode.jar", options);
            System.exit(0);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getQuietZoneSize() {
        return quietZoneSize;
    }

    public String getData() {
        return data;
    }

    public String getOutput() {
        return output;
    }

    public String getFormat() {
        return format;
    }
}
