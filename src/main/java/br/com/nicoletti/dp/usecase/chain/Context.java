package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public class Context {

    private CriteriaType operandType;

    private Object obj1;

    private Object obj2;

    public CriteriaType getOperandType() {
        return operandType;
    }

    public void setOperandType(CriteriaType operandType) {
        this.operandType = operandType;
    }

    public Object getObj1() {
        return obj1;
    }

    public void setObj1(Object obj1) {
        this.obj1 = obj1;
    }

    public Object getObj2() {
        return obj2;
    }

    public void setObj2(Object obj2) {
        this.obj2 = obj2;
    }

}
