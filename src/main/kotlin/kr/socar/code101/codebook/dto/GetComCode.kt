package kr.socar.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kr.socar.code101.codebook.model.ComCode

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetComCodeParams(
    @JsonProperty("code_group_id")
    val codeGroupId: String? = "",
    @JsonProperty("code_id")
    val codeId: Int? = -1,
    @JsonProperty("use_yn")
    val useYn: Boolean? = false,
    @JsonProperty("sorting_number")
    val sortingNumber: Int? = -1
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetComCodeResult(
    @JsonProperty("com_code_list")
    val comCodeList: List<ComCode>
)
