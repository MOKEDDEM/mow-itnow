package com.xebia.mowitnow

import java.io.IOException
import com.xebia.mowitnow.model.Factory.{GroundFactoryImpl, InstructionFactoryImpl, MowerFactoryImpl}
import com.xebia.mowitnow.service._
import org.slf4j.LoggerFactory
import ch.qos.logback.classic.{Level, Logger}
import java.nio.file.{Paths, Files}
import scala.util.control.Breaks._
/**
  * Main runner
  * @author omokeddem
  **/
object Runner extends App {
  implicit lazy val groundFactory = new GroundFactoryImpl;
  implicit lazy val mowerFactory = new MowerFactoryImpl;
  implicit lazy val instructionFactory = new InstructionFactoryImpl;
  implicit lazy val groundService = new GroundServiceImpl;
  implicit lazy val mowerService = new MowerServiceImpl;
  implicit lazy val instructionService = new InstructionServiceImpl;
  implicit lazy val dataScannerService = new DataScannerServiceImpl;
  implicit lazy val processService = new ProcessServiceImpl;

  val version: String = getClass.getPackage.getImplementationVersion
  var hasFileArgs = false
  var debug = false
  var fileArgsStart = 0
  val logger = LoggerFactory.getLogger(classOf[App])

  if (args.length == 0) {
    usage()
    System.exit(1)
  }
  breakable {
    for (i <- 0 to args.length - 1) {
      if (!args(i).startsWith("--")) {
        hasFileArgs = true
        fileArgsStart = i
        break
      } else {
        if ("--debug".equals(args(i))) {
          setLoggingLevel(Level.DEBUG)
        } else if ("--version".equals(args(i))) {
          if (version != null) {
            println(version)
          } else {
            println("[unknown version]")
          }
          System.exit(0)
        } else if ("--help".equals(args(i))) {
          usage()
          System.exit(0)
        }
      }
    }
  }
  if (hasFileArgs) {
    ProcessFiles(args, fileArgsStart)
  } else {
    System.err.printf("\nError: No documents specified.\n");
    usage();
    System.exit(1);
  }

  def ProcessFiles(args: Array[String], fileArgsStart: Int) {
    for (i <- fileArgsStart to args.length - 1) {
      if (isTextFile(args(i))) {
        logger.info("processing of " + args(i))
        try {
          processService.mowItNowTextFile(args(i))
        } catch {
          case ioe: IOException => logger.error("Error {}", ioe.fillInStackTrace())
        }
      } else {
        logger.error("File was not processed .input file {} is not valid text file", args(i))
      }
    }
  }

  def isTextFile(file: String): Boolean = {
    (file.endsWith(".txt") && Files.exists(Paths.get(file)))
  }

  def setLoggingLevel(level: Level) {
    // Sets the package level to INFO
    val root: Logger = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME).asInstanceOf[Logger]
    root.setLevel(level)
  }

  def usage() {
    println("Usage:")
    println("")
    println("    java -jar mow-it-now-1.0-jar-with-dependencies.jar [--debug]")
    println(" [--help]")
    println(" [--version] FILES")
    println("")
    println("For detailed usage information, use \"java -jar mow-it-now-1.0-jar-with-dependencies.jar --help\" or see:")
    println("")
    println("https://github.com/MOKEDDEM/mow-itnow")
  }
}
