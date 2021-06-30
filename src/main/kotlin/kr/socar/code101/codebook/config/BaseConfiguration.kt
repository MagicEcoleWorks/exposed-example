package kr.socar.code101.codebook.config

import com.google.common.util.concurrent.ThreadFactoryBuilder
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import java.time.Clock
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

@Configuration
@EnableConfigurationProperties()
@ComponentScan("kr.socar.code101", excludeFilters = [])
@PropertySource("classpath:/redundant.properties")
class BaseConfiguration {
    @Bean
    fun clock() = Clock.systemUTC()

    @Bean
    fun workerDispatcher(): CoroutineDispatcher {
        val workerExecutor = ThreadPoolExecutor(
            100,
            200,
            10,
            TimeUnit.SECONDS,
            LinkedBlockingQueue(),
            ThreadFactoryBuilder().setNameFormat("CoroutineWorker-%d").build()
        ).apply { allowCoreThreadTimeOut(true) }
        return workerExecutor.asCoroutineDispatcher()
    }
}
