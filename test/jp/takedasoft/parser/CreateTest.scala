package jp.takedasoft.parser

object CreateTest {
  def main(args:Array[String]) {
   p("""
   CREATE table SIMPLE (
     ID integer(10),
     name VARCHAR(255)
   );
   """)
  }

  def p( sql:String ) {
    val gen = new DDLParser with PHPDaoGenerator
    println( sql )
    println( gen.parse(sql) )
    println( gen.generate( gen.parse(sql) ) )

  }
}
