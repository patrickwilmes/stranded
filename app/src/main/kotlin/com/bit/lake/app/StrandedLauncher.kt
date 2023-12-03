package com.bit.lake.app

import com.bit.lake.core.Stranded
import com.bit.lake.gdx.ApplicationAdapter
import com.bit.lake.gdx.Configuration
import com.bit.lake.gdx.types.Vec2

fun main() {
    ApplicationAdapter.runAppUsingConfiguration(
        Stranded(),
        Configuration(
            size = Vec2(800f, 600f),
            title = "Stranded",
        )
    )
}
