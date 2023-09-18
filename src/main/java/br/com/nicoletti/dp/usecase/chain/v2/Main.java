package br.com.nicoletti.dp.usecase.chain.v2;

/**
 *
 * @author nicoletti
 */
public class Main {

    public static void main(String[] args) {

        Object obj1 = "hello";
        Object obj2 = "tchau";
        CriteriaType criteria = CriteriaType.GREATER_THAN_OR_EQUALS_TO;

        ServiceCriteria service = new ServiceCriteria();

        Boolean result = service.run(ProcessStepBuilder.verifyAll, obj1, obj2, criteria);

        System.out.println("result: " + result);

    }
}
