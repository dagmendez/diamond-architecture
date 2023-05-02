package com.github.dagmendez.pipeline

import com.github.dagmendez.command.Command
import com.github.dagmendez.reconciler.Reconciler
import com.github.dagmendez.runner.Runner

trait Pipeline[Input, Output]:
  def run(input: Input): Output

trait CommandPipeline[Input, Output] extends Pipeline[Input, Output]:
  val commands: Vector[Command[Input, Output]]
  def addCommand(command: Command[Input, Output]): CommandPipeline[Input, Output]
end CommandPipeline

trait DiamondPipeline[Input, Output] extends CommandPipeline[Input, Output]:
  val runner: Runner[Input, Output]
  val reconciler: Reconciler[Output]
end DiamondPipeline

trait ConcurrentPipeline[Input, Output] extends DiamondPipeline[Input, Output]

trait FlashPipeline[Input, Output] extends DiamondPipeline[Input, Output]

trait ConsecutivePipeline[Input, Output] extends DiamondPipeline[Input, Output]

trait SimplePipeline[Input, Output] extends ConsecutivePipeline[Input, Output]

trait TieredPipeline[Input, Output] extends DiamondPipeline[Input, Output]:
  val tieredPipelines: Vector[TieredPipeline[Input, Output]]
  
  def addTier(pipeline: Pipeline[Input, Output]): TieredPipeline[Input, Output]
end TieredPipeline

trait SimpleTieredPipeline[Input, Output] extends TieredPipeline[Input, Output]