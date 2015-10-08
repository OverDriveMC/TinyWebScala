package com.mblinn.mpfpp.oo.tinyweb.stepone
/**
 * ���ȶ�����һ�����������������������࣬�ֱ���һ����������map��һ�����������б�
 * ��ע��filters����������:List[(HttpRequest)=>HttpRequest]
 * ��˵��filters��һ�麯������Щ��������HttpRequestΪ��Σ����ҷ��ص�Ҳ��HttpRequest
 */
class TinyWeb(controllers : Map[String,Controller],
    filters : List[(HttpRequest)=>HttpRequest]) {
   /**
    *����Option[HttpResponse]�������ԭ����HttpResponse���͡�
    * ���Option������һ���������ͣ���ӵ�����������ͣ�some ��None
    * ������ǻ�ȡ������Ҫ��������͵�ֵ���ͽ���ֵ�洢��һ��Some��ʵ���У�
    * ����ʹ��None����������û�л�ȡ���κ�ʵ�ʵ�ֵ
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