package kim.intae.code101.codebook.controller

import kim.intae.code101.codebook.dto.ComCodeGroupDto
import kim.intae.code101.codebook.dto.ComCodeInfoDto
import kim.intae.code101.codebook.dto.ComCodeView
import kim.intae.code101.codebook.dto.CreateComCodeGroupParams
import kim.intae.code101.codebook.dto.CreateComCodeParams
import kim.intae.code101.codebook.dto.CreateNewCodeParams
import kim.intae.code101.codebook.dto.ModifyComCodeGroupParams
import kim.intae.code101.codebook.model.ComCodeGroupEntity
import kim.intae.code101.codebook.service.ComCodeGroupService
import kim.intae.code101.codebook.service.ComCodeInfoService
import kim.intae.code101.codebook.value.CodeGroup
import kim.intae.code101.codebook.value.ComCode
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

// TODO: "admin"이므로 아무나 실행할 수 없도록 권한 설정을 해야 한다
@RestController
class AdminController(
    private val comCodeInfoService: ComCodeInfoService,
    private val comCodeGroupService: ComCodeGroupService
) {
    @PostMapping("/admin/codes")
    fun createNewCode(@RequestBody p: CreateNewCodeParams): ComCodeInfoDto {
        return comCodeInfoService.createNewCode(p)
    }

    @PutMapping("/admin/codes/all")
    fun getCode(): List<ComCodeInfoDto> {
        return comCodeInfoService.getCode()
    }

    @PostMapping("/admin/groups")
    fun createNewGroup(@RequestBody p: CreateComCodeGroupParams): ComCodeGroupEntity? {
        // create
        return comCodeGroupService.createCodeGroup(p)
    }

    @GetMapping("/admin/groups/findAll")
    fun findAll(): List<ComCodeGroupEntity> {
        // read
        return comCodeGroupService.findAll()
    }

    @PostMapping("/admin/groups/update")
    fun modifyGroup(@RequestBody p: ModifyComCodeGroupParams): ComCodeGroupDto? {
        return comCodeGroupService.modifyGroup(p)
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
