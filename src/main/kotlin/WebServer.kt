import fi.iki.elonen.NanoHTTPD
import java.io.IOException
import java.util.logging.FileHandler
import java.util.logging.Logger
import java.util.logging.SimpleFormatter

class WebServer(val inputHostname: String, val port: Int) : NanoHTTPD(inputHostname, port)
{
   var logger = Logger.getLogger(javaClass.simpleName)

   init
   {
      setupLogging()
   }

   fun startHttpThread()
   {
      logger.info("Starting server...")
      start(NanoHTTPD.SOCKET_READ_TIMEOUT, false)
   }

   override fun serve(session: IHTTPSession?): Response
   {
      return newFixedLengthResponse("helloooooo")
   }

   @Throws(SecurityException::class, IOException::class)
   fun setupLogging()
   {
      val fileHandler = FileHandler("server.log", true)
      logger.addHandler(fileHandler)
      fileHandler.formatter = SimpleFormatter()
   }
}

fun main(args: Array<String>)
{
   WebServer("localhost", 8089).startHttpThread()
}