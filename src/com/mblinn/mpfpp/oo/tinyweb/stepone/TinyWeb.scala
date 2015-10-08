package com.mblinn.mpfpp.oo.tinyweb.stepone
/**
 * 首先定义了一个接受两个构造器参数的类，分别是一个控制器的map和一个过滤器的列表
 * 请注意filters参数的类型:List[(HttpRequest)=>HttpRequest]
 * 这说明filters是一组函数，这些函数都以HttpRequest为入参，并且返回的也是HttpRequest
 */
class TinyWeb(controllers : Map[String,Controller],
    filters : List[(HttpRequest)=>HttpRequest]) {
   /**
    *返回Option[HttpResponse]类型替代原来的HttpResponse类型。
    * 这个Option类型是一个容器类型，他拥有两个子类型：some 和None
    * 如果我们获取到了想要存入该类型的值，就将该值存储在一个Some的实例中，
    * 否则，使用None来表明我们没有获取到任何实际的值
    */
  def handleRequest(httpRequest : HttpRequest) : Option[HttpResponse]={
      val composedFilter = filters.reverse.reduceLeft(
          (composed,next) =>composed compose next
          )
      val filteredRequest=composedFilter(httpRequest)
      val controllerOption=controllers.get(filteredRequest.path)
      
      controllerOption map{controller => controller.handleRequest(filteredRequest)}
  }
}