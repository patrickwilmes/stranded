package com.bit.lake.gdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Matrix4
import com.bit.lake.gdx.debug.debug
import com.bit.lake.gdx.debug.info
import com.bit.lake.gdx.graphics.Graphics
import com.bit.lake.gdx.graphics.Texture
import com.bit.lake.gdx.input.Key
import com.bit.lake.gdx.input.ifKeyPressed

abstract class GameAdapter : ApplicationAdapter() {
    private lateinit var spriteBatch: SpriteBatch

    override fun create() {
        debug {
            info(this::class.java, "Debug mode enabled!")
        }
        spriteBatch = SpriteBatch()

        initialize(createGraphicsWrapper())
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
    protected abstract fun initialize(graphics: Graphics)

    protected fun draw(texture: Texture, x: Float, y: Float) {
        spriteBatch.draw(texture.texture, x, y)
    }

    protected fun delta() = Gdx.graphics.deltaTime

    private fun escapeToQuitInDebug() {
        debug {
            Key.ESCAPE.ifKeyPressed {
                Gdx.app.exit()
            }
        }
    }

    private fun createGraphicsWrapper() =
        Graphics(
            Gdx.graphics.width.toFloat(),
            Gdx.graphics.height.toFloat(),
        )
}
