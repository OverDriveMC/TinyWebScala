package com.mblinn.mpfpp.oo.tinyweb.stepone

class ControllerException(val statusCode : Int) extends RuntimeException{
  def getStatusCode()={
    statusCode
  }
}