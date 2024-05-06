package com.example.labd3

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Funkcja filtrowanieRosnace przyjmuje jako argument listę liczb całkowitych List<Int> oraz zwraca
 * mutowalą listę liczb całkowitych, która jest zmodifykowaną listą wejściową w taki sposób, że trafiają
 * do niej tylko i wyłącznie następne liczby, jeśli są większe od największej liczby, która już wystąpiła w liście wcześniej.
 * @author Sasza Tokar
 * @param liczby - lista liczb całkowitych (Int)
 * @return zmodyfikowana lista liczb.
 */
fun filtrowanieRosnace(liczby: List<Int>): MutableList<Int>{
    if (liczby.isNotEmpty()){
        val dlugosc = liczby.size
        val nowaLista = mutableListOf(liczby[0])
        var najwieksza = liczby[0]
        for (i in 1..<dlugosc){
            if (liczby[i] > najwieksza){
                nowaLista.add(liczby[i])
                najwieksza = liczby[i]
            }
        }
        return nowaLista
    }
    else throw IllegalArgumentException("Lista liczb nie może być pusta.")
}

class Testy{

    @Test
    fun filtrowanieRosnaceTest(){
        val oczekiwanyWynik = listOf(1, 13, 21)
        assertEquals(oczekiwanyWynik, filtrowanieRosnace(listOf(1, 13, 13, 4, 13, -10, 21, 9)))
    }
}

fun main(){
    val lista1 = listOf(1, 13, 13, 4, 13, -10, 21, 9)
    val lista2 = emptyList<Int>()

    try{
        println(filtrowanieRosnace(lista1).joinToString())
    }
    catch (ex: IllegalArgumentException){
        println("Wystąpił błąd $ex")
    }

    try{
        println(filtrowanieRosnace(lista2).joinToString())
    }
    catch (ex: IllegalArgumentException){
        println("Wystąpił błąd $ex")
    }

    Testy().filtrowanieRosnaceTest()
}