package com.github.dagmendez.command

trait Delete[Input, Query] extends Command[Input, Unit]:
  override def execute(input: Input): Unit =
    val key = keyGenerator.apply(input)
    repositoryCallback.apply(key)

  lazy val keyGenerator: Input => Query
  lazy val repositoryCallback: Query => Unit