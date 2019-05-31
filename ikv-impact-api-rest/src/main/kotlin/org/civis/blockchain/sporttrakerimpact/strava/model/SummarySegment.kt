package org.civis.blockchain.sporttrakerimpact.strava.model

data class SummarySegment (   
        val id: Long? = null,    
        val name: String? = null, 
        val activityType: SummarySegment.ActivityType? = null,    
        val distance: Float? = null,   
        val averageGrade: Float? = null,   
        val maximumGrade: Float? = null,    
        val elevationHigh: Float? = null,    
        val elevationLow: Float? = null, 
        val startLatlng: LatLng? = null, 
        val endLatlng: LatLng? = null,    
        val climbCategory: Int? = null,    
        val city: String? = null, 
        val state: String? = null,    
        val country: String? = null,    
        val `private`: Boolean? = null,
        val athletePrEffort: SummarySegmentEffort? = null
) {
    enum class ActivityType(val value: String){
        ride("Ride"),
        run("Run");
    }
}
