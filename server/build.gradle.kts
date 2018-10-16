plugins {
   kotlin("jvm") version "1.2.31"
}

repositories {
   mavenCentral()
   jcenter()
   mavenLocal()
}

//java.sourceSets["server"].java.srcDirs("src/server/kotlin")

dependencies {
   implementation(kotlin("stdlib", "1.2.31"))
   compile("org.mapdb:mapdb:3.0.5")
   compile("org.nanohttpd:nanohttpd:2.3.1")
   compile("org.nanohttpd:nanohttpd-websocket:2.3.1")
//    compile("com.mashape.unirest:unirest-java:1.4.9")
   compile("org.jetbrains.kotlinx:kotlinx-html-jvm:0.6.10")
}
