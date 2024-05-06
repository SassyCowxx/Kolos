package com.example.labd3

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.math.pow

/**
 * Klasa Okrąg reprezentuje figurę geometryczną - okrąg. Przyjmuje parametry wejściowe określające
 * jej współrzędne w układzie kartezjańskim oraz promień.
 * @author Sasza Tokar
 * @param x - współrzędna x (Int)
 * @param y - współrzędna y (Int)
 * @param r - promień okręgu (Int, większy od 0)
 */
class Okrag(val x: Int, val y: Int, var r: Int){

    init {
        if (r <= 0) throw IllegalArgumentException("Promień okręgu musi być większy niż 0.")
    }

    /**
     * Funkcja skalowanie zwiększa promień r okręgu (obiektu klasy Okrąg) k-krotnie.
     * @author Sasza Tokar
     * @param k - krotność zwiększenia promienia okręgu.
     */
    fun skalowanie(k: Int){
        if (k > 0){
            this.r *= k
        }
        else throw IllegalArgumentException("Liczba k musi być dodatnia.")
    }

    /**
     * Funkcja punkt sprawdza, czy zadany punkt o współrzędnych a, b zawiera się w okręgu (obiekcie klasy Okrąg).
     * Metoda zaczerpnięta z portalu https://zpe.gov.pl/a/przeczytaj/DWbfd6eVh opisującego nierówność okręgu.
     * @author Sasza Tokar
     * @param a - współrzędna x
     * @param b - współrzędna y
     * @return Boolean - true lub false
     */
    fun punkt(a: Int, b: Int): Boolean{
        return if ((this.x - a).toDouble().pow(2) + (this.y - b).toDouble().pow(2) <= this.r.toDouble().pow(2)){
            true
        } else false
    }
}

class OkragTesty(){

    @Test
    fun skalowanieTest(){
        val oczekiwanyWynik = Okrag(1, 1, 16)
        val okrag = Okrag(1, 1, 2)
        okrag.skalowanie(8)
        assertEquals(oczekiwanyWynik.r, okrag.r)
    }

    @Test
    fun punktTest(){
        val okrag = Okrag(4, 2, 7)
        assertEquals(true, okrag.punkt(-1,3))
    }
}

fun main(){
    val okrag1 = Okrag(4, 2, 7)

    try{
        okrag1.skalowanie(-5)
    }
    catch (ex: IllegalArgumentException){
        println("Wystąpił błąd $ex")
    }

    println(okrag1.punkt(-1, 3))
    println(okrag1.punkt(-3, 0))

    OkragTesty().skalowanieTest()
    OkragTesty().punktTest()
}