package br.com.nicoletti.dp.usecase.strategy;

/**
 *
 * @author nicoletti
 * @param <T>
 */
public interface CriteriaStrategy<T> {

    public boolean match(OperandType operandType, T obj1, T obj2);

}
