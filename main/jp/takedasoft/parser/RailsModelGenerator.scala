package jp.takedasoft.parser

/**
 * It's joke.
 */
trait RailsModelGenerator extends Generator[Create] {
  override def generate(result:ParseResult[Create]):String ={
    "class " + result.get.name + " << ActiveRecord::Base\nend\n"
  }
}