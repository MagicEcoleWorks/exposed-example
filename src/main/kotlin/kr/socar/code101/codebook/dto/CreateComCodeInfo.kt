package kr.socar.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class CreateComCodeInfoParams(
    // 코드명
    @JsonProperty("code_name")
    val codeName: String,
    // 코드에 대한 설명
    @JsonProperty("description")
    val description: String? = null
)
