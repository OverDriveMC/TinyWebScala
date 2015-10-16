package com.mblinn.mpfpp.oo.tinyweb.stepone

//假如想使用默认值，必须得提供一个
case class HttpRequest(headers:Map[String,String]=null,body:String,path:String)