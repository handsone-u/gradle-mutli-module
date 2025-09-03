package io.handsone.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("io.handsone.domain.entity")
class CoreApplication

fun main(args: Array<String>) {
    runApplication<CoreApplication>(*args)
}
