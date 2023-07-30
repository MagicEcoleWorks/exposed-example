package kim.intae.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateNewCodeParams(
    // code_id
    @JsonProperty("code_id")
    val codeId: String,
    // 코드명
    @JsonProperty("code_name")
    val codeName: String
)
