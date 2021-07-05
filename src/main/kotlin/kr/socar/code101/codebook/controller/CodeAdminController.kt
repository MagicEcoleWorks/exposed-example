package kr.socar.code101.codebook.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CodeAdminController {

    @GetMapping("/com_code_info/new")
    fun createNewComCodeInfo(
        @RequestParam("code_name") codeName: String,
        @RequestParam description: String?
    ): String {
        return """{"code_id":1, "code_name":"first_code", "description":"The 1st Code" }"""
    }

    @GetMapping("/com_code_info/list")
    fun fetchComCodeInfo(): String {
        return """[
            |{"code_id":1, "code_name":"first_code", "description":"The 1st Code" },
            |{"code_id":2, "code_name":"second_code", "description":"The 2nd Code" },
            |{"code_id":3, "code_name":"third_code", "description":"The 3rd Code" }
            |]""".trimMargin()
    }

    @GetMapping("/com_code_info/each")
    fun fetchComCodeInfo(@RequestParam id: Int): String {
        return """{"code_id":1, "code_name":"first_code", "description":"The 1st Code" }"""
    }

    @GetMapping("/com_code_info/update")
    fun modifyComCodeInfo(
        @RequestParam id: Int,
        @RequestParam description: String?
    ): String {
        return """{"code_id":1, "code_name":"first_code", "description":"The 1st Code" }"""
    }

    @GetMapping("/com_code_group/new")
    fun createNewComCodeGroup(
        @RequestParam("name") codeGroupName: String,
        @RequestParam description: String?
    ): String {
        return """{"code_group_id":1, "upper_code_group_id":null, "code_group_name":"first_code_group", "code_group_description":"The 1st Code Group" }"""
    }

    @GetMapping("/com_code_group/list")
    fun fetchComCodeGroupInfo(): String {
        return """[
            |{...},
            |{...},
            |{...}
            |]""".trimMargin()
    }

    @GetMapping("/com_code_group/each")
    fun fetchComCodeGroupInfo(@RequestParam id: Int): String {
        return """{...}"""
    }

    @GetMapping("/com_code_info/update")
    fun createNewComCodeInfo(
        @RequestParam id: Int,
        @RequestParam description: String?
    ): String {
        return """{...}"""
    }
}
