package Main;
import java.util.Date;

import grammar.RichRailBaseListener;
import grammar.RichRailParser;

import trainmodel.*;

public class RichRailCommand extends RichRailBaseListener {
	private TrainModelFactory factory = new TrainModelFactory();
	
	@Override public void enterCommand(RichRailParser.CommandContext ctx) {
		CommandInfoHolder.setCommand(new Date(), "Command entered \"" + ctx.getText() + "\", that is not a known command type \"help\" to see all commands.");
	}
	
	@Override public void enterNewcommand(RichRailParser.NewcommandContext ctx) {
		CommandInfoHolder.setCommand(new Date(), "Now creating new train " + ctx.ID());
		Train createdTrain = factory.getTrainWithName(String.valueOf(ctx.ID()));
		RichRailClient.addTrain(createdTrain);
	}
	
	@Override public void enterCrecommand(RichRailParser.CrecommandContext ctx) {
		CommandInfoHolder.setCommand(new Date(), "Now creating new wagon " + ctx.ID(0) + " " + ctx.ID(1));
		RollingComponent createdComponent = factory.getRollingComponentWithName(String.valueOf(ctx.ID(0)), String.valueOf(ctx.ID(1)));
		RichRailClient.addComponent(createdComponent);
	}
	
	@Override public void enterAddcommand(RichRailParser.AddcommandContext ctx) {
		CommandInfoHolder.setCommand(new Date(), "Now adding wagon " + ctx.ID(0) + " to train " + ctx.ID(1));
		RollingComponent component = RichRailClient.getComponentByName(String.valueOf(ctx.ID(0)));
		Train train = RichRailClient.getTrainByName(String.valueOf(ctx.ID(1)));
		RichRailClient.addComponentToTrain(component, train);
	}
	
	@Override public void enterGetcommand(RichRailParser.GetcommandContext ctx) {
		CommandInfoHolder.setCommand(new Date(), "Calculating number of seats for " + ctx.ID());
	}
	
	@Override public void enterDelcommand(RichRailParser.DelcommandContext ctx) {
		CommandInfoHolder.setCommand(new Date(), "Now deleting train " + ctx.ID());
		RichRailClient.removeTrain(RichRailClient.getTrainByName(String.valueOf(ctx.ID())));
	}
	
	@Override public void enterRemcommand(RichRailParser.RemcommandContext ctx) {
		CommandInfoHolder.setCommand(new Date(), "Now removing wagon " + ctx.ID(0) + " from train " + ctx.ID(1));
		RollingComponent component = RichRailClient.getComponentByName(String.valueOf(ctx.ID(0)));
		Train train = RichRailClient.getTrainByName(String.valueOf(ctx.ID(1)));
		train.remComponent(component);
	}

}
