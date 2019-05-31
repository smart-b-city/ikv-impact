package org.civis.blockchain.sporttrakerimpact.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository

@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun configure(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http.authorizeExchange()
                .pathMatchers("/impact").permitAll()
                .anyExchange().authenticated()
                .and().oauth2Login()
                .and().build()
    }

    @Bean
    fun webClient(clientRegistrationRepo: ReactiveClientRegistrationRepository,
                  authorizedClientRepo: ServerOAuth2AuthorizedClientRepository): WebClient {
        val filter = ServerOAuth2AuthorizedClientExchangeFilterFunction(clientRegistrationRepo, authorizedClientRepo)
        return WebClient.builder().filter(filter).build()
    }
}