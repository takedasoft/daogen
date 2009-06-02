package jp.takedasoft.core_extension

class StringExt(s:String) {
  def camelize:String = {
    s + "Camelized"
  }
  def underscore:String = {
    s + "UserScored"
  }
  def toSetter:String = {
    "set_" + s
  }
  def toGetter:String = {
    "get_" + s
  }
  def pluralize:String = {
     s + "s"
  }
  def singulize:String = {
     s + "-s"
  }
  def toPHPVar:String = {
    "$" + s
  }
}
