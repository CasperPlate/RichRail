// Generated from RichRail.g4 by ANTLR 4.7.1

package grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RichRailParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ID=12, NUMBER=13, WHITESPACE=14;
	public static final int
		RULE_command = 0, RULE_newcommand = 1, RULE_crecommand = 2, RULE_addcommand = 3, 
		RULE_getcommand = 4, RULE_delcommand = 5, RULE_remcommand = 6, RULE_type = 7;
	public static final String[] ruleNames = {
		"command", "newcommand", "crecommand", "addcommand", "getcommand", "delcommand", 
		"remcommand", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'new'", "'train'", "'create'", "'wagon'", "'numseats'", "'add'", 
		"'to'", "'getnumseats'", "'delete'", "'remove'", "'from'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ID", "NUMBER", "WHITESPACE"
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

	@Override
	public String getGrammarFileName() { return "RichRail.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RichRailParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CommandContext extends ParserRuleContext {
		public NewcommandContext newcommand() {
			return getRuleContext(NewcommandContext.class,0);
		}
		public CrecommandContext crecommand() {
			return getRuleContext(CrecommandContext.class,0);
		}
		public AddcommandContext addcommand() {
			return getRuleContext(AddcommandContext.class,0);
		}
		public GetcommandContext getcommand() {
			return getRuleContext(GetcommandContext.class,0);
		}
		public DelcommandContext delcommand() {
			return getRuleContext(DelcommandContext.class,0);
		}
		public RemcommandContext remcommand() {
			return getRuleContext(RemcommandContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_command);
		try {
			setState(22);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				newcommand();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				crecommand();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(18);
				addcommand();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(19);
				getcommand();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(20);
				delcommand();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 6);
				{
				setState(21);
				remcommand();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewcommandContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RichRailParser.ID, 0); }
		public NewcommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newcommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).enterNewcommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).exitNewcommand(this);
		}
	}

	public final NewcommandContext newcommand() throws RecognitionException {
		NewcommandContext _localctx = new NewcommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_newcommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(25);
			match(T__1);
			setState(26);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CrecommandContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RichRailParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RichRailParser.ID, i);
		}
		public TerminalNode NUMBER() { return getToken(RichRailParser.NUMBER, 0); }
		public CrecommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crecommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).enterCrecommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).exitCrecommand(this);
		}
	}

	public final CrecommandContext crecommand() throws RecognitionException {
		CrecommandContext _localctx = new CrecommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_crecommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__2);
			setState(29);
			match(T__3);
			setState(30);
			match(ID);
			setState(31);
			match(ID);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(32);
				match(T__4);
				setState(33);
				match(NUMBER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddcommandContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RichRailParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RichRailParser.ID, i);
		}
		public AddcommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addcommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).enterAddcommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).exitAddcommand(this);
		}
	}

	public final AddcommandContext addcommand() throws RecognitionException {
		AddcommandContext _localctx = new AddcommandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_addcommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__5);
			setState(37);
			match(ID);
			setState(38);
			match(T__6);
			setState(39);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GetcommandContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(RichRailParser.ID, 0); }
		public GetcommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getcommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).enterGetcommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).exitGetcommand(this);
		}
	}

	public final GetcommandContext getcommand() throws RecognitionException {
		GetcommandContext _localctx = new GetcommandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_getcommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__7);
			setState(42);
			type();
			setState(43);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DelcommandContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RichRailParser.ID, 0); }
		public DelcommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delcommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).enterDelcommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).exitDelcommand(this);
		}
	}

	public final DelcommandContext delcommand() throws RecognitionException {
		DelcommandContext _localctx = new DelcommandContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_delcommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__8);
			setState(46);
			match(T__1);
			setState(47);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RemcommandContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RichRailParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RichRailParser.ID, i);
		}
		public RemcommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remcommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).enterRemcommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).exitRemcommand(this);
		}
	}

	public final RemcommandContext remcommand() throws RecognitionException {
		RemcommandContext _localctx = new RemcommandContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_remcommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__9);
			setState(50);
			match(ID);
			setState(51);
			match(T__10);
			setState(52);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RichRailListener ) ((RichRailListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(54);
				match(T__1);
				}
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(55);
				match(T__3);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20=\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\31\n\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4%\n\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\5\t;\n\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2;\2\30\3\2\2\2\4\32\3\2"+
		"\2\2\6\36\3\2\2\2\b&\3\2\2\2\n+\3\2\2\2\f/\3\2\2\2\16\63\3\2\2\2\20:\3"+
		"\2\2\2\22\31\5\4\3\2\23\31\5\6\4\2\24\31\5\b\5\2\25\31\5\n\6\2\26\31\5"+
		"\f\7\2\27\31\5\16\b\2\30\22\3\2\2\2\30\23\3\2\2\2\30\24\3\2\2\2\30\25"+
		"\3\2\2\2\30\26\3\2\2\2\30\27\3\2\2\2\31\3\3\2\2\2\32\33\7\3\2\2\33\34"+
		"\7\4\2\2\34\35\7\16\2\2\35\5\3\2\2\2\36\37\7\5\2\2\37 \7\6\2\2 !\7\16"+
		"\2\2!$\7\16\2\2\"#\7\7\2\2#%\7\17\2\2$\"\3\2\2\2$%\3\2\2\2%\7\3\2\2\2"+
		"&\'\7\b\2\2\'(\7\16\2\2()\7\t\2\2)*\7\16\2\2*\t\3\2\2\2+,\7\n\2\2,-\5"+
		"\20\t\2-.\7\16\2\2.\13\3\2\2\2/\60\7\13\2\2\60\61\7\4\2\2\61\62\7\16\2"+
		"\2\62\r\3\2\2\2\63\64\7\f\2\2\64\65\7\16\2\2\65\66\7\r\2\2\66\67\7\16"+
		"\2\2\67\17\3\2\2\28;\7\4\2\29;\7\6\2\2:8\3\2\2\2:9\3\2\2\2;\21\3\2\2\2"+
		"\5\30$:";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}