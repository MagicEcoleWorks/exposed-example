package kr.socar.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kr.socar.code101.codebook.model.ComCodeGroupEntity

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetComCodeGroupParams(
    @JsonProperty("code_group_id")
    val codeGroupId: String,
    @JsonProperty("upper_code_group_id")
    val upperCodeGroupId: String? = null,
    @JsonProperty("code_group_name")
    val codeGroupName: String? = null,
    @JsonProperty("code_group_description")
    val codeGroupDescription: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetComCodeGroupResult(
    @JsonProperty("com_code_group_list")
    val comCodeGroupEntityList: List<ComCodeGroupEntity>
)
