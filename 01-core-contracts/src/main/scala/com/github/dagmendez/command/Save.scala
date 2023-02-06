package com.github.dagmendez.command

import com.github.dagmendez.converter.Converter
import com.github.dagmendez.repository.RepositoryFacade

trait Save[Input, Intermediate] extends Command[Input, Input]:
 
  override def execute(input: Input): Input =
    val converted: Intermediate = converter.convert(input)
    val result: Intermediate = repository.run(converted)
    converter.reverse().convert(result)

  lazy val converter: Converter[Input, Intermediate]
  lazy val repository: RepositoryFacade[Intermediate, Intermediate]