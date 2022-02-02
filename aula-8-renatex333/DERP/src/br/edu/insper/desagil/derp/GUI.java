package br.edu.insper.desagil.derp;

public class GUI implements ReportHandler{
	private Log log;

	public GUI(Log log) {
		this.log = log;
	}

	public void show(Report report) {
		this.log.add("GUI showed " + report.getTitle());
	}
	
	@Override
	public void handle(Report report) {
		show(report);
	}
}
