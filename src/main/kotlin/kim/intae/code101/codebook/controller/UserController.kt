package kim.intae.code101.codebook.controller

import kr.socar.code101.codebook.dto.ComCodeView
import kr.socar.code101.codebook.service.ComCodeService
import kr.socar.code101.codebook.value.CodeGroup
import kr.socar.code101.codebook.value.ComCode
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val service: ComCodeService) {
    private val dummy = ComCodeView(CodeGroup.DUMMY, ComCode.DUMMY)

    @GetMapping("/code_set/{groupName}")
    fun fetchCodeSetByGroupCode(@PathVariable groupName: String): List<ComCodeView> {
        return listOf(dummy, dummy)
    }

    @GetMapping("/code/{codeName}")
    fun fetchSingleCode(@PathVariable codeName: String): ComCodeView? {
        return dummy
    }
}
