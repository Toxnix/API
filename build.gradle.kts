plugins {
	java
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "de.bacherik"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
	maven {
		url = uri("https://artifactory.bytemc.de/artifactory/bytemc-public/")
	}
	maven() {
		url = uri("https://jitpack.io")
	}
}

dependencies {
	// SimplixStorage
	implementation("com.github.simplix-softworks:SimplixStorage:3.2.7")

	// evelon
	implementation("net.bytemc:evelon:1.5.0")
	testImplementation("net.bytemc:evelon:1.5.0")

	// spring
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// Lombok
	compileOnly("org.projectlombok:lombok:1.18.30")
	annotationProcessor("org.projectlombok:lombok:1.18.30")

	// gson
	implementation("com.google.code.gson:gson:2.10.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
