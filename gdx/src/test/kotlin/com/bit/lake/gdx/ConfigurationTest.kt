package com.bit.lake.gdx

import com.bit.lake.gdx.types.Vec2
import kotlin.test.Test

object ConfigurationTest {

    @Test
    fun `positionAsVec2 calculates the center position correctly`() {
        val screenSize = Vec2(800f, 600f)
        val expectedPosition = Vec2(screenSize.x / 2f - 200f / 2f, screenSize.y / 2f - 200f / 2f)

        val resultingPosition = Configuration(
            size = Vec2(200f, 200f),
            title = "Stranded",
            screenSize = screenSize,
        ).positionAsVec2

        assert(resultingPosition == expectedPosition)
    }

    @Test
    fun `positionAsVec2 returns the position as is when its custom`() {
        val expectedPosition = Vec2(100f, 100f)

        val resultingPosition = Configuration(
            size = Vec2(200f, 200f),
            title = "Stranded",
            position = Position.Custom(expectedPosition),
        ).positionAsVec2

        assert(resultingPosition == expectedPosition)
    }
}
