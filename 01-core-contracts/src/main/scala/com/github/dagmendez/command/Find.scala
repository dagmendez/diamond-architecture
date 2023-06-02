package com.github.dagmendez.command

import com.github.dagmendez.converter.Converter

trait Find[Input, Intermediate, Output, Query] extends Command[Input, Output]:
  override def execute(input: Input): Output =
    val key: Query = generator.apply(input)
    val result: Intermediate = callback.apply(key)
    valueConverter.reverse().convert(result)

  lazy val generator: Input => Query
  lazy val callback: Query => Intermediate
  lazy val valueConverter: Converter[Output, Intermediate]
