package com.github.dagmendez.command


trait CommandCallable[Input, Output]:
  val command: Command[Input, Output]
  val input: Input
  
  def call(): Output
end CommandCallable
