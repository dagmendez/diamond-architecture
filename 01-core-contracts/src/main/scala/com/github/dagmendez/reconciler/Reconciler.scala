package com.github.dagmendez.reconciler

trait Reconciler[Output]:
  def reconcile(results: Vector[Output]): Output

trait FirstNotNullResultReconciler[T] extends Reconciler[T]

trait FirstResultReconciler[T] extends Reconciler[T]

