package br.com.nicoletti.dp.usecase.strategy;

/**
 *
 * @author nicoletti
 */
class CheckCriteria {

    private CriteriaStrategy criteriaStrategy;

    private Object obj1;

    private Object obj2;

    public void setValues(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void setStrategy(CriteriaStrategy criteriaStrategy) {
        this.criteriaStrategy = criteriaStrategy;
    }

    public void check(OperandType operandType) {
        boolean match = criteriaStrategy.match(operandType, obj1, obj2);
        System.out.println(obj1 + " " + operandType.name() + " " + obj2 + " = " + match);
    }

}
