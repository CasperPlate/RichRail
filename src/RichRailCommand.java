import grammar.RichRailBaseListener;
import grammar.RichRailParser;

import trainmodel.*;

public class RichRailCommand extends RichRailBaseListener {
	private TrainModelFactory factory = new TrainModelFactory();
	
	@Override public void enterCommand(RichRailParser.CommandContext ctx) {
		System.out.println("Command entered " + ctx.getText());
	}
	
	@Override public void enterNewcommand(RichRailParser.NewcommandContext ctx) {
		System.out.println("Now creating new train " + ctx.ID());
		Train createdTrain = factory.getTrainWithName(String.valueOf(ctx.ID()));
		RichRailClient.addTrain(createdTrain);
	}
	
	@Override public void enterCrecommand(RichRailParser.CrecommandContext ctx) {
		System.out.println("Now creating new wagon " + ctx.ID(0) + " " + ctx.ID(1));
		RollingComponent createdComponent = factory.getRollingComponentWithName(String.valueOf(ctx.ID(0)), String.valueOf(ctx.ID(1)));
		RichRailClient.addComponent(createdComponent);
	}
	
	@Override public void enterAddcommand(RichRailParser.AddcommandContext ctx) {
		System.out.println("Now adding wagon " + ctx.ID(0) + " to train " + ctx.ID(1));
		RollingComponent component = RichRailClient.getComponentByName(String.valueOf(ctx.ID(0)));
		Train train = RichRailClient.getTrainByName(String.valueOf(ctx.ID(1)));
		train.addComponent(component);
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
