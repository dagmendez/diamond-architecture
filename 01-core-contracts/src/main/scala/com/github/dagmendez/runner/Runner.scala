package com.github.dagmendez.runner

trait Runner[Input, Output]:
  def run(input: Input): Output
  def addResult(convertedResult: Output): Output
