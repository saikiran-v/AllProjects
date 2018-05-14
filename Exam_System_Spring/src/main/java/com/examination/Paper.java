package com.examination;

/**
 * @author saikiran.v
 *
 */
public class Paper {
	Evaluator evaluator;

	public Evaluator getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(Evaluator evaluator) {
		this.evaluator = evaluator;
	}

	public String submit() {
		return evaluator.evaluate(this);
	}
}
