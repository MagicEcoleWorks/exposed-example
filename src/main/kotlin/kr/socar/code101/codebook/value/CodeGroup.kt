package kr.socar.code101.codebook.value

data class CodeGroup(
    val id: String,
    val name: String,
    val description: String?,
    private val parent: CodeGroup? = null,
) {
    companion object {
        val DUMMY = CodeGroup("000", "__dummy_group__", "dummy group")
    }

    fun isTopLevel() = parent == null
}
