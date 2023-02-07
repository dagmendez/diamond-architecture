package com.github.dagmendez.pipeline

import com.github.dagmendez.runner.Runner
import com.github.dagmendez.reconciler.Reconciler

trait DiamondPipeline[Input, Output] extends Pipeline[Input, Output]:
  override def run(input: Input): Output = runner.run(input)

  lazy val runner: Runner[Input, Output]
