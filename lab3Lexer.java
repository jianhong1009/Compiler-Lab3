// Generated from lab3.g4 by ANTLR 4.9
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lab3Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, WS=17, 
		DecimalConst=18, OctalConst=19, HexadecimalConst=20, Ident1=21, HexadecimalPrefix=22, 
		Digit=23, NonzeroDigit=24, OctalDigit=25, HexadecimalDigit=26, Nondigit=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "WS", "DecimalConst", 
			"DC", "OctalConst", "OC", "HexadecimalConst", "HC", "Ident1", "Ident2", 
			"HexadecimalPrefix", "Digit", "NonzeroDigit", "OctalDigit", "HexadecimalDigit", 
			"Nondigit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'('", "')'", "'int'", "'{'", "'}'", "'='", "';'", "'return'", 
			"'const'", "','", "'+'", "'-'", "'*'", "'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "WS", "DecimalConst", "OctalConst", "HexadecimalConst", 
			"Ident1", "HexadecimalPrefix", "Digit", "NonzeroDigit", "OctalDigit", 
			"HexadecimalDigit", "Nondigit"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public lab3Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lab3.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00ae\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\6\22"+
		"q\n\22\r\22\16\22r\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\5\24}\n\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\5\26\u0085\n\26\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\5\30\u008e\n\30\3\31\3\31\3\31\3\32\3\32\3\32\5\32\u0096\n"+
		"\32\3\32\3\32\3\32\5\32\u009b\n\32\5\32\u009d\n\32\3\33\3\33\3\33\3\33"+
		"\5\33\u00a3\n\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \2\2!\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\2)\25+\2-\26/\2\61\27\63\2\65\30\67\319\32;\33=\34?"+
		"\35\3\2\5\5\2\13\f\17\17\"\"\5\2\62;CHch\5\2C\\aac|\2\u00b1\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2)\3\2\2\2\2-\3\2\2\2\2\61\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5F\3\2\2\2\7H\3\2\2"+
		"\2\tJ\3\2\2\2\13N\3\2\2\2\rP\3\2\2\2\17R\3\2\2\2\21T\3\2\2\2\23V\3\2\2"+
		"\2\25]\3\2\2\2\27c\3\2\2\2\31e\3\2\2\2\33g\3\2\2\2\35i\3\2\2\2\37k\3\2"+
		"\2\2!m\3\2\2\2#p\3\2\2\2%v\3\2\2\2\'|\3\2\2\2)~\3\2\2\2+\u0084\3\2\2\2"+
		"-\u0086\3\2\2\2/\u008d\3\2\2\2\61\u008f\3\2\2\2\63\u009c\3\2\2\2\65\u00a2"+
		"\3\2\2\2\67\u00a4\3\2\2\29\u00a6\3\2\2\2;\u00a8\3\2\2\2=\u00aa\3\2\2\2"+
		"?\u00ac\3\2\2\2AB\7o\2\2BC\7c\2\2CD\7k\2\2DE\7p\2\2E\4\3\2\2\2FG\7*\2"+
		"\2G\6\3\2\2\2HI\7+\2\2I\b\3\2\2\2JK\7k\2\2KL\7p\2\2LM\7v\2\2M\n\3\2\2"+
		"\2NO\7}\2\2O\f\3\2\2\2PQ\7\177\2\2Q\16\3\2\2\2RS\7?\2\2S\20\3\2\2\2TU"+
		"\7=\2\2U\22\3\2\2\2VW\7t\2\2WX\7g\2\2XY\7v\2\2YZ\7w\2\2Z[\7t\2\2[\\\7"+
		"p\2\2\\\24\3\2\2\2]^\7e\2\2^_\7q\2\2_`\7p\2\2`a\7u\2\2ab\7v\2\2b\26\3"+
		"\2\2\2cd\7.\2\2d\30\3\2\2\2ef\7-\2\2f\32\3\2\2\2gh\7/\2\2h\34\3\2\2\2"+
		"ij\7,\2\2j\36\3\2\2\2kl\7\61\2\2l \3\2\2\2mn\7\'\2\2n\"\3\2\2\2oq\t\2"+
		"\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\b\22\2\2u$\3"+
		"\2\2\2vw\59\35\2wx\5\'\24\2x&\3\2\2\2yz\5\67\34\2z{\5\'\24\2{}\3\2\2\2"+
		"|y\3\2\2\2|}\3\2\2\2}(\3\2\2\2~\177\7\62\2\2\177\u0080\5+\26\2\u0080*"+
		"\3\2\2\2\u0081\u0082\5;\36\2\u0082\u0083\5+\26\2\u0083\u0085\3\2\2\2\u0084"+
		"\u0081\3\2\2\2\u0084\u0085\3\2\2\2\u0085,\3\2\2\2\u0086\u0087\5\65\33"+
		"\2\u0087\u0088\5=\37\2\u0088\u0089\5/\30\2\u0089.\3\2\2\2\u008a\u008b"+
		"\5=\37\2\u008b\u008c\5/\30\2\u008c\u008e\3\2\2\2\u008d\u008a\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\60\3\2\2\2\u008f\u0090\5? \2\u0090\u0091\5\63\32"+
		"\2\u0091\62\3\2\2\2\u0092\u0093\5? \2\u0093\u0094\5\63\32\2\u0094\u0096"+
		"\3\2\2\2\u0095\u0092\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009d\3\2\2\2\u0097"+
		"\u0098\5\67\34\2\u0098\u0099\5\63\32\2\u0099\u009b\3\2\2\2\u009a\u0097"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u0095\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\64\3\2\2\2\u009e\u009f\7\62\2\2\u009f\u00a3\7z\2"+
		"\2\u00a0\u00a1\7\62\2\2\u00a1\u00a3\7Z\2\2\u00a2\u009e\3\2\2\2\u00a2\u00a0"+
		"\3\2\2\2\u00a3\66\3\2\2\2\u00a4\u00a5\4\62;\2\u00a58\3\2\2\2\u00a6\u00a7"+
		"\4\63;\2\u00a7:\3\2\2\2\u00a8\u00a9\4\629\2\u00a9<\3\2\2\2\u00aa\u00ab"+
		"\t\3\2\2\u00ab>\3\2\2\2\u00ac\u00ad\t\4\2\2\u00ad@\3\2\2\2\13\2r|\u0084"+
		"\u008d\u0095\u009a\u009c\u00a2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}