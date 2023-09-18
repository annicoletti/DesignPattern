package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public enum CriteriaType {

    EQUALS_TO("equalsTo"),
    NOT_EQUALS_TO("notEqualsTo"),
    GREATER_THAN("greaterThan"),
    GREATER_THAN_OR_EQUALS_TO("greaterThanOrEqualsTo"),
    LOWER_THAN("lowerThan"),
    LOWER_THAN_OR_EQUALS_TO("lowerThanOrEqualsTo"),
    IS_TRUE("isTrue"),
    IS_FALSE("isFalse"),
    CONTAINS("contains"),
    REG_EXP("regExp"),
    BEGINS_WITH("beginsWith"),
    ENDS_WITH("endsWith");

    String operandName;

    private CriteriaType(String operandName) {
        this.operandName = operandName;
    }

    public String getOperandName() {
        return operandName;
    }

    public static CriteriaType parse(String operandName) {
        for (CriteriaType operandType : CriteriaType.values()) {
            if (operandType.getOperandName().equals(operandName)) {
                return operandType;
            }
        }

        throw new RuntimeException("Erro ao criar um CriteriaType: " + operandName);
    }

}
