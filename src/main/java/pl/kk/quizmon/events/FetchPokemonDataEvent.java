package pl.kk.quizmon.events;

import pl.kk.quizmon.models.Pokemon;

public record FetchPokemonDataEvent(Pokemon result) { }
