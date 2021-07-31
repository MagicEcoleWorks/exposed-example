package kr.socar.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

class InsertComCodeGroupHistory

@JsonIgnoreProperties(ignoreUnknown = true)
data class InsertComCodeGroupHistoryParams(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("name")
    val name: String
)
