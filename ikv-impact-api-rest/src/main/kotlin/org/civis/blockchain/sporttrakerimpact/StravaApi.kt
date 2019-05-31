package org.civis.blockchain.sporttrakerimpact

import org.civis.blockchain.sporttrakerimpact.claim.VerifiableClaimService
import org.civis.blockchain.sporttrakerimpact.strava.StravaRepository
import org.civis.blockchain.sporttrakerimpact.strava.asTripClaim
import org.civis.blockchain.sporttrakerimpact.strava.model.SummaryActivity
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.concurrent.CompletableFuture

@RestController
class StravaApi(val stravaRepository: StravaRepository,
                val verifiableClaimService: VerifiableClaimService) {

    @GetMapping("/strava/activities")
    fun get(@RegisteredOAuth2AuthorizedClient("strava")
            oauth2Client: OAuth2AuthorizedClient): CompletableFuture<List<SummaryActivity>> {
        return stravaRepository.activitiesByAthletes("Bearer " + oauth2Client.accessToken.tokenValue, "42468774")
    }

    @GetMapping("/strava/proof")
    fun trace(@RegisteredOAuth2AuthorizedClient("strava")
              oauth2Client: OAuth2AuthorizedClient): CompletableFuture<List<LinkedHashMap<String, Any>>>? {
        val activities = stravaRepository.activitiesByAthletes("Bearer " + oauth2Client.accessToken.tokenValue, "42468774")
        return activities.thenApplyAsync {
            it.map {
                val claim = it.asTripClaim()
                verifiableClaimService.sign(claim)
            }
        }
    }

}