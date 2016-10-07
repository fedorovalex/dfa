package com.epam.main;


import com.epam.automaton.FiniteAutomaton;

public class Main {

    public static void main(String[] args) {
        String entryWord = "1d 0 00 r0t1 1 1"; // TODO Входное слово забирать с консоли
        FiniteAutomaton finiteAutomaton = new FiniteAutomaton();
        System.out.println("Word is accepted->" + finiteAutomaton.isWordPermissible(entryWord));
    }
}
