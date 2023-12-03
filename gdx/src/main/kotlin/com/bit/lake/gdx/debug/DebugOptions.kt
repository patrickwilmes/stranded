package com.bit.lake.gdx.debug

object DebugOptions {
    fun isDebugModeEnabled(): Boolean = System.getenv().containsKey("DEBUG")
}
