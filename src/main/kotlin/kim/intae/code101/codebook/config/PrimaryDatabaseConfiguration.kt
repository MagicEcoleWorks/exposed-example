package kim.intae.code101.codebook.config

import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
class PrimaryDatabaseConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    fun dataSourceProperties() = DataSourceProperties()

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.hikari")
    fun dataSource(): DataSource = dataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource::class.java).build()

    @Bean
    @Primary
    fun database(dataSource: DataSource) = Database.connect(dataSource)
}
