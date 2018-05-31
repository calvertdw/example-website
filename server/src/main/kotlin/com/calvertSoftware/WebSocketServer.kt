package com.calvertSoftware

import fi.iki.elonen.NanoWSD
import java.io.IOException

class WebSocketServer(val inputHostname: String, val port: Int) : NanoWSD(inputHostname, port)
{
   override fun openWebSocket(handshake: IHTTPSession): WebSocket
   {
      return SubSocket(handshake)
   }

   class SubSocket(handshakeRequest: IHTTPSession) : WebSocket(handshakeRequest)
   {
      override fun onClose(code: WebSocketFrame.CloseCode?, reason: String?, initiatedByRemote: Boolean)
      {
      }

      override fun onPong(pong: WebSocketFrame?)
      {
      }

      override fun onMessage(message: WebSocketFrame?)
      {
      }

      override fun onException(exception: IOException?)
      {
      }

      override fun onOpen()
      {
      }
   }
}