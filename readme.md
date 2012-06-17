Portable QR Code generator
==========================

PQRCode.jar is a small portable and basic QR Code generator. It uses the ZXing library.

    usage: java -jar PQRCode.jar
     -d,--data <data>                    Data to encode. (required)
     -f,--format <format>                Image format. Supported values: JPEG, PNG, GIF, BMP, WBMP. Default is: PNG.
     -h,--height <height>                Output file height in pixels. Default: 250.
     -o,--output <output>                Output file name. (required)
     -q,--quietZoneSize <quietZoneSize>  White border size arround the QR Code. Default: 4.
     -w,--width <width>                  Output file width in pixels. Default: 250.

## Examples: ##

    java -jar PQRCode.jar -d http://github.com -o github.png
    java -jar PQRCode.jar -d http://github.com -o github.jpg -f JPEG -w 1000 -h 1000

Author: Attila Kerekes @keriati