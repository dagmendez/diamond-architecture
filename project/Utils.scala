object Utils {
  def styled(in: Any): String =
    scala.Console.CYAN + in + scala.Console.RESET

  val Cctt: String = "compile->compile;test->test"
}
