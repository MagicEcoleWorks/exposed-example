package kim.intae.code101.codebook.dto

enum class ResultCode(val code: String, val message: String) {
    SUCCESS("000", "성공"),
    FAIL("001", "실패"),
}
