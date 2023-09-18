package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public class GenericService {

    public Boolean run(ProcessStep startProcess, Context context) {

        Boolean out = null;

        try {
            OperationChecker operation = startProcess.execute(context);
            out = operation.match(context.getOperandType(), context.getObj1(), context.getObj2());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return out;
    }

}
