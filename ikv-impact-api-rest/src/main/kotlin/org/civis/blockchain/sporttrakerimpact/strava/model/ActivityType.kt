package org.civis.blockchain.sporttrakerimpact.strava.model

import com.fasterxml.jackson.annotation.JsonValue


enum class ActivityType(@get:JsonValue val value: String){
    alpineSki("AlpineSki"),
    backcountrySki("BackcountrySki"),
    canoeing("Canoeing"),
    crossfit("Crossfit"),
    eBikeRide("EBikeRide"),
    elliptical("Elliptical"),
    golf("Golf"),
    handcycle("Handcycle"),
    hike("Hike"),
    iceSkate("IceSkate"),
    inlineSkate("InlineSkate"),
    kayaking("Kayaking"),
    kitesurf("Kitesurf"),
    nordicSki("NordicSki"),
    ride("Ride"),
    rockClimbing("RockClimbing"),
    rollerSki("RollerSki"),
    rowing("Rowing"),
    run("Run"),
    sail("Sail"),
    skateboard("Skateboard"),
    snowboard("Snowboard"),
    snowshoe("Snowshoe"),
    soccer("Soccer"),
    stairStepper("StairStepper"),
    standUpPaddling("StandUpPaddling"),
    surfing("Surfing"),
    swim("Swim"),
    velomobile("Velomobile"),
    virtualRide("VirtualRide"),
    virtualRun("VirtualRun"),
    walk("Walk"),
    weightTraining("WeightTraining"),
    wheelchair("Wheelchair"),
    windsurf("Windsurf"),
    workout("Workout"),
    yoga("Yoga");
}

