package kr.socar.code101.codebook.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kr.socar.code101.codebook.model.ComCodeInfoEntity
import java.time.format.DateTimeFormatter

data class CreateNewCodeParams(
    // code_id
    @JsonProperty("code_id")
    val codeId: String,
    // 코드명
    @JsonProperty("code_name")
    val codeName: String
)

data class CreateNewCodeResult(
    // code_id
    @JsonProperty("code_id")
    val codeId: String,
    // 코드명
    @JsonProperty("code_name")
    val codeName: String,
    @JsonProperty("created_at")
    val createdAt: String,
    @JsonProperty("updated_at")
    val updatedAt: String
) {
    constructor(comCodeInfoEntity: ComCodeInfoEntity) : this(
        codeId = comCodeInfoEntity.codeId,
        codeName = comCodeInfoEntity.codeName,
        createdAt = comCodeInfoEntity.createdAt.format(DateTimeFormatter.BASIC_ISO_DATE),
        updatedAt = comCodeInfoEntity.updatedAt.format(DateTimeFormatter.BASIC_ISO_DATE)
    )
}
