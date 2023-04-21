package com.github.dagmendez.runner.decorator

import com.github.dagmendez.runner.Runner

trait AbstractRunnerDecorator[Input, Output](runner: Runner[Input, Output]) extends Runner[Input, Output]
