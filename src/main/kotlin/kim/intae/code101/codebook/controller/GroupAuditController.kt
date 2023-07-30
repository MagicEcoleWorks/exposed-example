package kim.intae.code101.codebook.controller

import kr.socar.code101.codebook.dto.CodeGroupHistoryDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GroupAuditController {
    @GetMapping("/audit/group_histories/{id}")
    fun listHistories(@PathVariable id: String): List<CodeGroupHistoryDto> {
        return emptyList()
    }
}
