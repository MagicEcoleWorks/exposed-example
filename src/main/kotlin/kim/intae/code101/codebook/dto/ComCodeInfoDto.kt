package kim.intae.code101.codebook.dto

import kr.socar.code101.codebook.model.ComCodeInfoEntity
import java.time.format.DateTimeFormatter

data class ComCodeInfoDto(
    val codeId: String,
    val codeName: String,
    val createdAt: String,
    val updatedAt: String
) {
    constructor(comCodeInfoEntity: ComCodeInfoEntity) : this(
        codeId = comCodeInfoEntity.codeId,
        codeName = comCodeInfoEntity.codeName,
        createdAt = comCodeInfoEntity.createdAt.format(DateTimeFormatter.BASIC_ISO_DATE),
        updatedAt = comCodeInfoEntity.updatedAt.format(DateTimeFormatter.BASIC_ISO_DATE)
    )
}
