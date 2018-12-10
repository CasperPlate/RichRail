package grammar;

public class RichRailCommand extends RichRailBaseListener {
	
	@Override public void enterCommand(RichRailParser.CommandContext ctx) {
		System.out.println("Command entered " + ctx.getText());
	}
	
	@Override public void enterNewcommand(RichRailParser.NewcommandContext ctx) {
		System.out.println("Now creating new train " + ctx.ID());
		
	}
	
	@Override public void enterCrecommand(RichRailParser.CrecommandContext ctx) {
		System.out.println("Now creating new wagon " + ctx.ID(0) + " " + ctx.ID(1));
	}
	
	@Override public void enterAddcommand(RichRailParser.AddcommandContext ctx) {
		System.out.println("Now adding wagon " + ctx.ID(0) + " to train " + ctx.ID(1));
	}
	
	@Override public void enterGetcommand(RichRailParser.GetcommandContext ctx) {
		System.out.println("Calculating number of seats for " + ctx.ID());
	}
	
	@Override public void enterDelcommand(RichRailParser.DelcommandContext ctx) {
		System.out.println("Now deleting train " + ctx.ID());
	}
	
	@Override public void enterRemcommand(RichRailParser.RemcommandContext ctx) {
		System.out.println("Now removing wagon " + ctx.ID(0) + " from train " + ctx.ID(1));
	}

}
