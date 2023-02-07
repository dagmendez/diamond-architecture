package com.github.dagmendez.command

import com.github.dagmendez.converter.Converter
import com.github.dagmendez.repository.RepositoryFacade

trait Command[Input, Output]:
  def execute(input: Input): Output
