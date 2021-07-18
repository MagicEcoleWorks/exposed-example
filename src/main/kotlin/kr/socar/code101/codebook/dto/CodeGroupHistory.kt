package kr.socar.code101.codebook.dto

import java.time.LocalDateTime

data class CodeGroupHistory(
    val id: String,
    val validityStartDate: LocalDateTime,
    val validityEndDate: LocalDateTime,
    val beforeName: String,
    val afterName: String,
    val createdAt: LocalDateTime
)
