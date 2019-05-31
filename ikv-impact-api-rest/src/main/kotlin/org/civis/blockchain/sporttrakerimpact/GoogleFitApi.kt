package org.civis.blockchain.sporttrakerimpact

import com.google.api.client.auth.oauth2.BearerToken
import com.google.api.client.auth.oauth2.Credential

import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.services.fitness.Fitness
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.fitness.FitnessRequestInitializer
import com.google.api.services.fitness.model.ListSessionsResponse

@RestController
class GoogleFitApi {

    @GetMapping("/google/activities")
    fun get(@RegisteredOAuth2AuthorizedClient("google")
            client: OAuth2AuthorizedClient): ListSessionsResponse {

        val httpTransport = GoogleNetHttpTransport.newTrustedTransport()
        val jsonFactory = JacksonFactory()
        val credential = Credential(BearerToken.authorizationHeaderAccessMethod())
                .setAccessToken(client.accessToken.tokenValue)
//                .setRefreshToken(client.refreshToken!!.tokenValue)

        val fit = Fitness.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName("SmartB IKV Tracker")
                .setFitnessRequestInitializer(FitnessRequestInitializer())
                .build()
        val listSource = fit.users().dataSources().list("me").execute()
        fit.users().sessions()
        val listSession = fit.users().sessions().list("me")
                .execute()
        return listSession;
    }
}