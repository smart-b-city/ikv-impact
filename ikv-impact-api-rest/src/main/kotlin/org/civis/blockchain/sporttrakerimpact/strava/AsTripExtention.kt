package org.civis.blockchain.sporttrakerimpact.strava

import org.civis.blockchain.sporttrakerimpact.claim.GeoCoordinates
import org.civis.blockchain.sporttrakerimpact.claim.ItemList
import org.civis.blockchain.sporttrakerimpact.claim.ItemListElement
import org.civis.blockchain.sporttrakerimpact.claim.Trip
import org.civis.blockchain.sporttrakerimpact.strava.model.SummaryActivity

fun SummaryActivity.asTripClaim(): Trip {

    return Trip(
            departureTime = this.startDate,
            arrivalTime = this.startDate?.plusSeconds(this.elapsedTime ?: 0),
            itinerary = ItemListElement(numberOfItems = 2, itemListElement = arrayListOf(
                    ItemList(
                            position = 1,
                            item = GeoCoordinates(latitude = this.startLatlng!![0], longitude = this.startLatlng[1])
                    ),
                    ItemList(
                            position = 2,
                            item = GeoCoordinates(latitude = this.endLatlng!![0], longitude = this.endLatlng[1])
                    )
            ))
    )
}