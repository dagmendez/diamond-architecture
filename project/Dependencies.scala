import sbt._
object Dependencies {

  object SbtPlugins {
    private val version: String = "0.6.0"
    val organizeImports: ModuleID = "com.github.liancheng" %% "organize-imports" % version
  }

  object org {
    object scalatest {
      val scalatest: ModuleID =
        "org.scalatest" %% "scalatest" % "3.2.16" % Test
    }

    object scalatestplus {
      val `scalacheck-1-15`: ModuleID =
        "org.scalatestplus" %% "scalacheck-1-15" % "3.2.11.0" % Test
    }
  }
}
