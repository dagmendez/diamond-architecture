package com.github.dagmendez.command

import com.github.dagmendez.repository.RepositoryFacade

trait Command[Input, Output]:
  def execute(input: Input): Output
end Command







