package com.github.dagmendez.command

trait Command[Input, Output]:
  def execute(input: Input): Output
