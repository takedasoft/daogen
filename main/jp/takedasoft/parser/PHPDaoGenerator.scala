package jp.takedasoft.parser
import jp.takedasoft.core_extension.StringExt

class StringExtForPHP(s:String) extends StringExt(s:String) {
  def toVar:String = {
    "$" + s
  }
  def toVarDef:String = {
    "var " + toVar + ";\n"
  }
  def toSetter:String = {
    "  function set" + camelize + "(" + toVar + "){\n" + 
    "    $this->" + s + " = " + toVar + ";\n" + 
    "  } \n"
  }
  def toGetter:String = {
    "  function get" + camelize + "(){\n" + 
    "    return $this->" + s + ";\n" + 
    "  } \n"
  }
}

trait PHPDaoGenerator extends Generator[Create] {
  implicit def stringExt(s:String) = new StringExtForPHP(s)  
  override def generate(result:ParseResult[Create]):String = {
    val create:Create = result.get
    var clazz = "class " + create.name.classify + " extends Dao{\n"
      create.cols.foreach{ col => 
        clazz += "  " + col.name.toVarDef
      }
      create.cols.foreach{ col => 
        clazz += col.name.toSetter + col.name.toGetter                 
      }
      clazz + "}//end of class"
    }
}
