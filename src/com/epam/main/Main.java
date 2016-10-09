package com.epam.main;


import com.epam.automaton.FiniteAutomaton;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String entryWord = "100";
        FiniteAutomaton finiteAutomaton = new FiniteAutomaton();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input word. To exit, enter: Exit");
        do {
            System.out.println("Word ->'" + entryWord + "' is accepted->" + finiteAutomaton.isWordPermissible(entryWord));
            entryWord = scanner.nextLine();
        } while (!entryWord.equals("Exit"));
    }
}