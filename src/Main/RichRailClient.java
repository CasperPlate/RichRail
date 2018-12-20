package Main;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ui.*;
import grammar.*;
import trainmodel.*;

public class RichRailClient {
	private static TrainYard yard = new TrainYard();
	private static List<Window> windows = new ArrayList<Window>();

	public static void main(String[] args) throws Exception {
//		command("new train ns");
//		command("create wagon locomotive intercity");
//		command("create wagon wagon1 eersteklas");
//		command("create wagon wagon2 tweedeklas");
//		command("add intercity to ns");
//		command("add eersteklas to ns");
//
//		command("new train arriva");
//		command("create wagon locomotive sprinter");
//		command("add sprinter to arriva");
//		command("add eersteklas to arriva");
//		command("add tweedeklas to arriva");
//		command("add tweedeklas to arriva");
//
//		command("new train conexxion");
//		command("create wagon locomotive hondenkop");
//		command("add hondenkop to conexxion");
//		command("add eersteklas to conexxion");
//		command("add tweedeklas to conexxion");
//		command("add tweedeklas to conexxion");
//		command("add tweedeklas to conexxion");
//		command("add tweedeklas to conexxion");
//		command("add tweedeklas to conexxion");
//
//		command("new train ice");
//		command("create wagon locomotive hogesnelheid");
//		command("add hogesnelheid to ice");
//		command("add eersteklas to ICE");
//		command("add eersteklas to ICE");
//		command("add eersteklas to ICE");
//		command("add eersteklas to ICE");

		
		Window window1 = new Window("RichRail-1");
		window1.setVisible(true);
		windows.add(window1);

//		Window window2 = new Window("RichRail-2");
//		window2.setVisible(true);
//		windows.add(window2);

//		Window window2 = new Window("RichRail2");
//		window2.setVisible(true);
//		System.out.println(yard.getTrainByName("ns"));
//		command("remove eersteklas from ns");
//		System.out.println(yard.getTrainByName("ns"));
    }
	
	public static boolean command(String string) {
		CharStream is = CharStreams.fromString(string);

		RichRailLexer lexer = new RichRailLexer(is);

		// create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        RichRailParser parser = new RichRailParser(tokens);

		ParserRuleContext commandContext = parser.command();

		ParseTreeWalker walker = new ParseTreeWalker();
		RichRailCommand listener = new RichRailCommand();

		try {
	        walker.walk(listener, commandContext);
		} catch(NullPointerException exc) {
			return false;
		}
        
        return true;
	}
	
	public static void refresh() {
		for (Window w : windows) {
			w.refreshDisplayPanel();
		}
	}
	
	public static void addTrain(Train train) {
		yard.addTrain(train);
	}
	
	public static void removeTrain(Train train) {
		yard.deleteTrain(train);
	}
	
	public static List<Window> getWindows(){
		return windows;
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
	
	public static void addComponentToTrain(RollingComponent component, Train train) {
		yard.addComponentToTrain(component, train);
	}
	
	public static List<RollingComponent> getComponents() {
		return yard.getComponents();
	}
	
	public static RollingComponent getComponentByName(String name) {
		return yard.getComponentByName(name);
	}
}
