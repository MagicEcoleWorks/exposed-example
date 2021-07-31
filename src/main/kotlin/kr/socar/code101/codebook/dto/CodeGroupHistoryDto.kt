package kr.socar.code101.codebook.dto

import java.time.LocalDateTime

data class CodeGroupHistoryDto(
    val codeGroupId: String,
    val codeValidityStartDate: LocalDateTime,
    val codeValidityEndDate: LocalDateTime,
    val codeGroupName: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
