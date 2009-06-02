package jp.takedasoft.core_extension

class StringExt(s:String) {
  def camelize:String = {
    var result = ""
    s.split("_").foreach( line => result += line.capitalize )
    result
  }
  def underscore:String = {
    s + "_userScored"
  }
  def pluralize:String = {
     s + "s"
  }
  def singularize:String = {
     s.drop(s.length-1)
  }
  def titleize:String = {
    s.capitalize
  }
  def classify:String = {
    s.capitalize
  }
}
