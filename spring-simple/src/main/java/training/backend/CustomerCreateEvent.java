package training.backend;

import org.springframework.context.ApplicationEvent;

public class CustomerCreateEvent extends ApplicationEvent{
	
	private static final long serialVersionUID = 1L;
	
	private String name;

	public CustomerCreateEvent(Object source, String name) {
		super(source);
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
