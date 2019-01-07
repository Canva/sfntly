# sfntly Quick Start Guide #

This is a slightly modified fork of Google's sfntly (https://github.com/googlei18n/sfntly).

Differences:

- Removed non-Java code
- using Maven instead of Ant
- upgraded dependencies
- using JUnit 4 annotations, simplified some tests

## Maven Build ##

Run 

`mvn clean install`

to build the sfntly library.

Or:

Run   

` mvn clean install -Dskip.tools=false`

to build the sfntly library as well as the included command line tools (`fontinfo.jar` and `sfnttool.jar`).

## Running the tools ##

After building, run 

`java -jar fontInfo.jar <path/to/font/file>`

to get basic font info about the specified font.

Or:

Run

`java -jar sfnttool.jar`

for details about how to use sfnttool.
  
