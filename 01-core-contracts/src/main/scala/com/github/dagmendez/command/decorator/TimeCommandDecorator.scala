package com.github.dagmendez.command.decorator

import com.github.dagmendez.command.Command

trait TimeCommandDecorator[Input, Output] extends Command[Input, Output] with Callback[Long, Unit]:
  val command: Command[Input, Output]
  val callback: Callback[Long, Unit]
end TimeCommandDecorator
