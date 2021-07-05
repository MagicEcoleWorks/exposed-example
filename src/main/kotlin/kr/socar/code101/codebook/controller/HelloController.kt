package kr.socar.code101.codebook.controller

import kr.socar.code101.codebook.repository.ComCodeInfoRepository
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val repository: ComCodeInfoRepository,
    private val database: Database
) {
    @GetMapping("/example")
    fun example(): String = transaction(database) {
//        val result = repository.findAll()
//        var x = ""
//        for (each in result) {
//            x += "id: ${each.id.value} name: ${each.codeName}<br />"
//        }

//        return@transaction x
        return@transaction repository.findAll()
            .joinToString { "id: ${it.id.value} name: ${it.codeName}<br />" }
    }

    @GetMapping("/insert")
    fun insert(
        @RequestParam("n") name: String,
        @RequestParam("d") desc: String?
    ): String = transaction(database) {
        val r = repository.insert(name, desc)
        return@transaction "id: ${r.id.value}, name: ${r.codeName}, created: ${r.createdAt}"
    }
}
