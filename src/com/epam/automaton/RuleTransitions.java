package com.epam.automaton;


import java.util.HashMap;
import java.util.Map;

/**
 * Managing the transition between the statuses of a finite state machine.
 */
public class RuleTransitions {

    private String inputAlphabet = "01"; // The alphabet of input symbols.
    private Map<Integer, Integer> changeStatus = new HashMap<>(); // The hash function status change.

    /**
     * Filled HashMap transitions between statuses.
     */
    public RuleTransitions() {

        // Change statuses.
        initRuleTransitions();
    }

    /**
     *  Gets the new state of the machine via a jump table through the current state and the processed symbol.
     *
     * @param currentStatus - Status in which the final machine is now.
     * @param symbol - The symbol of the input word.
     * @return - New status of machine.
     */
    public int getNewStatus(int currentStatus, String symbol) {
        int newStatus;
        if (isInputAlphabet(symbol)) {
            int block = 6 * Integer.parseInt(symbol); // The block number in the transitions table.
            int rule = currentStatus + block; // Number of the current status in the block.
            newStatus = this.changeStatus.get(rule);
        }
        else {
            newStatus = -1;
        }
        return newStatus;
    }

    /**
     * Checks whether a character is part of the input alphabet.
     *
     * @param symbol - Symbol to test.
     * @return - True - if belongs, false otherwise.
     */
    private boolean isInputAlphabet(String symbol) {
        return this.inputAlphabet.contains(symbol);
    }

    /**
     * Initialization rules transitions between status of the machine on each symbol of the alphabet.
     */
    private void initRuleTransitions() {
        //if symbol = 0
        this.changeStatus.put(1, 2); //if status = 1
        this.changeStatus.put(2, 4); //if status = 2
        this.changeStatus.put(3, 2); //if status = 3
        this.changeStatus.put(4, 1); //if status = 4
        this.changeStatus.put(5, 4); //if status = 5
        this.changeStatus.put(6, 1); //if status = 6

        //if symbol = 1
        this.changeStatus.put(7, 3); //if status = 1
        this.changeStatus.put(8, 5); //if status = 2
        this.changeStatus.put(9, 3); //if status = 3
        this.changeStatus.put(10, 6); //if status = 4
        this.changeStatus.put(11, 5); //if status = 5
        this.changeStatus.put(12, 6); //if status = 6
    }
}
