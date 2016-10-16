# mow-itnow
##Technical environment used

    - Scala version 2.10.4
    - Maven version 1.6
    - slf4j version 1.6.4
    - logback version 1.0.1
    - Junit version 4.11
    - scalatest version 3.0.0-M3

## Usage 
First, build the code:
        
        mvn package
        
You can use the mow-it-now-1.0-jar-with-dependencies.jar as an executable for command-line by invoking it like this:

        java -jar  mow-it-now-1.0-jar-with-dependencies.jar  [--help]
                   [--debug] [--version] FILES
                  
**Note:** In these instructions, replace _"~/mow-it-now-1.0-jar-with-dependencies.jar"_ with the actual path to
the file on your system.

To process one or more documents from the command line:

       java -jar ~/mow-it-now-1.0-jar-with-dependencies.jar FILE.txt FILE2.txt FILE3.txt FILE4.txt...
       
### Options

When used from the command line as described in this section, the `mow-it-now-1.0-jar-with-dependencies.jar`
executable provides the following options:

#### --help

    Shows detailed usage information.

#### --debug

    Specifies debug to show details of processing

    default: [unset; output is not verbose]

#### --version

    Shows the vnu.jar version number.
