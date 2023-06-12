package com.github.dagmendez.command

import com.github.dagmendez.repository.RepositoryFacade

trait Save[Input, Intermediate] extends Command[Input, Input]:
  override def execute(input: Input): Input =
    val converted: Intermediate = converter(input)
    val result: Intermediate = repository.run(converted)
    reverseConverter(result)

  def converter: Conversion[Input, Intermediate]
  def reverseConverter: Conversion[Intermediate, Input]
  def repository: RepositoryFacade[Intermediate, Intermediate]
