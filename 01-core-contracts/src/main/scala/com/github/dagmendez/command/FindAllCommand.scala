package com.github.dagmendez.command

trait FindAllCommand[Input, Query, Intermediate, Output] extends Command[Input, Vector[Output]]:
  def keyGenerator: Input => Query
  def converter: Conversion[Intermediate, Output]
  def repositoryCallback: Query => Vector[Intermediate]

  override def execute(input: Input): Vector[Output] =
    val query: Query = keyGenerator(input)
    val repositoryAnswer: Vector[Intermediate] = repositoryCallback.apply(query)
    val answerToOutputType = repositoryAnswer.map(converter.convert)
    answerToOutputType
