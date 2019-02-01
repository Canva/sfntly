# sfntly Quick Start Guide #

This is a slightly modified fork of Google's sfntly (https://github.com/googlei18n/sfntly).

Sfntly was a Google project used for Google fonts, and it focusses on modifying font metadata, on font conversion, and on (experimental, not production-ready) font subsetting.

Reason for integrating it into Canva was that we need to do some font conversion & font metadata manipulation to embed fonts into PowerPoint documents. The tooling we initially used (ttf2eot and fontforge) turned out to be fragile and very slow.

Google abandoned this project years ago, and the recommended 'actively maintained fork' (https://github.com/rillig/sfntly) is, at the time of writing, not very active (and in particular, not doing any kind of 'interesting' commits).

This fork has been created mainly to convert it into a maven project & simplify the integration into our build. There are a few forks on Maven Central, but none of them looked very trustworthy, or provided the required functionality.

Other changes on this fork:

- removed all C++ code
- updated API dependencies to more recent versions
- simplified a few tests
- introduced a backdoor

As the Google project still is updated from time to time, it might be good to occasionally rebase this fork as well.

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
  
