package kim.intae.code101.codebook.dto

import kr.socar.code101.codebook.model.ComCodeGroupEntity
import java.time.format.DateTimeFormatter

data class ComCodeGroupDto(
    val codeGroupId: String,
    val codeGroupName: String,
    val parentCodeGroupId: String?,
    val description: String?,
    val createdAt: String,
    val updatedAt: String
) {
    constructor(ComCodeGroupEntity: ComCodeGroupEntity) : this(
        codeGroupId = ComCodeGroupEntity.codeGroupId,
        codeGroupName = ComCodeGroupEntity.codeGroupName,
        parentCodeGroupId = ComCodeGroupEntity.codeGroupName,
        description = ComCodeGroupEntity.description,
        createdAt = ComCodeGroupEntity.createdAt.format(DateTimeFormatter.BASIC_ISO_DATE),
        updatedAt = ComCodeGroupEntity.updatedAt.format(DateTimeFormatter.BASIC_ISO_DATE)

    )
}
