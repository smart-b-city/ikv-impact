package org.civis.blockchain.sporttrakerimpact.strava.model

data class DetailedSegmentEffort (
        val name: String? = null,
        val activity: MetaActivity? = null,
        val athlete: MetaAthlete? = null,
        val movingTime: Int? = null,
        val startIndex: Int? = null,
        val endIndex: Int? = null,
        val averageCadence: Float? = null,
        val averageWatts: Float? = null,
        val deviceWatts: Boolean? = null,
        val averageHeartrate: Float? = null,
        val maxHeartrate: Float? = null,
        val segment: SummarySegment? = null,
        val komRank: Int? = null,
        val prRank: Int? = null,
        val hidden: Boolean? = null,
        val id: Long? = null,
        val elapsedTime: Int? = null,
        val startDate: java.time.LocalDateTime? = null,
        val startDateLocal: java.time.LocalDateTime? = null,
        val distance: Float? = null,
        val isKom: Boolean? = null
) {
}
