package com.github.dagmendez.converter


trait Converter[InputFormat, OutputFormat]:
  def convert: InputFormat => OutputFormat
  def reverse(): Converter[OutputFormat, InputFormat]
