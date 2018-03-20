import org.gradle.kotlin.dsl.closureOf

buildscript {
   repositories {
      maven { url = uri("https://plugins.gradle.org/m2/") }
      mavenLocal()
   }

   dependencies {
      classpath "us.ihmc:ihmc-build:0.12.10"
   }
}
apply plugin: "us.ihmc.ihmc-build"

ihmc {
   group = "com.calvertsoftware"
   version = "0.0.1"
   vcsUrl = "https://github.com/calvertdw/example-website"
   
   configureDependencyResolution()
   configurePublications()
}

mainDependencies {

}

serverDependencies {
   compile(group to "org.mapdb", name to "mapdb", version to "3.0.5")
   compile group: "org.nanohttpd", name: "nanohttpd", version: "2.2.0"
}

testClientDependencies {
   compile group: "org.mashape.unirest", name: "unirest-java", version: "1.4.9"
}
