// Generated from RichRail.g4 by ANTLR 4.7.1

package grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RichRailLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, ID=14, NUMBER=15, WHITESPACE=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "ID", "NUMBER", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'new'", "'train'", "'wagon'", "'numseats'", "'add'", "'to'", "'getnumseats'", 
		"'delete'", "'remove'", "'from'", "'locomotive'", "'wagon1'", "'wagon2'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "ID", "NUMBER", "WHITESPACE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public RichRailLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RichRail.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u008c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\7\17~\n\17\f\17\16\17\u0081\13\17\3\20\6\20\u0084"+
		"\n\20\r\20\16\20\u0085\3\21\6\21\u0089\n\21\r\21\16\21\u008a\2\2\22\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22\3\2\4\4\2\62;c|\5\2\13\f\16\17\"\"\2\u008e\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5\'\3\2\2\2\7-\3"+
		"\2\2\2\t\63\3\2\2\2\13<\3\2\2\2\r@\3\2\2\2\17C\3\2\2\2\21O\3\2\2\2\23"+
		"V\3\2\2\2\25]\3\2\2\2\27b\3\2\2\2\31m\3\2\2\2\33t\3\2\2\2\35{\3\2\2\2"+
		"\37\u0083\3\2\2\2!\u0088\3\2\2\2#$\7p\2\2$%\7g\2\2%&\7y\2\2&\4\3\2\2\2"+
		"\'(\7v\2\2()\7t\2\2)*\7c\2\2*+\7k\2\2+,\7p\2\2,\6\3\2\2\2-.\7y\2\2./\7"+
		"c\2\2/\60\7i\2\2\60\61\7q\2\2\61\62\7p\2\2\62\b\3\2\2\2\63\64\7p\2\2\64"+
		"\65\7w\2\2\65\66\7o\2\2\66\67\7u\2\2\678\7g\2\289\7c\2\29:\7v\2\2:;\7"+
		"u\2\2;\n\3\2\2\2<=\7c\2\2=>\7f\2\2>?\7f\2\2?\f\3\2\2\2@A\7v\2\2AB\7q\2"+
		"\2B\16\3\2\2\2CD\7i\2\2DE\7g\2\2EF\7v\2\2FG\7p\2\2GH\7w\2\2HI\7o\2\2I"+
		"J\7u\2\2JK\7g\2\2KL\7c\2\2LM\7v\2\2MN\7u\2\2N\20\3\2\2\2OP\7f\2\2PQ\7"+
		"g\2\2QR\7n\2\2RS\7g\2\2ST\7v\2\2TU\7g\2\2U\22\3\2\2\2VW\7t\2\2WX\7g\2"+
		"\2XY\7o\2\2YZ\7q\2\2Z[\7x\2\2[\\\7g\2\2\\\24\3\2\2\2]^\7h\2\2^_\7t\2\2"+
		"_`\7q\2\2`a\7o\2\2a\26\3\2\2\2bc\7n\2\2cd\7q\2\2de\7e\2\2ef\7q\2\2fg\7"+
		"o\2\2gh\7q\2\2hi\7v\2\2ij\7k\2\2jk\7x\2\2kl\7g\2\2l\30\3\2\2\2mn\7y\2"+
		"\2no\7c\2\2op\7i\2\2pq\7q\2\2qr\7p\2\2rs\7\63\2\2s\32\3\2\2\2tu\7y\2\2"+
		"uv\7c\2\2vw\7i\2\2wx\7q\2\2xy\7p\2\2yz\7\64\2\2z\34\3\2\2\2{\177\4c|\2"+
		"|~\t\2\2\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\36\3\2\2\2\u0081\177\3\2\2\2\u0082\u0084\4\62;\2\u0083\u0082\3\2\2\2"+
		"\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086 \3"+
		"\2\2\2\u0087\u0089\t\3\2\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\"\3\2\2\2\6\2\177\u0085\u008a"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}