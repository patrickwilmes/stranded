package com.bit.lake.gdx

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.bit.lake.gdx.game.GameAdapter

object ApplicationAdapter {
    fun runAppUsingConfiguration(gameAdapter: GameAdapter, configuration: Configuration) {
        Lwjgl3Application(gameAdapter, Lwjgl3ApplicationConfiguration().apply {
            setTitle(configuration.title)
            setWindowedMode(configuration.size.x.toInt(), configuration.size.y.toInt())
            setWindowPosition(
                configuration.positionAsVec2.x.toInt(),
                configuration.positionAsVec2.y.toInt()
            )
            setForegroundFPS(configuration.foregroundFPS)
        })
    }
}
