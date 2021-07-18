package kr.socar.code101.codebook.value

import kr.socar.code101.codebook.model.ComCodeInfoEntity

data class ComCode(val id: String, val name: String, val description: String?) {
    companion object {
        val DUMMY = ComCode("000", "__dummy_code__", "dummy code")
    }

    constructor(e: ComCodeInfoEntity) : this(e.id.value.toString(), e.codeName, e.description)
}
