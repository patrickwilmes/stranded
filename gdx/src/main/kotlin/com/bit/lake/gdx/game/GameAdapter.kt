package com.bit.lake.gdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Matrix4
import com.bit.lake.gdx.debug.debug
import com.bit.lake.gdx.debug.info
import com.bit.lake.gdx.input.Key
import com.bit.lake.gdx.input.ifKeyPressed

abstract class GameAdapter : ApplicationAdapter() {
    private lateinit var spriteBatch: SpriteBatch

    override fun create() {
        debug {
            info(this::class.java, "Debug mode enabled!")
        }
        spriteBatch = SpriteBatch()

        initialize()
    }

    override fun render() {
        escapeToQuitInDebug()
        onUpdate()
        spriteBatch.begin()
        handleSprites {
            spriteBatch.projectionMatrix = it
        }
        spriteBatch.end()
    }

    override fun dispose() {
        spriteBatch.dispose()
    }

    protected abstract fun onUpdate()
    protected abstract fun handleSprites(projectionMatrixFunc: (Matrix4) -> Unit)
    protected abstract fun initialize()

    protected fun draw(texture: Texture, x: Float, y: Float) {
        spriteBatch.draw(texture, x, y)
    }

    private fun escapeToQuitInDebug() {
        debug {
            Key.ESCAPE.ifKeyPressed {
                Gdx.app.exit()
            }
        }
    }
}
