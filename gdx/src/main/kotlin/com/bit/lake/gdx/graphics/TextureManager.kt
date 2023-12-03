package com.bit.lake.gdx.graphics

import com.badlogic.gdx.utils.Disposable

object TextureManager : Disposable {
    private val textures = mutableMapOf<String, Texture>()

    fun loadTexture(internalPath: String): Texture {
        return textures.getOrPut(internalPath) {
            Texture(internalPath)
        }
    }

    override fun dispose() {
        textures.values.forEach {
            it.dispose()
        }
    }
}
