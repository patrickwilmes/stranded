package com.bit.lake.gdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.bit.lake.gdx.debug.debug
import com.bit.lake.gdx.debug.info
import com.bit.lake.gdx.input.Key
import com.bit.lake.gdx.input.ifKeyPressed

abstract class GDXApplication : ApplicationAdapter() {
    override fun create() {
        debug {
            info(this::class.java, "Debug mode enabled!")
        }
    }

    protected fun escapeToQuitInDebug() {
        debug {
            Key.ESCAPE.ifKeyPressed {
                Gdx.app.exit()
            }
        }
    }
}
