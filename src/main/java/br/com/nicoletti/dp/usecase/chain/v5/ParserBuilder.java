package br.com.nicoletti.dp.usecase.chain.v5;

/**
 *
 * @author nicoletti
 */
public final class ParserBuilder {

    public static Parser verifyAll = buildChain(
            new ParserString(),
            new ParserInteger(),
            new ParserArrayString());

    private static Parser buildChain(Parser... steps) {
        for (int index = 0; index < steps.length - 1; index++) {
            Parser currentStep = steps[index];
            currentStep.setNextStep(steps[index + 1]);
        }
        return steps[0];
    }
}
