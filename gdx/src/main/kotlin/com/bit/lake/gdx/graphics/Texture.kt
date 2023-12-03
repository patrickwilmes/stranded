package com.bit.lake.gdx.graphics

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.Disposable
import com.badlogic.gdx.graphics.Texture as GdxTexture

class Texture(internalPath: String) : Disposable {
    internal val texture = GdxTexture(Gdx.files.internal(internalPath))

    override fun dispose() {
        texture.dispose()
    }
}
