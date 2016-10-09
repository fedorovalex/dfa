package com.epam.automaton;


import java.util.HashMap;
import java.util.Map;

/**
 * Deterministic finite automaton
 */
public class FiniteAutomaton {

    private String inputAlphabet = "01"; // The alphabet of input symbols.
    /*
        Set of states:

        q1 - An even number of ones and an even number of zeros.
        q2 - An uneven number of ones and an uneven number of zeros.
        q3 - An even number of ones and an uneven number of zeros.
        q4 - An uneven number of ones and an even number of zeros.
     */
    private int q0 = 1; // The initial state.
    /**
     * Set of finite states.
     * Achieved when an uneven number of ones and an even number of zeros.
     */
    private String finalStatus = "4";
    private Map<Integer, Integer> changeState = new HashMap<>(); // The hash function status change.
    private int status; // Current status.

    /**
     * Set the initial state.
     * Filled HashMap transitions between states.
     */
    public FiniteAutomaton() {
        resetStatus(); // Reset to initial state.
        this.changeState.put(1, 3); // Change states.
        this.changeState.put(2, 4);
        this.changeState.put(3, 1);
        this.changeState.put(4, 2);
        this.changeState.put(5, 4);
        this.changeState.put(6, 3);
        this.changeState.put(7, 2);
        this.changeState.put(8, 1);
    }

    /**
     * Checks on the permissibility of the input word.
     * The word is admissible if after the last character of word processing, the machine will be in the final state.
     * That word is permissible when in him an uneven number of ones and an even number of zeros.
     *
     * It changes the state of the machine at each symbol from an input alphabet.
     * If the character is not in the alphabet, then skip it.
     *
     * @param entryWord - Entry word.
     * @return - Returns true if the machine is in the final state, otherwise false.
     */
    public boolean isWordPermissible(String entryWord) {

        this.status = this.q0;
        String symbol;

        for (int i = 0; i < entryWord.length(); i++) {
            symbol = entryWord.substring(i, i + 1);
            if (isInputAlphabet(symbol)) {
                this.status = this.changeState.get(this.status + 4 * Integer.parseInt(symbol));
            }
        }
        return isFinalStatus();
    }

    /**
     * Checks whether a character is part of the input alphabet.
     *
     * @param symbol - symbol to test.
     * @return true - if belongs, false otherwise.
     */
    private boolean isInputAlphabet(String symbol) {
        return this.inputAlphabet.contains(symbol);
    }

    /**
     * Checks whether the status of the machine is final.
     * In other words it checks whether the current state belongs to the set of final states.
     *
     * @return - true - if the state of the course, false otherwise.
     */
    private boolean isFinalStatus() {
        return this.finalStatus.contains(Integer.toString(this.status));
    }

    /**
     * Reset to initial state.
     */
    private void resetStatus() {
        this.status = this.q0;
    }
}
