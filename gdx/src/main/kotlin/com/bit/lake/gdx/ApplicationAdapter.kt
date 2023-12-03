package com.bit.lake.gdx

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.bit.lake.gdx.game.Game

object ApplicationAdapter {
    fun runAppUsingConfiguration(configuration: Configuration) {
        Lwjgl3Application(Game(), Lwjgl3ApplicationConfiguration().apply {
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
