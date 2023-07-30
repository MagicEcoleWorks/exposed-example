package kim.intae.code101.codebook.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import java.time.Clock

@Configuration
@EnableConfigurationProperties()
@ComponentScan("kim.intae.code101", excludeFilters = [])
class BaseConfiguration {
    @Bean
    fun clock() = Clock.systemUTC()
}
