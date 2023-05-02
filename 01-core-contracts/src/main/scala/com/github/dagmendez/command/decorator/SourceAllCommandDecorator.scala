package com.github.dagmendez.command.decorator

import com.github.dagmendez.command.Command

trait SourceAllCommandDecorator[Input, Output] extends Command[Input, Vector[Output]]:
  val command: Command[Input, Vector[Output]]
  val source: String
end SourceAllCommandDecorator
