package com.github.dagmendez.command.decorator

import com.github.dagmendez.command.Command

trait SourceCommandDecorator[Input, Output](
  command: Command[Input, Output],
  source: String
) extends Command[Input, Output]