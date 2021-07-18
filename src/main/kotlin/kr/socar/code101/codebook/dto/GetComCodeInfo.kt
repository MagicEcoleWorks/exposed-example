package kr.socar.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kr.socar.code101.codebook.model.ComCodeInfoEntity

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetComCodeInfoParams(
    @JsonProperty("code_name")
    val codeName: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetComCodeInfoResult(
    @JsonProperty("com_code_info")
    val comCodeInfoEntity: ComCodeInfoEntity?
)
