package jp.takedasoft.parser

object CreateTest {
  def main(args:Array[String]) {
   p("""
   CREATE table SIMPLE (
     ID integer(10),
     last_name VARCHAR(255),
     first_name VARCHAR(255)
   );
   """)
  }

  def p( sql:String ) {
    println( sql )
    val phpgen = new DDLParser with PHPDaoGenerator
    println( phpgen.parse(sql) )
    println( phpgen.generate( phpgen.parse(sql) ) )
    
    val railsgen = new DDLParser with RailsModelGenerator
    println( railsgen.generate( railsgen.parse(sql) ) )
  }
}
