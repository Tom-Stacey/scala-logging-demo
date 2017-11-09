import play.core.PlayVersion
import play.sbt.PlayImport._
import sbt._

object FrontendBuild extends Build with MicroService {

  val appName = "logging-demo"

  override lazy val appDependencies: Seq[ModuleID] = AppDependencies()
}

  private object AppDependencies {

  val compile = Seq(
    ws,
    "uk.gov.hmrc" %% "frontend-bootstrap" % "8.7.0",
    "uk.gov.hmrc" %% "play-partials" % "6.1.0",
    "uk.gov.hmrc" %% "http-caching-client" % "7.0.0"
  )

    trait TestDependencies {
      lazy val scope: String = "test"
      lazy val test: Seq[ModuleID] = ???
    }

    object Test {
      def apply(): Seq[ModuleID] = new TestDependencies {
        override lazy val test = Seq(
          "uk.gov.hmrc" %% "hmrctest" % "2.4.0" % scope,
          "org.scalatest" %% "scalatest" % "2.2.6" % scope,
          "org.pegdown" % "pegdown" % "1.6.0" % scope,
          "org.jsoup" % "jsoup" % "1.8.3" % scope,
          "com.typesafe.play" %% "play-test" % PlayVersion.current % scope,
          "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % scope,
          "org.mockito" % "mockito-core" % "2.6.2" % "test",
          "ch.qos.logback" % "logback-classic" % "1.2.3"
        )
      }.test
    }

    def apply(): Seq[ModuleID] = compile ++ Test()

}
