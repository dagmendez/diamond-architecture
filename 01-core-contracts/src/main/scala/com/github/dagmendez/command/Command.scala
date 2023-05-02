package com.github.dagmendez.command

trait Command[Input, Output]:
  def execute(input: Input): Output
end Command

trait Delete[Input, Query] extends Command[Input, Unit]:
  val keyGenerator: Input => Query
  val repositoryCallback: Query => Unit
  override def execute(input: Input): Unit =
    val key = keyGenerator.apply(input)
    repositoryCallback.apply(key)
end Delete

trait FindAllCommand[Input, Query, Intermediate, Output] extends Command[Input, Vector[Output]]:
  val keyGenerator: Input => Query
  val converter: Conversion[Intermediate, Output]
  val repositoryCallback: Query => Vector[Intermediate]

  override def execute(input: Input): Vector[Output] =
    val query: Query = keyGenerator(input)
    val repositoryAnswer: Vector[Intermediate] = repositoryCallback.apply(query)
    val answerToOutputType = repositoryAnswer.map(converter.convert)
    answerToOutputType
end FindAllCommand

trait FindCommand[Input, Query, Intermediate, Output] extends Command[Input, Output]:
  val  keyGenerator: Input => Query
  val converter: Conversion[Intermediate, Output]
  val repositoryCallback: Query => Intermediate
  
  override def execute(input: Input): Output =
    val query: Query = keyGenerator.apply(input)
    val repositoryAnswer: Intermediate = repositoryCallback.apply(query)
    val answerToOutputType: Output = converter.convert(repositoryAnswer)
    answerToOutputType
end FindCommand

trait SaveCommand[Input, Intermediate, Output] extends Command[Input, Input]:
  val converter: Conversion[Input, Intermediate]
  val reverseConverter: Conversion[Intermediate, Input]
  val repositoryCallback: Intermediate => Intermediate

  override def execute(input: Input): Input =
    val inputToIntermediate: Intermediate = converter.convert(input)
    val repositoryAnswer: Intermediate = repositoryCallback.apply(inputToIntermediate)
    val answerToInputType: Input = reverseConverter.convert(repositoryAnswer)
    answerToInputType
end SaveCommand
