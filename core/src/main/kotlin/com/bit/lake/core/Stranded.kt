package com.bit.lake.core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Matrix4
import com.bit.lake.gdx.game.GameAdapter
import com.bit.lake.gdx.game.clearScreen
import com.bit.lake.gdx.graphics.Camera
import com.bit.lake.gdx.input.Key
import com.bit.lake.gdx.input.ifKeyPressed
import com.bit.lake.gdx.types.Rectangle

class Stranded : GameAdapter() {
    private lateinit var texture: Texture
    private lateinit var block: Rectangle

    override fun initialize() {
        texture = Texture(Gdx.files.internal("GrassBlock.png"))

        Camera.initialize(yDown = false, viewportWidth = 800f, viewportHeight = 600f)

        block = Rectangle(
            x = 800f / 2f - 64f / 2f,
            y = 600f / 2f - 64f / 2f,
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
        draw(texture, block.x, block.y)
    }

    override fun dispose() {
        texture.dispose()
    }
}
