package com.github.dagmendez.reconciler

trait Reconciler[Output]:
  def reconcile(results: Vector[Output]): Output


