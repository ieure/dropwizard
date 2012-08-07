package com.yammer.dropwizard

import config.Configuration
import bundles.ScalaBundle
import com.simple.jerkson.ScalaModule

abstract class ScalaService[T <: Configuration](name: String) extends AbstractService[T](name) {
  addBundle(new ScalaBundle(this))
  addJacksonModule(new DefaultScalaModule)
  override final def subclassServiceInsteadOfThis() {}

  final def main(args: Array[String]) {
    run(args)
  }

  def withBundle(bundle: Bundle) {
    addBundle(bundle)
  }

  def withBundle(bundle: ConfiguredBundle[_ >: T]) {
    addBundle(bundle)
  }
}

