package br.edu.insper.desagil.derp;

public class BD implements ReportHandler {
	private Log log;

	public BD(Log log) {
		this.log = log;
	}

	public void save(Report report) {
		this.log.add("BD saved " + report.getTitle());
	}
	
	@Override
	public void handle(Report report) {
		save(report);
	}
}
