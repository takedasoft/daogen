package jp.takedasoft.parser

import scala.util.parsing.combinator._

class DDLParser extends Parser[Create] with JavaTokenParsers {
  val space = "".r
  val identity = """[a-zA-Z0-9]+""".r
  val number = """[0-9]+""".r
  def colOption:Parser[Number] = "(" ~ number ~ ")" ^^ { case a~num~b => num.toInt }
  def column:Parser[Column] = 
    identity ~ identity ~ opt( colOption ) ^^ { case name~stype~o => Column(name,stype,o) }
  
  def columns:Parser[ List[Column] ] = "(" ~> repsep(column,",") <~ ");" ^^ { case l => l }
  def create:Parser[Create] =
    "create"~"table" ~ identity ~ columns ^^ { case c~t~name~cs => Create(name,cs) }

  override def parse(s:String):ParseResult[Create] = parseAll( create, s.toLowerCase )
}
