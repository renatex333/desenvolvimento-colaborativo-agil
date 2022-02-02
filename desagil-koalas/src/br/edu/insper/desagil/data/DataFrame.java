package br.edu.insper.desagil.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFrame {
	private Map<String, List<Double>> columns;

	public DataFrame() {
		this.columns = new HashMap<>();
	}

	public List<Double> getValues(String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}
		return values;
	}
	
	private double calculateSum(List<Double> values) {
		double s = 0;
		for (double value: values) {
			s += value;
		}
		return s;
	}

	private double calculateAvg(List<Double> values) {
		return calculateSum(values) / values.size();
	}

	private double calculateVar(List<Double> values) {
		double m = calculateAvg(values);
		double s = 0;
		for (double value: values) {
			s += Math.pow(value - m, 2);
		}
		return s / values.size();
	}

	public void addColumn(String label, List<Double> values) {
		this.columns.put(label, new ArrayList<>(values));
	}
	
	
	public double min(String label) {
		List<Double> values = getValues(label);
		double m = Double.POSITIVE_INFINITY;
		for (double value: values) {
			if (m > value) {
				m = value;
			}
		}
		return m;
	}

	public double max(String label) {
		List<Double> values = getValues(label);		
		double m = Double.NEGATIVE_INFINITY;
		for (double value: values) {
			if (m < value) {
				m = value;
			}
		}
		return m;
	}

	public double sum(String label) {
		return calculateSum(getValues(label));
	}

	public double avg(String label) {
		return calculateAvg(getValues(label));
	}

	public double var(String label) {
		return calculateVar(getValues(label));
	}

	public double std(String label) {
		return Math.sqrt(var(label));
	}
}
