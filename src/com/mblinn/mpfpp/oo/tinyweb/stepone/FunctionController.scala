package com.mblinn.mpfpp.oo.tinyweb.stepone

trait Controller{
  def handleRequest(httpRequest: HttpRequest):HttpResponse
}

class FunctionController(view:View, 
  doRequest:(HttpRequest)=> Map[String,List[String]]) extends Controller {
  def handlerRequest(request : HttpRequest) :HttpResponse={
    var responseCode=200
    var responseBody=""
    try{
      var model=doRequest(request)
      responseBody=view.render(model)
      
    }catch{
      case e: ControllerException =>
        responseCode=e.getStatusCode()
    }
  }
}