package kr.socar.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class CreateComCodeParams(
    // 코드그룹ID, com_code_group.id
    @JsonProperty("code_group_id")
    val codeGroupId: String,
    // 코드ID, com_code_info.id
    @JsonProperty("code_id")
    val codeId: Int,
    // 사용여부
    @JsonProperty("use_yn")
    val useYn: Boolean,
    // 정렬번호 (코드그룹별 정렬번호를 생성)
    @JsonProperty("sorting_number")
    val sortingNumber: Int
)
