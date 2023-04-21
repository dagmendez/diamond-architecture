package com.github.dagmendez.command

trait SaveCommand[Input, Intermediate, Output] extends Command[Input, Input]:
  def converter: Conversion[Input, Intermediate]
  def reverseConverter: Conversion[Intermediate, Input]
  def repositoryCallback: Intermediate => Intermediate

  override def execute(input: Input): Input =
    val inputToIntermediate: Intermediate = converter.convert(input)
    val repositoryAnswer: Intermediate = repositoryCallback.apply(inputToIntermediate)
    val answerToInputType: Input = reverseConverter.convert(repositoryAnswer)
    answerToInputType
