package jp.takedasoft.parser

/**
 * It's joke.
 */
trait RailsModelGenerator extends Generator[Create] {
  implicit def stringExt(s:String) = new jp.takedasoft.core_extension.StringExt(s)  
  override def generate(result:ParseResult[Create]):String ={
    "class " + result.get.name.classify + " << ActiveRecord::Base\nend\n"
  }
}