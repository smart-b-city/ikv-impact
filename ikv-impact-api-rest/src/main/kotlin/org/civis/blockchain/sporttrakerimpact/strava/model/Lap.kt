package org.civis.blockchain.sporttrakerimpact.strava.model

data class Lap (
        val id: Long? = null,    
        val activity: MetaActivity? = null,    
        val athlete: MetaAthlete? = null,    
        val averageCadence: Float? = null,    
        val averageSpeed: Float? = null,    
        val distance: Float? = null,    
        val elapsedTime: Int? = null,    
        val startIndex: Int? = null,   
        val endIndex: Int? = null,   
        val lapIndex: Int? = null,    
        val maxSpeed: Float? = null,    
        val movingTime: Int? = null,   
        val name: String? = null,    
        val paceZone: Int? = null,    
        val split: Int? = null,   
        val startDate: java.time.LocalDateTime? = null,    
        val startDateLocal: java.time.LocalDateTime? = null,    
        val totalElevationGain: Float? = null
) {
}
