package com.github.dagmendez.pipeline

import com.github.dagmendez.runner.Runner

trait DiamondPipeline[Input, Output] extends Pipeline[Input, Output]:
  override def run(input: Input): Output = runner.run(input)

  def runner: Runner[Input, Output]
