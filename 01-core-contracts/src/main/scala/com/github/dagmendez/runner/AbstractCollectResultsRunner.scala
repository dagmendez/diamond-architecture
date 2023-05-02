package com.github.dagmendez.runner

import com.github.dagmendez.command.Command

trait AbstractCollectResultsRunner[Input, Output] extends Runner[Input, Output]:
  val internal_results: Vector[Output]

  def addResult(result: Output): AbstractCollectResultsRunner[Input, Output]
  def addAllResults(moreResults: Vector[Output]): AbstractCollectResultsRunner[Input, Output]
  def removeResult(result: Output): AbstractCollectResultsRunner[Input, Output]

trait ConcurrentRunner[Input, Output] extends AbstractCollectResultsRunner[Input, Output]

trait ConsecutiveRunner[Input, Output] extends AbstractCollectResultsRunner[Input, Output]
