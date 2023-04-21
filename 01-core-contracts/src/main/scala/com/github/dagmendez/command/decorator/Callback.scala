package com.github.dagmendez.command.decorator

trait Callback[Finput, Foutput]:
  def apply(input:Finput):Foutput