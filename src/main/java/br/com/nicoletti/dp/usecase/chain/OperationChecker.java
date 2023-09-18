package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 * @param <T>
 */
public interface OperationChecker<T> {

    public boolean match(CriteriaType operandType, T obj1, T obj2);

}
