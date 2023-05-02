package com.github.dagmendez.runner.decorator

import com.github.dagmendez.runner.Runner

trait AbstractRunnerDecorator[Input, Output] extends Runner[Input, Output]:
  val runner: Runner[Input, Output]
end AbstractRunnerDecorator

