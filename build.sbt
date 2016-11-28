name := "FunctionalProgrammingInScalaBook"

version := "1.0"

scalaVersion := "2.12.0"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "junit" % "junit" % "4.12" % "test"
//  "org.specs2" %% "specs2-core" % "3.8.6" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")