scalaVersion := "3.4.2"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "dev.zio" %% "zio" % "2.1.1"
libraryDependencies += "dev.zio" %% "zio-http" % "3.0.0-RC8"

libraryDependencies += "dev.zio" %% "zio-test" % "2.1.1" % Test
libraryDependencies += "dev.zio" %% "zio-mock" % "1.0.0-RC12" % Test
