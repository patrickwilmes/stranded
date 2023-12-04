package com.bit.lake.core.entities

import com.bit.lake.gdx.entity.StaticEntity
import com.bit.lake.gdx.types.Rectangle

class GrassBlock(x: Float, y: Float) :
    StaticEntity("grass_block", Rectangle(x, y, 64f, 64f), "GrassBlock.png")
