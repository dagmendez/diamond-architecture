package com.github.dagmendez.command

trait Delete[Input, Query] extends Command[Input, Unit]:
  override def execute(input: Input): Unit =
    val query = keyGenerator(input)
    repositoryCallback(query)

  def keyGenerator(input: Input): Query
  def repositoryCallback(query: Query): Unit
