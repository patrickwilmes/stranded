package com.bit.lake.core.entities

import com.bit.lake.gdx.entity.DynamicEntity
import com.bit.lake.gdx.input.Key
import com.bit.lake.gdx.types.Rectangle

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
