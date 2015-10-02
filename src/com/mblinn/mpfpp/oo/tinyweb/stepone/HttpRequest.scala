package com.mblinn.mpfpp.oo.tinyweb.stepone

case class HttpRequest(headers:Map[String,String],body:String,path:String)