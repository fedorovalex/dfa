package com.epam.automaton;


import java.util.HashMap;
import java.util.Map;

/**
 * Детерминированный конечный автомат
 */
public class FiniteAutomaton {

    private String inputAlphabet = "01"; // Алфавит входных символов.
    /*
        Множество состояний:

        q1 - Едениц ЧЕТ, Нулей ЧЕТ
        q2 - Едениц НЕчет, Нулей НЕчет
        q3 - Едениц ЧЕТ, Нулей НЕчет
        q4 - Едениц НЕчет, Нулей ЧЕТ
     */
    private int q0 = 1; // Начальное состояние
    /**
     * Множество конечных состояний.
     * Достигается при ЧЕТНОМ колличестве нулей и НЕ четном количестве едениц.
     */
    private String finalStatus = "4";
    private Map<Integer, Integer> changeState = new HashMap<>(); // Хешь функция смены состояния
    private int status; // Нынешнее состояние.

    /**
     * Устанавливается начальное состояние.
     * Заполняется хэш функция смены состояний.
     */
    public FiniteAutomaton() {
        this.status = this.q0; // Нынешнему состоянию присваивается начальное состояние
        this.changeState.put(1, 3); // Преобразование состояний
        this.changeState.put(2, 4);
        this.changeState.put(3, 1);
        this.changeState.put(4, 2);
        this.changeState.put(5, 4);
        this.changeState.put(6, 3);
        this.changeState.put(7, 2);
        this.changeState.put(8, 1);
    }

    /**
     * Проверяет входное слово на допустимость.
     * Слово допустимо если после обработки последнего символа слова, автомат окажется в конечном состоянии.
     * То есть слово допустимо когда в слове ЧЕТНОЕ колличество нулей и НЕ четное количество едениц.
     *
     * Меняет состояние автомата на каждом символе из входного алфавита.
     * Если символ не из алфавита, то пропускает его.
     *
     * @param entryWord - Входное слово.
     * @return - Возвращает true если автомат находится в конечном состоянии, иначе false.
     */
    public boolean isWordPermissible(String entryWord) {

        String symbol; // TODO попытатся использывать char

        for (int i = 0; i < entryWord.length(); i++) {
            symbol = entryWord.substring(i, i + 1);
            if (isInputAlphabet(symbol)) {
                this.status = this.changeState.get(this.status + 4 * Integer.parseInt(symbol));
            }
        }
        return isFinalStatus();
    }

    /**
     * Проверяет принадлежит ли символ входному алфавиту.
     *
     * @param symbol - символ для проверки.
     * @return true - если принадлежит, false в противном случае.
     */
    private boolean isInputAlphabet(String symbol) {
        return this.inputAlphabet.contains(symbol);
    }

    /**
     * Проверяет в канечном ли состоянии находится автомат.
     * То есть проверяет принадлежит ли нынешнее состояние множеству конечных состояний.
     *
     * @return - true - если состояние конечно, false в противном случае.
     */
    private boolean isFinalStatus() {
        return this.finalStatus.contains(Integer.toString(this.status));
    }
}
