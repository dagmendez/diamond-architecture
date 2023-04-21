package com.github.dagmendez.runner

import com.github.dagmendez.command.Command
trait Runner[Input, Output]:
  def run(commands: Vector[Command[Input, Output]], input: Input): Output

trait ChainedConsecutiveRunner[Input] extends Runner[Input, Input]

trait TakeFirstNotNullResultConcurrentRunner[Input, Output] extends Runner[Input, Output]
