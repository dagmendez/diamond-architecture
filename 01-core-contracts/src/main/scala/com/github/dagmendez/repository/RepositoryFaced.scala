package com.github.dagmendez.repository

trait RepositoryFacade[ConvertedInput, Result]:
  def run(input: ConvertedInput): Result