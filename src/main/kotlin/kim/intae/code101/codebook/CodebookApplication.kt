package kim.intae.code101.codebook

import kim.intae.code101.codebook.config.BaseConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(value = [BaseConfiguration::class])
class CodebookApplication

fun main(args: Array<String>) {
    runApplication<CodebookApplication>(*args)
}
