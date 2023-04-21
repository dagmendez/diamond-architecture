package com.github.dagmendez.pipeline

import com.github.dagmendez.command.Command
import com.github.dagmendez.reconciler.Reconciler
import com.github.dagmendez.runner.Runner

trait Pipeline[Input, Output]:
  def run(input: Input): Output

trait CommandPipeline[Input, Output](commands: Vector[Command[Input, Output]]) extends Pipeline[Input, Output]:
  def addCommand(command: Command[Input, Output]): CommandPipeline[Input, Output]

trait DiamondPipeline[Input, Output](runner: Runner[Input, Output], reconciler: Reconciler[Output])
  extends CommandPipeline[Input, Output]

trait ConcurrentPipeline[Input, Output](reconciler: Reconciler[Output]) extends DiamondPipeline[Input, Output]

trait FlashPipeline[Input, Output] extends DiamondPipeline[Input, Output]

trait ConsecutivePipeline[Input, Output](reconciler: Reconciler[Output]) extends DiamondPipeline[Input, Output]

trait SimplePipeline[Input, Output] extends ConsecutivePipeline[Input, Output]

trait TieredPipeline[Input, Output](
  runner: Runner[Input, Output],
  reconciler: Reconciler[Output],
  tieredPipelines: Vector[TieredPipeline[Input, Output]]
) extends DiamondPipeline[Input, Output]:
  def addTier(pipeline: Pipeline[Input, Output]): TieredPipeline[Input, Output]

trait SimpleTieredPipeline[Input, Output] extends TieredPipeline[Input, Output]
