package kr.socar.code101.codebook.controller

import kr.socar.code101.codebook.dto.ComCodeInfoDto
import kr.socar.code101.codebook.dto.ComCodeView
import kr.socar.code101.codebook.dto.CreateComCodeGroupParams
import kr.socar.code101.codebook.dto.CreateComCodeParams
import kr.socar.code101.codebook.dto.CreateNewCodeParams
import kr.socar.code101.codebook.service.ComCodeInfoService
import kr.socar.code101.codebook.value.CodeGroup
import kr.socar.code101.codebook.value.ComCode
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

// TODO: "admin"이므로 아무나 실행할 수 없도록 권한 설정을 해야 한다
@RestController
class AdminController(
    private val comCodeInfoService: ComCodeInfoService
) {
    @PostMapping("/admin/codes")
    fun createNewCode(@RequestBody p: CreateNewCodeParams): ComCodeInfoDto {
        return ComCodeInfoDto(comCodeInfoService.createNew(p))
    }

    @PutMapping("/admin/codes/{id}")
    fun renameCode(/* TODO: requestBody with code name, code description */): ComCode {
        return ComCode.DUMMY
    }

    @PostMapping("/admin/groups")
    fun createNewGroup(@RequestBody p: CreateComCodeGroupParams): CodeGroup {
        // create
        return CodeGroup.DUMMY
    }

    @PutMapping("/admin/groups/{id}")
    fun modifyGroup(/* TODO: requestBody with group name, group description, ... parent group? */): ComCode {
        return ComCode.DUMMY
    }

    @DeleteMapping("/admin/groups/{id}")
    fun deleteGroup(@PathVariable id: String): ComCode {
        // todo: 일괄 삭제는 생각하지 말고 개별 삭제만.
        // todo: 터미널 노드인 경우만 삭제 가능하게
        // todo: 주의사항! - com_code에 사용 중인 그룹인 경우, 어떻게 해야 하겠는가?
        return ComCode.DUMMY
    }

    @PostMapping("/admin/code_sets")
    fun createCodeSet(@RequestBody p: CreateComCodeParams): ComCodeView {
        return ComCodeView(CodeGroup.DUMMY, ComCode.DUMMY)
    }

    @DeleteMapping("/admin/code_sets/{id}")
    fun deleteCodeSet(@PathVariable id: String) {
    }
}
