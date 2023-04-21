package com.github.dagmendez.command

trait FindCommand[Input, Query, Intermediate, Output] extends Command[Input, Output]:
  def keyGenerator: Input => Query
  def converter: Conversion[Intermediate, Output]
  def repositoryCallback: Query => Intermediate

  override def execute(input: Input): Output =
    val query: Query = keyGenerator.apply(input)
    val repositoryAnswer: Intermediate = repositoryCallback.apply(query)
    val answerToOutputType: Output = converter.convert(repositoryAnswer)
    answerToOutputType
