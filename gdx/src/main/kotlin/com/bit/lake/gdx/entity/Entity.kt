package com.bit.lake.gdx.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.bit.lake.gdx.graphics.TextureManager
import com.bit.lake.gdx.input.Key
import com.bit.lake.gdx.types.Rectangle

abstract class Entity(val identifier: String, rect: Rectangle) {
    protected var rectangle = rect

    abstract fun update(delta: Float)
    internal abstract fun render(spriteBatch: SpriteBatch)
}

abstract class StaticEntity(
    identifier: String,
    rect: Rectangle,
    textureName: String,
) : Entity(identifier, rect) {
    private val texture = TextureManager.loadTexture(textureName)

    override fun update(delta: Float) {}

    override fun render(spriteBatch: SpriteBatch) {
        spriteBatch.draw(
            texture.texture,
            rectangle.x,
            rectangle.y,
            rectangle.width,
            rectangle.height
        )
    }
}

abstract class DynamicEntity(
    identifier: String,
    rect: Rectangle,
    textureName: String,
) : Entity(identifier, rect) {
    private val texture = TextureManager.loadTexture(textureName)
    private val registeredKeyActions = mutableMapOf<Key, (Float) -> Unit>()

    override fun update(delta: Float) {
        registeredKeyActions.forEach { (key, action) ->
            if (Gdx.input.isKeyPressed(key.keyCode)) {
                action(delta)
            }
        }
    }

    protected fun registerKeyAction(key: Key, action: (Float) -> Unit) {
        registeredKeyActions[key] = action
    }

    override fun render(spriteBatch: SpriteBatch) {
        spriteBatch.draw(
            texture.texture,
            rectangle.x,
            rectangle.y,
            rectangle.width,
            rectangle.height
        )
    }
}
