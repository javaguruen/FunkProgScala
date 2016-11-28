name := "FunctionalProgrammingInScalaBook"

version := "1.0"

scalaVersion := "2.12.0"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")