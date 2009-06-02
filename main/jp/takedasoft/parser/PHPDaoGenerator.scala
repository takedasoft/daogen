package jp.takedasoft.parser

trait PHPDaoGenerator extends Generator[Create] {
  override def generate(result:ParseResult[Create]):String = {
    
    val create:Create = result.get
    var clazz = "class " + create.name + " extends Dao{\n"
      create.cols.foreach{ col => 
        clazz += "  var " + col.name.toPHPVar + " ;\n"
      }
      create.cols.foreach{ col => 
        clazz += "  function " + col.name.toSetter + "(" + col.name.toPHPVar + "){\n" + 
                 "    $this->" + col.name + "=" + col.name.toPHPVar + ";\n" + 
                 "  } \n" + 
                 "  function " + col.name.toGetter + "(){\n" + 
                 "    return $this->" + col.name + ";\n" + 
                 "  } \n"
      }
      clazz + "}//end of class"
    }
}
