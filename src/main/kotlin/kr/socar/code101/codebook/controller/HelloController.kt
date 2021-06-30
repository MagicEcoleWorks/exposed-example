package kr.socar.code101.codebook.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello(@RequestParam name: String?): String {
        return "Hello, ${name ?: "World"}!"
    }
}
