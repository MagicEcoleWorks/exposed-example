package kr.socar.code101.codebook.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import java.time.Clock

@Configuration
@EnableConfigurationProperties()
@ComponentScan("kr.socar.code101", excludeFilters = [])
class BaseConfiguration {
    @Bean
    fun clock() = Clock.systemUTC()

//    @Bean
//    fun workerDispatcher(): CoroutineDispatcher {
//        val workerExecutor = ThreadPoolExecutor(
//            100,
//            200,
//            10,
//            TimeUnit.SECONDS,
//            LinkedBlockingQueue(),
//            ThreadFactoryBuilder().setNameFormat("CoroutineWorker-%d").build()
//        ).apply { allowCoreThreadTimeOut(true) }
//        return workerExecutor.asCoroutineDispatcher()
//    }
}
