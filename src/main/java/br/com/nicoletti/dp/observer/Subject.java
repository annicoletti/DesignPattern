package br.com.nicoletti.dp.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicoletti
 */
public interface Subject {

    /**
     * Lista de Observers a ser notificado
     */
    public List<Observer> observers = new ArrayList<>();

    /**
     * Registra os Observador para receber as notificações
     *
     * @param observer
     */
    public default void registyObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Remove Observador da lista
     *
     * @param observer
     */
    public default void removeObserver(Observer observer) {
        int indexOf = observers.indexOf(observer);
        if (indexOf >= 0) {
            observers.remove(observer);
        }
    }

    public default void notifyObservers() {
        for (Observer obs : observers) {
            try {
                Thread.sleep(5000);
                obs.update(this);
            } //        observers.forEach((observer) -> observer.update(this));
            catch (InterruptedException ex) {
                Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
