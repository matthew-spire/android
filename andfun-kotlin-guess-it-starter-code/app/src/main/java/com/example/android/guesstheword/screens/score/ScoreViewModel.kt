package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    // The internal, mutable version of play again
    private val _eventPlayAgain = MutableLiveData<Boolean>()
    // The external, immutable version of play again
    val eventPlayAgain : LiveData<Boolean>
        get() = _eventPlayAgain

    // The internal, mutable version of (final) score
    private val _score = MutableLiveData<Int>()
    // The external, immutable version of (final) score
    val score : LiveData<Int>
        get() = _score

    init {
        _score.value = finalScore
    }

    fun onPlayAgain() {
        _eventPlayAgain.value = true
    }

    fun onPlayAgainComplete() {
        _eventPlayAgain.value = false
    }
}