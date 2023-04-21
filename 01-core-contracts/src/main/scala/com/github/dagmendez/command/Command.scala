package com.github.dagmendez.command



trait Command[Input, Output]:
  def execute(input: Input): Output
end Command

trait Delete[Input, Query](
  keyGenerator: Input => Query,
  repositoryCallback: Query => Unit
) extends Command[Input, Unit]:

  override def execute(input: Input): Unit =
    val key = keyGenerator.apply(input)
    repositoryCallback.apply(key)
end Delete

trait FindAllCommand[Input, Query, Intermediate, Output](
  keyGenerator: Input => Query,
  converter: Conversion[Intermediate, Output],
  repositoryCallback: Query => Vector[Intermediate]
) extends Command[Input, Vector[Output]]:

  override def execute(input: Input): Vector[Output] =
    val query: Query = keyGenerator(input)
    val repositoryAnswer: Vector[Intermediate] = repositoryCallback.apply(query)
    val answerToOutputType = repositoryAnswer.map(converter.convert)
    answerToOutputType
end FindAllCommand

trait FindCommand[Input, Query, Intermediate, Output](
  keyGenerator: Input => Query,
  converter: Conversion[Intermediate, Output],
  repositoryCallback: Query => Intermediate
) extends Command[Input, Output]:

  override def execute(input: Input): Output =
    val query: Query = keyGenerator.apply(input)
    val repositoryAnswer: Intermediate = repositoryCallback.apply(query)
    val answerToOutputType: Output = converter.convert(repositoryAnswer)
    answerToOutputType
end FindCommand

trait SaveCommand[Input, Intermediate, Output](
  converter: Conversion[Input, Intermediate],
  reverseConverter: Conversion[Intermediate, Input],
  repositoryCallback: Intermediate => Intermediate
) extends Command[Input, Input]:

  override def execute(input: Input): Input =
    val inputToIntermediate: Intermediate = converter.convert(input)
    val repositoryAnswer: Intermediate = repositoryCallback.apply(inputToIntermediate)
    val answerToInputType: Input = reverseConverter.convert(repositoryAnswer)
    answerToInputType
end SaveCommand






