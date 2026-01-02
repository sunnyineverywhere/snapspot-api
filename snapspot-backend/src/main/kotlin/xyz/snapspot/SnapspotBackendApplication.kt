package xyz.snapspot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SnapspotBackendApplication

fun main(args: Array<String>) {
	runApplication<SnapspotBackendApplication>(*args)
}
