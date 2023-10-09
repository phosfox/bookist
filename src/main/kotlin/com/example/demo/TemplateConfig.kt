package com.example.demo

import gg.jte.ContentType
import gg.jte.TemplateEngine
import gg.jte.resolve.DirectoryCodeResolver
import gg.jte.springframework.boot.autoconfigure.JteViewResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.nio.file.Path
import java.nio.file.Paths

@Configuration
class TemplateConfig {
    @Bean
    fun jteViewResolver(templateEngine: TemplateEngine): JteViewResolver {
        return JteViewResolver(templateEngine, ".jte")
    }

    @Bean
    fun templateEngine(): TemplateEngine {
        val profile = System.getenv("SPRING_ENV")
        return if ("prod" == profile) {
            TemplateEngine.createPrecompiled(ContentType.Html)
        } else {
            val codeResolver = DirectoryCodeResolver(Path.of("src", "main", "kotlin"))

            val templateEngine =
                TemplateEngine.create(codeResolver, Paths.get("jte-classes"), ContentType.Html, javaClass.classLoader)
            templateEngine.setBinaryStaticContent(true)
            templateEngine
        }
    }
}