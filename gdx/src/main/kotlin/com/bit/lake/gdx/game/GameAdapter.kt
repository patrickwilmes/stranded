package com.bit.lake.gdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.bit.lake.gdx.debug.debug
import com.bit.lake.gdx.debug.info
import com.bit.lake.gdx.entity.DynamicEntity
import com.bit.lake.gdx.entity.Entity
import com.bit.lake.gdx.graphics.Camera
import com.bit.lake.gdx.graphics.Graphics
import com.bit.lake.gdx.input.Key
import com.bit.lake.gdx.input.ifKeyPressed

abstract class GameAdapter : ApplicationAdapter() {
    private lateinit var spriteBatch: SpriteBatch
    private val entities = mutableListOf<Entity>()

    override fun create() {
        debug {
            info(this::class.java, "Debug mode enabled!")
        }
        spriteBatch = SpriteBatch()

        with(createGraphicsWrapper()) {
            Camera.initialize(
                yDown = false,
                viewportWidth = viewportWith,
                viewportHeight = viewportHeight
            )

            initialize(this)
        }
    }

    override fun render() {
        escapeToQuitInDebug()
        Camera.update()
        onUpdate()
        spriteBatch.begin()
        spriteBatch.projectionMatrix = Camera.combined()
        entities.forEach { entity ->
            entity.render(spriteBatch)
        }
        spriteBatch.end()
        entities.filterIsInstance<DynamicEntity>()
            .forEach {
                it.update(delta())
            }
    }

    override fun dispose() {
        spriteBatch.dispose()
    }

    protected abstract fun onUpdate()
    protected abstract fun initialize(graphics: Graphics)

    protected fun registerEntity(entity: Entity) {
        entities.add(entity)
    }

    private fun delta() = Gdx.graphics.deltaTime

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
