package jp.takedasoft.parser

import scala.util.parsing.combinator._

case class Create( name:String, cols:List[Column] ) {}
case class Column( name:String, sql_type:String, option:Option[Any] ) {}

trait Parser[T] extends Parsers {
  def parse(s:String):ParseResult[T]
}
trait Generator[T] extends Parsers {
  def generate(parseResult:ParseResult[T]):Any
}
