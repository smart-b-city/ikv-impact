package org.civis.blockchain.sporttrakerimpact.strava

import org.civis.blockchain.sporttrakerimpact.strava.model.SummaryActivity
import retrofit2.http.*
import java.util.concurrent.CompletableFuture

interface StravaRepository {

    companion object {
        val baseUrl = "https://www.strava.com/"
    }

    @GET("/api/v3//athletes/{athleteId}/activities")
    fun activitiesByAthletes(
            @Header("Authorization") authorization: String,
            @Path("athleteId") athleteId: String
    ): CompletableFuture<List<SummaryActivity>>

}