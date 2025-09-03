package io.handsone.core.controller

import io.handsone.core.repository.MemberRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController(
    private val memberRepository: MemberRepository
) {

    @GetMapping("/")
    fun index() = "Hello World!"

    @GetMapping("/hello")
    fun hello(@RequestParam name: String): String {
        val message = "Hello, $name!"
        println(message)
        return message
    }
}
