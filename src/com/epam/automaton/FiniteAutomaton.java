package com.epam.automaton;



/**
 * Deterministic finite automaton
 */
public class FiniteAutomaton {

    Status status; // Controls the status of the machine.

    /**
     * Create status.
     */
    public FiniteAutomaton() {
        this.status = new Status();
    }

    /**
     * Checks on the permissibility of the input word.
     * The word is admissible if after the last character of word processing, the machine will be in the final status.
     * That word is permissible when in him the number of zeros is 3 or 0, and one in end a word is present.
     *
     * It changes the status of the machine at each symbol from an input alphabet.
     * If the character is not in the alphabet, then skip it.
     *
     * @param entryWord - Entry word.
     * @return - Returns 'yes' if the machine is in the final status, otherwise 'no'.
     */
    public String isWordPermissible(String entryWord) {

        this.status.resetStatus(); // Reset to initial status.
        String symbol;
        String permissible;

        for (int i = 0; i < entryWord.length(); i++) {
            symbol = entryWord.substring(i, i + 1);
            this.status.changeStatus(symbol);
        }
        if (this.status.isFinalStatus()) {
            permissible = "yes";
        } else {
            permissible = "no";
        }
        return permissible;
    }

}
