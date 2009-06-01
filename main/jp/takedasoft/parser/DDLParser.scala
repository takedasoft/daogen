package jp.takedasoft.parser

import scala.util.parsing.combinator._

class DDLParser extends JavaTokenParsers {
  val string = """[a-zA-Z0-9]+""".r
  val space = "".r
  val number = """[0-9]+""".r

  def colOption:Parser[Number] = "(" ~ number ~ ")" ^^ { case a~num~b => num.toInt }
  def column:Parser[Column] = 
    string ~ string ~ opt( colOption ) ^^ { case name~stype~o => Column(name,stype,o) }
  def columns:Parser[ List[Column] ] = "(" ~> repsep(column,",") <~ ");" ^^ { case l => l }
  def create:Parser[Create] =
    "create table" ~ string ~ columns ^^ { case literal~name~cs => Create(name,cs) }

  case class Create( name:String, cols:List[Column] ) {}
  case class Column( name:String, sql_type:String, option:Option[Any] ) {}
}

object CreateTest extends DDLParser {
  def main(args:Array[String]) {
   p("""
   CREATE table simple (
     id integer(10),
     name varchar(255)
   );
   """)
  }

  def p( sql:String ) {
    val s = sql.toLowerCase
    println(s)
    println( parseAll(create, s) )
 
  }

}
