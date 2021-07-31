package kr.socar.code101.codebook.value

data class ComCode(val id: String, val name: String, val description: String?) {
    companion object {
        val DUMMY = ComCode("000", "__dummy_code__", "dummy code")
    }

    // TODO 나중에 파악하고 삭제
//    constructor(e: ComCodeInfoEntity) : this(e.id.value.toString(), e.codeName, e.description)
}
