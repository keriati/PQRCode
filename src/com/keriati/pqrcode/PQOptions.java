package com.keriati.pqrcode;

import org.apache.commons.cli.*;

public class PQOptions {

    private int height = 250;
    private int width = 250;
    private String data = null;
    private String output = null;

    public PQOptions() {
    }

    public void parse(String[] args) {
        Options options = new Options();

        options.addOption(OptionBuilder.withLongOpt("width")
                .withDescription("Output file width in pixels.")
                .hasArgs(1)
                .withArgName("width")
                .create("w"));

        options.addOption(OptionBuilder.withLongOpt("height")
                .withDescription("Output file height in pixels.")
                .hasArgs(1)
                .withArgName("height")
                .create("h"));

        options.addOption(OptionBuilder.withLongOpt("output")
                .withDescription("Output file name.")
                .hasArgs(1)
                .withArgName("output")
                .create("o"));

        options.addOption(OptionBuilder.withLongOpt("data")
                .withDescription("Data to encode.")
                .hasArgs(1)
                .withArgName("data")
                .create("d"));

        GnuParser parser = new GnuParser();

        try {
            CommandLine line = parser.parse(options, args);

            if (line.hasOption("width")) {
                width = Integer.parseInt(line.getOptionValue("width"));
            }

            if (line.hasOption("height")) {
                height = Integer.parseInt(line.getOptionValue("height"));
            }

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

    public String getData() {
        return data;
    }

    public String getOutput() {
        return output;
    }
}
