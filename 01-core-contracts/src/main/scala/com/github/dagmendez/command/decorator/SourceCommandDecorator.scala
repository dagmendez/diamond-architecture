package com.github.dagmendez.command.decorator

import com.github.dagmendez.command.Command

trait SourceCommandDecorator[Input, Output] extends Command[Input, Output]:
  val command: Command[Input, Output]
  val source: String
end SourceCommandDecorator
