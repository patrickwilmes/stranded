package com.bit.lake.core

import com.badlogic.gdx.math.Matrix4
import com.bit.lake.gdx.game.GameAdapter
import com.bit.lake.gdx.game.clearScreen
import com.bit.lake.gdx.graphics.Camera
import com.bit.lake.gdx.graphics.TextureManager
import com.bit.lake.gdx.input.Key
import com.bit.lake.gdx.input.ifKeyPressed
import com.bit.lake.gdx.types.Rectangle

class Stranded : GameAdapter() {
    private lateinit var block: Rectangle
    private lateinit var block2: Rectangle

    override fun initialize() {
        TextureManager.loadTexture("GrassBlock.png")
        TextureManager.loadTexture("Dirt.png")

        Camera.initialize(yDown = false, viewportWidth = 800f, viewportHeight = 600f)

        block = Rectangle(
            x = 800f / 2f - 64f / 2f,
            y = 600f / 2f - 64f / 2f,
            width = 64f,
            height = 64f,
        )

        block2 = Rectangle(
            x = 800f / 3f - 64f / 2f,
            y = 600f / 3f - 64f / 2f,
            width = 64f,
            height = 64f,
        )
    }

    override fun onUpdate() {
        clearScreen()

        Camera.update()

        Key.LEFT.ifKeyPressed {
            block.x -= 200f * delta()
        }
        Key.RIGHT.ifKeyPressed {
            block.x += 200f * delta()
        }
    }

    override fun handleSprites(projectionMatrixFunc: (Matrix4) -> Unit) {
        projectionMatrixFunc(Camera.combined())
        draw(TextureManager.loadTexture("GrassBlock.png"), block.x, block.y)
        draw(TextureManager.loadTexture("Dirt.png"), block2.x, block2.y)
    }

    override fun dispose() {
        TextureManager.dispose()
    }
}
