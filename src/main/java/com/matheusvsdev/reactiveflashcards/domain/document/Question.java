package com.matheusvsdev.reactiveflashcards.domain.document;

public record Question(String asked,
                       String answered,
                       String expected) {
}
