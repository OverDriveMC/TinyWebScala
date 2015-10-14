package com.mblinn.mpfpp.oo.tinyweb.stepone

object Example {
  def greetingViewRenderer(model : Map[String,List[String]])={
    "<h1> Friendly Greetings:%s".format(
        model
        getOrElse("greetings",List[String]())
        map(renderGreeting)    
        mkString ", "
      )
  }
  
  private def renderGreeting(greeting:String)="<h2>%s</h2>".format(greeting)
  def greetingView=new FunctionView(greetingViewRenderer)
  
  def main(args:Array[String]){
    val greetings=List("Hi!","Hola","Aloha")
    println(greetings.map(renderGreeting))
    println(greetings map renderGreeting)
  }
}