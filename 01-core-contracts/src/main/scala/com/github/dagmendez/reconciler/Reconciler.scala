package com.github.dagmendez.reconciler

trait Reconciler[Output]:
  def reconcile(results: Vector[Output]): Output

trait FirstNotNullResultReconciler[Output] extends Reconciler[Output]

trait FirstResultReconciler[Output] extends Reconciler[Output]

