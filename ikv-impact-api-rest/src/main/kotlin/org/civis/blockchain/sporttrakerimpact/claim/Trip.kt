package org.civis.blockchain.sporttrakerimpact.claim

import java.time.LocalDateTime
import java.util.*

//{
//  "@context":"http://schema.org",
//  "@type":"itinerary",
//  "itinerary":{
//    "@type":"ItemList",
//    "numberOfItems":2,
//    "itemListElement":[
//      {
//        "@type":"ListItem",
//        "position":1,
//        "item":{
//          "@type":"GeoCoordinates",
//          "latitude":"40.75",
//          "longitude":"73.98"
//        }
//      },{
//        "@type":"ListItem",
//        "position":2,
//        "item":{
//          "@type":"GeoCoordinates",
//          "latitude":"40.75",
//          "longitude":"73.98"
//        }
//      }
//    ]
//  }
//}
data class Trip(
        val `@context`: String = "http://schema.org",
        val `@type`: String = "Trip",
        val departureTime: LocalDateTime?,
        val arrivalTime: LocalDateTime?,
        val itinerary: ItemListElement<GeoCoordinates>
) : Claim

data class ItemListElement<T>(
        val `@type`: String = "ItemList",
        val numberOfItems: Int,
        val itemListElement: ArrayList<ItemList<T>>
)

data class ItemList<T>(
        val `@type`: String = "ListItem",
        val position: Int, val item: T
)

data class GeoCoordinates(
        val `@type`: String = "GeoCoordinates",
        val latitude: Float,
        val longitude: Float
)