package com.epam.automaton;

/**
 * Managing of statuses finite automaton.
 */
public class Status {

    /*
        Set of all statuses.:

        q1 - The number of zeros is 3 or 0, and the one at the end of a word is missing.
        q2 - The number of zeros is 1, and the one at the end of a word is missing.
        q3 - The number of zeros is 3 or 0, and one in end a word is present.
        q4 - The number of zeros is 2, and the one at the end of a word is missing.
        q5 - The number of zeros is 1, and one in end a word is present.
        q6 - The number of zeros is 2, and one in end a word is present.
     */
    private String allStatuses = "123456";
    private int q0 = 1; // The initial status.

    /**
     * Set of finite statuses.
     * Achieved when the number of zeros is 3 or 0, and one in end a word is present.
     */
    private String finalStatus = "3";

    private int status; // Current status.

    RuleTransitions ruleTransitions; // Rules of transitions between statuses.

    /**
     * Set the initial status.
     * Create rule transitions.
     */
    public Status() {
        resetStatus(); // Reset to initial status.
        this.ruleTransitions = new RuleTransitions();
    }

    /**
     * Gets the new status.
     * Checks whether it is part of the set of all statuses,
     * if so then the new status becomes current.
     *
     * @param symbol - The symbol of the input word.
     */
    public void changeStatus(String symbol) {

        int newStatus = this.ruleTransitions.getNewStatus(this.status, symbol);
        if (isStatuses(newStatus)) {
            this.status = newStatus;
        }
    }

    /**
     * Checks whether the status of the machine is final.
     * In other words it checks whether the current status belongs to the set of final statuses.
     *
     * @return - true - if the status of the course, false otherwise.
     */
    public boolean isFinalStatus() {
        return this.finalStatus.contains(Integer.toString(this.status));
    }

    /**
     * Reset to initial status.
     */
    public void resetStatus() {
        this.status = this.q0;
    }

    /**
     * Checks whether it is part of the set of all statuses
     *
     * @param newStatus - status to text.
     * @return - true - if it is, otherwise false.
     */
    private boolean isStatuses(int newStatus) {
        return this.allStatuses.contains(Integer.toString(newStatus));
    }
}