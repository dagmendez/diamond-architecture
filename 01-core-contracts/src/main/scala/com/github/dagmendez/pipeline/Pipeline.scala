package com.github.dagmendez.pipeline

import com.github.dagmendez.reconciler.Reconciler

trait Pipeline[Input, Output] extends Reconciler[Output]:
  def run(input: Input): Output
  
  
