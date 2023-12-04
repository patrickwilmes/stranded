package com.bit.lake.core

import com.badlogic.gdx.math.Matrix4
import com.bit.lake.gdx.entity.DynamicEntity
import com.bit.lake.gdx.entity.StaticEntity
import com.bit.lake.gdx.game.GameAdapter
import com.bit.lake.gdx.game.clearScreen
import com.bit.lake.gdx.graphics.Camera
import com.bit.lake.gdx.graphics.Graphics
import com.bit.lake.gdx.graphics.TextureManager
import com.bit.lake.gdx.input.Key
import com.bit.lake.gdx.types.Rectangle

class GrassBlock(x: Float, y: Float) :
    StaticEntity("grass_block", Rectangle(x, y, 64f, 64f), "GrassBlock.png")

class MovingDirt(x: Float, y: Float) :
    DynamicEntity("dirt_block", Rectangle(x, y, 64f, 64f), "GrassBlock.png") {
    init {
        registerKeyAction(Key.LEFT) { delta ->
            rectangle.x -= 100 * delta
        }
        registerKeyAction(Key.RIGHT) { delta ->
            rectangle.x += 100 * delta
        }
    }
}

class Stranded : GameAdapter() {

    override fun initialize(graphics: Graphics) {
        registerEntity(GrassBlock(0f, 0f))
        registerEntity(GrassBlock(64f, 0f))
        registerEntity(GrassBlock(128f, 0f))
        registerEntity(
            MovingDirt(0f, 64f)
        )

        Camera.initialize(
            yDown = false,
            viewportWidth = graphics.viewportWith,
            viewportHeight = graphics.viewportHeight
        )
    }

    override fun onUpdate() {
        clearScreen()

        Camera.update()
    }

    override fun handleSprites(projectionMatrixFunc: (Matrix4) -> Unit) {
        projectionMatrixFunc(Camera.combined())
    }

    override fun dispose() {
        TextureManager.dispose()
    }
}
