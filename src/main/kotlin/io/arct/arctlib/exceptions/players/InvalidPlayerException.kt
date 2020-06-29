package io.arct.arctlib.exceptions.players

class InvalidPlayerException : PlayerException() {
    override val node = "players.invalid-player"
    override val default = "&7You do not have permission to do this!"
}