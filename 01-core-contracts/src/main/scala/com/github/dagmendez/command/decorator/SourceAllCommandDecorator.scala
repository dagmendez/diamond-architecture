package com.github.dagmendez.command.decorator

import com.github.dagmendez.command.Command



trait SourceAllCommandDecorator[Input, Output](
  command: Command[Input, Vector[Output]],
  source: String
) extends Command[Input, Vector[Output]]





