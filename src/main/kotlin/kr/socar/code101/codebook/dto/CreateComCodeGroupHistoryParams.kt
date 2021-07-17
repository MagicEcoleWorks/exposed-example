package kr.socar.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class CreateComCodeGroupHistoryParams(
    // 코드그룹ID
    @JsonProperty("code_group_id")
    val codeGroupId: String,
    // 코드유효시작일자
    // TODO 타입을 정해야 함 (ex. YYYY-MM-DD)
    @JsonProperty("code_validity_start_date")
    val codeValidityStartDate: String,
    // 코드유효종료일자
    // TODO 타입을 정해야 함 (ex. YYYY-MM-DD)
    @JsonProperty("code_validity_end_date")
    val codeValidityEndDate: String,
    // 변경전코드그룹명
    @JsonProperty("bfchg_code_group_name")
    val bfchgCodeGroupName: String,
    // 변경후코드그룹명
    @JsonProperty("aftch_code_group_name")
    val aftchCodeGroupName: String? = null
)
