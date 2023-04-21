package com.github.dagmendez.command


trait CommandCallable[Input, Output]:
  def commandCallable(
    command: Command[Input, Output],
    input: Input): Command[Input, Output]
  def call(): Output



