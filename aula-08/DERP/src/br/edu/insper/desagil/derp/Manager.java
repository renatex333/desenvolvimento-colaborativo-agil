package br.edu.insper.desagil.derp;

import java.util.ArrayList;
import java.util.List;

public class Manager {
	private List<ReportHandler> handlers;

	public Manager() {
		this.handlers = new ArrayList<>();	
	}
	
	public void addReportHandler(ReportHandler handler) {
		this.handlers.add(handler);
	}

	public void finish(Report report) {
		for (ReportHandler handler: this.handlers) {
			handler.handle(report);
		}
	}
}
