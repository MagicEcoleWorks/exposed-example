package kim.intae.code101.codebook.value

data class CodeGroup(
    val id: String,
    val name: String,
    val description: String?,
    private val parent: CodeGroup? = null,
) {
    companion object {
        val DUMMY = CodeGroup("000", "__dummy_group__", "dummy group")
    }

    // TODO 나중에 파악하고 삭제
    fun isTopLevel() = parent == null
}
