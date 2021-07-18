package kr.socar.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kr.socar.code101.codebook.model.ComCodeGroupHistoryEntity

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetComCodeGroupHistoryParams(
    @JsonProperty("code_group_id")
    val codeGroupId: String,
    @JsonProperty("code_validity_start_date")
    val codeValidityStartDate: String? = null,
    @JsonProperty("code_validity_end_date")
    val codeValidityEndDate: String? = null,
    @JsonProperty("bfchg_code_group_name")
    val bfchgCodeGroupName: String? = null,
    @JsonProperty("aftch_code_group_name")
    val aftchCodeGroupName: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetComCodeGroupHistoryResult(
    @JsonProperty("com_code_group_history_list")
    val comCodeGroupHistoryEntityList: List<ComCodeGroupHistoryEntity>
)
