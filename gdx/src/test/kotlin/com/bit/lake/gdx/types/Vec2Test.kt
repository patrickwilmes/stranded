package com.bit.lake.gdx.types

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

object Vec2Test {

    @Test
    fun `div by scalar and scalar is greater 0`() {
        val result = Vec2(2f, 2f) / 2f

        assert(result.x == 1f)
        assert(result.y == 1f)
    }

    @Test
    fun `div by scalar and components of vector are 0`() {
        val result = Vec2(0f, 0f) / 2f

        assert(result.x == 0f)
        assert(result.y == 0f)
    }

    @Test
    fun `div by scalar thats 0`() {
        assertThrows<IllegalArgumentException> {
            Vec2(2f, 2f) / 0f
        }
    }

    @Test
    fun `minus subtracting two 0 vectors`() {
        val result = Vec2.ZERO - Vec2.ZERO

        assert(result.x == 0f)
        assert(result.y == 0f)
    }

    @Test
    fun `minus subtracting two vectors`() {
        val result = Vec2(2f, 2f) - Vec2(1f, 1f)

        assert(result.x == 1f)
        assert(result.y == 1f)
    }
}
