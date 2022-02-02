package br.edu.insper.desagil.derp;

public class API implements ReportHandler{
	private Log log;

	public API(Log log) {
		this.log = log;
	}

	public void notify(Report report) {
		this.log.add("API notified " + report.getTitle());
	}
	
	@Override
	public void handle(Report report) {
		notify(report);
	}
}
