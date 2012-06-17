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

## LICENSE ##

Copyright 2012 Attila Kerekes

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Apache Commons CLI
Copyright 2001-2009 The Apache Software Foundation

This product includes software developed by
The Apache Software Foundation (http://www.apache.org/).

ZXing
Copyright 2007-2012 ZXing authors

This product includes software developed by
ZXing authors (http://code.google.com/p/zxing/).