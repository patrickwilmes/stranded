package com.bit.lake.core

import com.bit.lake.core.entities.GrassBlock
import com.bit.lake.core.entities.MovingDirt
import com.bit.lake.gdx.game.GameAdapter
import com.bit.lake.gdx.game.clearScreen
import com.bit.lake.gdx.graphics.Graphics
import com.bit.lake.gdx.graphics.TextureManager

class Stranded : GameAdapter() {

    override fun initialize(graphics: Graphics) {
        registerEntity(GrassBlock(0f, 0f))
        registerEntity(GrassBlock(64f, 0f))
        registerEntity(GrassBlock(128f, 0f))
        registerEntity(
            MovingDirt(0f, 64f)
        )


    }

    override fun onUpdate() {
        clearScreen()
    }

    override fun dispose() {
        TextureManager.dispose()
    }
}
