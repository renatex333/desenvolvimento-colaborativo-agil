package br.edu.insper.desagil.swact;

import java.util.ArrayList;
import java.util.List;

public class NavigationComponent extends Component {
	private List<Component> children;

	public NavigationComponent() {
		super();
		this.children = new ArrayList<>();
	}

	public void addChild(Component component) {
		this.children.add(component);
	}
}
