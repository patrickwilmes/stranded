package com.bit.lake.gdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.bit.lake.gdx.debug.DebugOptions
import com.bit.lake.gdx.debug.info

abstract class GDXApplication : ApplicationAdapter() {
    override fun create() {
        if (isDebug()) {
            info(this::class.java, "Debug mode enabled!")
        } else {
            info(this::class.java, "Debug mode disabled!")
        }
    }

    protected fun escapeToQuitInDebug() {
        if (isDebug()) {
            if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
                Gdx.app.exit()
            }
        }
    }

    private fun isDebug(): Boolean = DebugOptions.isDebugModeEnabled()
}
