package com.examination;

/**
 * @author saikiran.v
 *
 */
public class Evaluator {
	private static Evaluator evaluator = null;

	private Evaluator() {

	}

	public static Evaluator getEvaluator() {

		if (evaluator == null) {
			evaluator = new Evaluator();
		}
		return evaluator;
	}

	public String evaluate(Paper paper) {

		return "pass";
	}
}
