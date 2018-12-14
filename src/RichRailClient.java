import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import grammar.*;
import trainmodel.*;

public class RichRailClient {
	private static TrainYard yard = new TrainYard();

	public static void main(String[] args) throws Exception {
		command("new train ns");
		command("create wagon locomotive intercity");
		command("create wagon wagon1 eersteklas");
		command("add intercity to ns");
		command("add eersteklas to ns");
		System.out.println(yard.getTrainByName("ns"));
		command("remove eersteklas from ns");
		System.out.println(yard.getTrainByName("ns"));
    }
	
	public static void command(String string) {
		CharStream is = CharStreams.fromString(string);
        
        RichRailLexer lexer = new RichRailLexer(is);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        RichRailParser parser = new RichRailParser(tokens);
        
        ParserRuleContext commandContext = parser.command();
        
        ParseTreeWalker walker = new ParseTreeWalker();
        RichRailCommand listener = new RichRailCommand();

        walker.walk(listener, commandContext);
	}
	
	public static void addTrain(Train train) {
		yard.addTrain(train);
	}
	
	public static void removeTrain(Train train) {
		yard.deleteTrain(train);
	}
	
	public static List<Train> getTrains() {
		return yard.getTrains();
	}
	
	public static Train getTrainByName(String name) {
		return yard.getTrainByName(name);
	}

	public static void addComponent(RollingComponent component) {
		yard.addComponent(component);
	}
	
	public static List<RollingComponent> getComponents() {
		return yard.getComponents();
	}
	
	public static RollingComponent getComponentByName(String name) {
		return yard.getComponentByName(name);
	}
}
