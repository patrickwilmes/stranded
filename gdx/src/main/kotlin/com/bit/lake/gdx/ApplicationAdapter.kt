package com.bit.lake.gdx

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

object ApplicationAdapter {
    fun runApp() {
        Lwjgl3Application(Game(), Lwjgl3ApplicationConfiguration())
    }
}
