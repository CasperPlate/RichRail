package Main;

import java.util.Date;

public class CommandInfoHolder {
	private static CommandInfoHolder commandinfoholder = new CommandInfoHolder();
	private static Date moment;
	private static String command;
	
	private CommandInfoHolder() {
		this("");
	}

	private CommandInfoHolder(String command) {
		this(new Date(), command);
	}

	private CommandInfoHolder(Date mmnt, String cmmnd) {
		moment = mmnt;
		command = cmmnd;
	}

	public static CommandInfoHolder getInstace() {
		return commandinfoholder;
	}

	public static Date getMoment() {
		return moment;
	}

	public static String getCommand() {
		return command;
	}

	public static void setCommand(Date mmnt, String cmmnd) {
		moment = mmnt;
		command = cmmnd;
	}
	

}
