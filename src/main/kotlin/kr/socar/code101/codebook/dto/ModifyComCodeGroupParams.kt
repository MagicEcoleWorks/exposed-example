package kr.socar.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ModifyComCodeGroupParams(
    // 코드그룹ID
    @JsonProperty("code_group_id")
    val codeGroupId: String,
    // 코드그룹설명
    @JsonProperty("description")
    val description: String
)
