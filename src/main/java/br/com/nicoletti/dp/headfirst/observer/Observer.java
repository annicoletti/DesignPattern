package br.com.nicoletti.dp.headfirst.observer;

/**
 *
 * @author nicoletti
 */
public interface Observer {

    /**
     * Registra observador no Subject
     *
     * @param subjects
     */
    public default void registy(Subject... subjects) {
        for (Subject sub : subjects) {
            sub.registyObserver(this);
        }
    }

    /**
     * Recebe a notificação do Subject
     *
     * @param subject
     */
    void update(Subject subject);

}
