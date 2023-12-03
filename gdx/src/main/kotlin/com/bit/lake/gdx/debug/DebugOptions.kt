package com.bit.lake.gdx.debug

object DebugOptions {
    fun isDebugModeEnabled(): Boolean = System.getenv().containsKey("DEBUG")
}

fun debug(func: () -> Unit) {
    if (DebugOptions.isDebugModeEnabled()) {
        func()
    }
}
