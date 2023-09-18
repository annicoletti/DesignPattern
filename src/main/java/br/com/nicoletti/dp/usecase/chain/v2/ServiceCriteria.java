package br.com.nicoletti.dp.usecase.chain.v2;

/**
 *
 * @author nicoletti
 */
public class ServiceCriteria {

    public Boolean run(ProcessStep startProcess, Object obj1, Object obj2, CriteriaType type) {

        Boolean out = null;

        try {
            OperationChecker operation = startProcess.execute(obj1, obj2, type);
            out = operation.match(type, obj1, obj2);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return out;
    }

}
