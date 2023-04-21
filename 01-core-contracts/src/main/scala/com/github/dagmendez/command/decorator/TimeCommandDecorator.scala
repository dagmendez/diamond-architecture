package com.github.dagmendez.command.decorator

import com.github.dagmendez.command.Command

trait TimeCommandDecorator[Input, Output](
  command: Command[Input, Output],
  callback: Callback[Long, Unit]
) extends Command[Input, Output] with Callback[Long, Unit]