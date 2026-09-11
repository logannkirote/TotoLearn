package com.example.totolearn

import android.content.Context
import androidx.core.content.edit

class ProgressManager(context: Context) {

    private val prefs = context.getSharedPreferences("toto_progress", Context.MODE_PRIVATE)

    fun saveCorrectAnswer() {
        val current = prefs.getInt("score", 0)
        prefs.edit {
            putInt("score", current + 1)
        }
    }

    fun getScore(): Int {
        return prefs.getInt("score", 0)
    }

    fun resetScore() {
        prefs.edit {
            putInt("score", 0)
        }
    }



    private val wrongEnglishKey = "WRONG_ENGLISH"
    private val wrongSwahiliKey = "WRONG_SWAHILI"
    private val wrongHesabuKey = "WRONG_HESABU"

    fun saveWrongEnglish(index: Int) {
        val current =
            prefs.getStringSet(wrongEnglishKey, mutableSetOf())?.toMutableSet() ?: mutableSetOf()
        current.add(index.toString())
        prefs.edit {
            putStringSet(wrongEnglishKey, current)
        }
    }

    fun getWrongEnglish(): List<Int> {
        return prefs.getStringSet(wrongEnglishKey, setOf())?.map{it.toInt() }?: emptyList()
    }

    fun clearEnglish() {
        prefs.edit {
            remove(wrongEnglishKey)
        }
    }
    fun saveWrongSwahili(index: Int) {
        val current =
            prefs.getStringSet(wrongSwahiliKey, mutableSetOf())?.toMutableSet() ?: mutableSetOf()
        current.add(index.toString())
        prefs.edit {
            putStringSet(wrongSwahiliKey, current)
        }
    }

    fun getWrongSwahili(): List<Int> {
        return prefs.getStringSet(wrongSwahiliKey, setOf())?.map{it.toInt()} ?: emptyList()
    }

    fun clearSwahili() {
        prefs.edit {
            remove(wrongSwahiliKey)
        }
    }
    fun saveWrongNumber(index: Int) {
        val set = prefs.getStringSet("wrong_numbers", mutableSetOf())!!.toMutableSet()
        set.add(index.toString())
        prefs.edit { putStringSet("wrong_numbers", set) }
    }

    fun getWrongNumbers(): List<Int> {
        return prefs.getStringSet("wrong_numbers", setOf())!!.map { it.toInt() }
    }
    fun clearNumbers() {
        prefs.edit { remove("wrong_numbers") }
    }
    fun saveStar() {
        val stars = prefs.getInt("stars", 0)
        prefs.edit { putInt("stars", stars + 1) }
    }
    fun getStars(): Int {
        return prefs.getInt("stars", 0)
    }
    fun saveWrongHesabu(index: Int) {
        val current =
            prefs.getStringSet(wrongHesabuKey, mutableSetOf())?.toMutableSet() ?: mutableSetOf()
        current.add(index.toString())
        prefs.edit {
            putStringSet(wrongHesabuKey, current)
        }
    }

    fun getWrongHesabu(): List<Int> {
        return prefs.getStringSet(wrongHesabuKey, setOf())
            ?.map { it.toInt() } ?: emptyList()
    }

    fun clearHesabu() {
        prefs.edit {
            remove(wrongHesabuKey)
        }
    }
}

