package io.github.garnaalpak.watchdeck

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform