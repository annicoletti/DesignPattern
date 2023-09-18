package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public class Main {

    public static void main(String[] args) {

        Context context = new Context();
        context.setObj1(true);
        context.setObj2(false);
        context.setOperandType(CriteriaType.IS_TRUE);

        GenericService service = new GenericService();

        Boolean result = service.run(StepBuilder.verifyAll, context);

        System.out.println("result: " + result);

    }
}
