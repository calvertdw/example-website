package com.calvertSoftware

import fi.iki.elonen.NanoHTTPD
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import org.mapdb.DBMaker
import java.io.IOException
import java.nio.file.Paths
import java.util.logging.FileHandler
import java.util.logging.Logger
import java.util.logging.SimpleFormatter

class WebServer(val inputHostname: String, val port: Int) : NanoHTTPD(inputHostname, port)
{
   var logger = Logger.getLogger(javaClass.simpleName)
   var database = DBMaker.fileDB(Paths.get("database.db").toFile()).transactionEnable().closeOnJvmShutdown().fileMmapEnable().make()

   var hitCount = database.atomicLong("hitCounter").createOrOpen()

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
      hitCount.incrementAndGet()
      database.commit()

      val htmlString = StringBuilder()
      htmlString.appendHTML().html {
         body {
            div {
               h1 {
                  p { +"Hit count: ${hitCount.get()}" }
               }
            }
         }
      }

      return newFixedLengthResponse(Response.Status.OK, NanoHTTPD.MIME_HTML, htmlString.toString())
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