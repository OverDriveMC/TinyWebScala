package com.mblinn.mpfpp.oo.tinyweb.stepone

trait View{
  def render(model: Map[String,List[String]]):String
}
class FunctionView(
    viewRenderer :(Map[String,List[String]])=>String) 
                        extends View {
  
  /**
   * 该方法以model为入参，并将该model传入viewRenderer方法运行
   */
  def render(model: Map[String, List[String]]): String = {
    try
      viewRenderer(model)
     catch{
       case e:Exception => throw new RenderingException(e)
     }     
  }
}

