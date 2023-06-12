package com.github.dagmendez.command

trait Find[Input, Intermediate, Output, Query] extends Command[Input, Output]:
  override def execute(input: Input): Output =
    val query: Query = queryGenerator(input)
    val result: Intermediate = callback(query)
    reverseConverter(result)

  def queryGenerator(input: Input): Query
  def callback(query: Query): Intermediate
  def reverseConverter: Conversion[Intermediate, Output]
