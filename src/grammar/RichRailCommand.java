package grammar;

public class RichRailCommand extends RichRailBaseListener {
	
	@Override public void enterCommand(RichRailParser.CommandContext ctx) {
		System.out.println("Command entered " + ctx.getText());
	}
	
	@Override public void enterNewtraincommand(RichRailParser.NewtraincommandContext ctx) {
		System.out.println("Now creating new train " + ctx.ID());
	}
	
	@Override public void enterNewwagoncommand(RichRailParser.NewwagoncommandContext ctx) {
		System.out.println("Now creating new wagon " + ctx.ID());
		System.out.println(ctx.WAGON());
	}
	
	@Override public void enterAddcommand(RichRailParser.AddcommandContext ctx) {
		System.out.println("Now adding wagon " + ctx.ID(0) + " to train " + ctx.ID(1));
	}
	
	@Override public void enterDelcommand(RichRailParser.DelcommandContext ctx) {
		System.out.println("Now deleting train " + ctx.ID());
	}

}
