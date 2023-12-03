package com.bit.lake.core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.bit.lake.gdx.game.GameAdapter
import com.bit.lake.gdx.game.clearScreen
import com.bit.lake.gdx.input.Key
import com.bit.lake.gdx.input.ifKeyPressed

class Stranded : GameAdapter() {
    private lateinit var texture: Texture
    private lateinit var block: Rectangle
    private lateinit var spriteBatch: SpriteBatch
    private lateinit var camera: OrthographicCamera

    override fun create() {
        texture = Texture(Gdx.files.internal("GrassBlock.png"))

        camera = OrthographicCamera().apply {
            setToOrtho(false, 800f, 600f)
        }

        spriteBatch = SpriteBatch()

        block = Rectangle().apply {
            x = 800f / 2f - 64f / 2f
            y = 600f / 2f - 64f / 2f
            width = 64f
            height = 64f
        }
    }

    override fun renderScene() {
        clearScreen()

        camera.update()

        spriteBatch.projectionMatrix = camera.combined
        spriteBatch.begin()
        spriteBatch.draw(texture, block.x, block.y)
        spriteBatch.end()

        Key.LEFT.ifKeyPressed {
            block.x -= 200f * Gdx.graphics.deltaTime
        }
        Key.RIGHT.ifKeyPressed {
            block.x += 200f * Gdx.graphics.deltaTime
        }
    }

    override fun dispose() {
        texture.dispose()
        spriteBatch.dispose()
    }
}
