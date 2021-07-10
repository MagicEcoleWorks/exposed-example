package kr.socar.code101.codebook.controller

import kr.socar.code101.codebook.repository.ComCodeInfoRepository
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val repository: ComCodeInfoRepository,
    private val database: Database
) {
    @GetMapping("/example")
    fun example(): String = transaction(database) {
        return@transaction repository.findAll()
            .joinToString { "id: ${it.id.value} name: ${it.codeName}<br />" }
    }
}
