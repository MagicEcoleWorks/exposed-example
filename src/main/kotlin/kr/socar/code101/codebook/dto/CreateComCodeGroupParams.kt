package kr.socar.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class CreateComCodeGroupParams(
    // 코드그룹ID
    @JsonProperty("code_group_id")
    val codeGroupId: String,
    // 상위코드그룹ID
    @JsonProperty("upper_code_group_id")
    val upperCodeGroupId: String? = null,
    // 코드그룹명
    @JsonProperty("code_group_name")
    val codeGroupName: String,
    // 코드그룹설명
    @JsonProperty("code_group_description")
    val codeGroupDescription: String? = null
)
