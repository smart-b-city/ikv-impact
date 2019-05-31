package org.civis.blockchain.sporttrakerimpact.strava.model


data class SummarySegmentEffort (    /* The unique identifier of this effort */    val id: kotlin.Long? = null,    /* The effort's elapsed time */    val elapsedTime: kotlin.Int? = null,    /* The time at which the effort was started. */    val startDate: java.time.LocalDateTime? = null,    /* The time at which the effort was started in the local timezone. */    val startDateLocal: java.time.LocalDateTime? = null,    /* The effort's distance in meters */    val distance: kotlin.Float? = null,    /* Whether this effort is the current best on the leaderboard */    val isKom: kotlin.Boolean? = null
) {
}
