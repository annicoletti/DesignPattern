package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public class StepBuilder {

    public static ProcessStep verifyNumerics = buildChain(
            new ProcessStepInteger(),
            new ProcessStepFloat(),
            new ProcessStepDouble());

    public static ProcessStep verifyAll = buildChain(
            new ProcessStepDouble(),
            new ProcessStepInteger(),
            new ProcessStepString(),
            new ProcessStepBoolean(),
            new ProcessStepFloat(),
            new ProcessStepLong(),
            new ProcessStepDouble());

    private static ProcessStep buildChain(ProcessStep... steps) {
        for (int index = 0; index < steps.length - 1; index++) {
            ProcessStep currentStep = steps[index];
            currentStep.setNextStep(steps[index + 1]);
        }
        return steps[0];
    }
}
