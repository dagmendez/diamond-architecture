package com.github.dagmendez.command


trait CommandCallable[Input, Output](command: Command[Input, Output], input: Input):
  def call(): Output



