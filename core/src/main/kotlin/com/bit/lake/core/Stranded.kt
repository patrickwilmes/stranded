package com.bit.lake.core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Matrix4
import com.badlogic.gdx.math.Rectangle
import com.bit.lake.gdx.game.GameAdapter
import com.bit.lake.gdx.game.clearScreen
import com.bit.lake.gdx.input.Key
import com.bit.lake.gdx.input.ifKeyPressed

class Stranded : GameAdapter() {
    private lateinit var texture: Texture
    private lateinit var block: Rectangle
    private lateinit var camera: OrthographicCamera

    override fun initialize() {
        texture = Texture(Gdx.files.internal("GrassBlock.png"))

        camera = OrthographicCamera().apply {
            setToOrtho(false, 800f, 600f)
        }

        block = Rectangle().apply {
            x = 800f / 2f - 64f / 2f
            y = 600f / 2f - 64f / 2f
            width = 64f
            height = 64f
        }
    }

    override fun onUpdate() {
        clearScreen()

        camera.update()

        Key.LEFT.ifKeyPressed {
            block.x -= 200f * Gdx.graphics.deltaTime
        }
        Key.RIGHT.ifKeyPressed {
            block.x += 200f * Gdx.graphics.deltaTime
        }
    }

    override fun handleSprites(projectionMatrixFunc: (Matrix4) -> Unit) {
        projectionMatrixFunc(camera.combined)
        draw(texture, block.x, block.y)
    }

    override fun dispose() {
        texture.dispose()
    }
}
