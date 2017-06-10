// $ANTLR 2.7.7 (20060906): "asn1.g" -> "ASNParser.java"$

package org.openmuc.jasn1.compiler.parser;

import org.openmuc.jasn1.compiler.model.*;
import java.math.*;
import java.util.*;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class ASNParser extends antlr.LLkParser       implements ASNTokenTypes
 {

protected ASNParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public ASNParser(TokenBuffer tokenBuf) {
  this(tokenBuf,3);
}

protected ASNParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public ASNParser(TokenStream lexer) {
  this(lexer,3);
}

public ASNParser(ParserSharedInputState state) {
  super(state,3);
  tokenNames = _tokenNames;
}

	public final void module_definitions(
		AsnModel model
	) throws RecognitionException, TokenStreamException {
		
		
		AsnModule module;
		
		
		try {      // for error handling
			{
			int _cnt79=0;
			_loop79:
			do {
				if ((LA(1)==UPPER)) {
					module=module_definition();
					if ( inputState.guessing==0 ) {
						model.modulesByName.put(module.moduleIdentifier.name, module);
					}
				}
				else {
					if ( _cnt79>=1 ) { break _loop79; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt79++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_0);
			} else {
			  throw ex;
			}
		}
	}
	
	public final AsnModule  module_definition() throws RecognitionException, TokenStreamException {
		AsnModule module;
		
		Token  e = null;
		Token  i = null;
		Token  a = null;
		
		module = new AsnModule();
			AsnModuleIdentifier mid;
			String s ;	
		
		
		try {      // for error handling
			{
			mid=module_identifier();
			if ( inputState.guessing==0 ) {
				module.moduleIdentifier = mid; 	
			}
			}
			match(DEFINITIONS_KW);
			{
			switch ( LA(1)) {
			case AUTOMATIC_KW:
			case EXPLICIT_KW:
			case IMPLICIT_KW:
			{
				{
				switch ( LA(1)) {
				case EXPLICIT_KW:
				{
					e = LT(1);
					match(EXPLICIT_KW);
					if ( inputState.guessing==0 ) {
						module.tagDefault = AsnModule.TagDefault.EXPLICIT;
					}
					break;
				}
				case IMPLICIT_KW:
				{
					i = LT(1);
					match(IMPLICIT_KW);
					if ( inputState.guessing==0 ) {
						module.tagDefault = AsnModule.TagDefault.IMPLICIT;
					}
					break;
				}
				case AUTOMATIC_KW:
				{
					a = LT(1);
					match(AUTOMATIC_KW);
					if ( inputState.guessing==0 ) {
						module.tagDefault = AsnModule.TagDefault.AUTOMATIC;
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(TAGS_KW);
				if ( inputState.guessing==0 ) {
					module.tag = true;
				}
				break;
			}
			case EXTENSIBILITY_KW:
			case ASSIGN_OP:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case EXTENSIBILITY_KW:
			{
				match(EXTENSIBILITY_KW);
				match(IMPLIED_KW);
				if ( inputState.guessing==0 ) {
					module.extensible=true;
				}
				break;
			}
			case ASSIGN_OP:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(ASSIGN_OP);
			match(BEGIN_KW);
			module_body(module);
			match(END_KW);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_1);
			} else {
			  throw ex;
			}
		}
		return module;
	}
	
	public final  AsnModuleIdentifier  module_identifier() throws RecognitionException, TokenStreamException {
		 AsnModuleIdentifier mid ;
		
		Token  md = null;
		mid = new AsnModuleIdentifier();
		AsnOidComponentList cmplst;
		
		try {      // for error handling
			{
			{
			md = LT(1);
			match(UPPER);
			if ( inputState.guessing==0 ) {
				mid.name = md.getText();
			}
			}
			{
			switch ( LA(1)) {
			case L_BRACE:
			{
				{
				cmplst=obj_id_comp_lst();
				if ( inputState.guessing==0 ) {
					mid.componentList = cmplst;
				}
				}
				break;
			}
			case DEFINITIONS_KW:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_2);
			} else {
			  throw ex;
			}
		}
		return mid ;
	}
	
	public final void module_body(
		AsnModule module
	) throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case EXPORTS_KW:
			{
				exports(module);
				break;
			}
			case END_KW:
			case IMPORTS_KW:
			case UPPER:
			case LOWER:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case IMPORTS_KW:
			{
				imports(module);
				break;
			}
			case END_KW:
			case UPPER:
			case LOWER:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case UPPER:
			case LOWER:
			{
				{
				int _cnt116=0;
				_loop116:
				do {
					if ((LA(1)==UPPER||LA(1)==LOWER)) {
						assignment(module);
					}
					else {
						if ( _cnt116>=1 ) { break _loop116; } else {throw new NoViableAltException(LT(1), getFilename());}
					}
					
					_cnt116++;
				} while (true);
				}
				break;
			}
			case END_KW:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_3);
			} else {
			  throw ex;
			}
		}
	}
	
	public final AsnOidComponentList  obj_id_comp_lst() throws RecognitionException, TokenStreamException {
		AsnOidComponentList oidcmplst;
		
		oidcmplst = new AsnOidComponentList();
		AsnOidComponent oidcmp; AsnDefinedValue defval;
		
		try {      // for error handling
			match(L_BRACE);
			{
			if ((LA(1)==UPPER||LA(1)==LOWER) && (_tokenSet_4.member(LA(2))) && (_tokenSet_5.member(LA(3)))) {
				defval=defined_value();
				if ( inputState.guessing==0 ) {
					oidcmplst.isDefinitive=true;oidcmplst.defval=defval;
				}
			}
			else if (((LA(1) >= NUMBER && LA(1) <= LOWER)) && (_tokenSet_5.member(LA(2))) && (_tokenSet_6.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			int _cnt93=0;
			_loop93:
			do {
				if (((LA(1) >= NUMBER && LA(1) <= LOWER))) {
					oidcmp=obj_id_component();
					if ( inputState.guessing==0 ) {
						oidcmplst.components.add(oidcmp);
					}
				}
				else {
					if ( _cnt93>=1 ) { break _loop93; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt93++;
			} while (true);
			}
			match(R_BRACE);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		return oidcmplst;
	}
	
	protected final AsnDefinedValue  defined_value() throws RecognitionException, TokenStreamException {
		AsnDefinedValue defval;
		
		Token  up = null;
		Token  lid = null;
		defval = new AsnDefinedValue();
		
		try {      // for error handling
			{
			{
			switch ( LA(1)) {
			case UPPER:
			{
				up = LT(1);
				match(UPPER);
				if ( inputState.guessing==0 ) {
					defval.moduleIdentifier = up.getText();
				}
				match(DOT);
				if ( inputState.guessing==0 ) {
					defval.isDotPresent=true;
				}
				break;
			}
			case LOWER:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			lid = LT(1);
			match(LOWER);
			if ( inputState.guessing==0 ) {
				defval.name = lid.getText();
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		return defval;
	}
	
	public final AsnOidComponent  obj_id_component() throws RecognitionException, TokenStreamException {
		AsnOidComponent oidcmp ;
		
		Token  num = null;
		Token  lid = null;
		Token  num1 = null;
		oidcmp = new AsnOidComponent(); AsnDefinedValue defval;
		String s,n ="";
		
		try {      // for error handling
			{
			if ((LA(1)==NUMBER)) {
				{
				num = LT(1);
				match(NUMBER);
				if ( inputState.guessing==0 ) {
					s=num.getText();oidcmp.num = new Integer(s); oidcmp.numberForm=true;
				}
				}
			}
			else {
				boolean synPredMatched99 = false;
				if (((LA(1)==LOWER) && (_tokenSet_9.member(LA(2))) && (_tokenSet_6.member(LA(3))))) {
					int _m99 = mark();
					synPredMatched99 = true;
					inputState.guessing++;
					try {
						{
						match(LOWER);
						{
						if ((LA(1)==L_PAREN)) {
							match(L_PAREN);
							match(NUMBER);
							match(R_PAREN);
						}
						else {
						}
						
						}
						}
					}
					catch (RecognitionException pe) {
						synPredMatched99 = false;
					}
					rewind(_m99);
inputState.guessing--;
				}
				if ( synPredMatched99 ) {
					{
					{
					lid = LT(1);
					match(LOWER);
					if ( inputState.guessing==0 ) {
						oidcmp.name = lid.getText();oidcmp.nameForm=true;
					}
					}
					{
					switch ( LA(1)) {
					case L_PAREN:
					{
						match(L_PAREN);
						{
						num1 = LT(1);
						match(NUMBER);
						if ( inputState.guessing==0 ) {
							n=num1.getText(); oidcmp.num = new Integer(n);oidcmp.nameAndNumberForm=true;
						}
						}
						match(R_PAREN);
						break;
					}
					case R_BRACE:
					case NUMBER:
					case UPPER:
					case LOWER:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					}
				}
				else {
					boolean synPredMatched105 = false;
					if (((LA(1)==UPPER||LA(1)==LOWER) && (_tokenSet_10.member(LA(2))) && (_tokenSet_6.member(LA(3))))) {
						int _m105 = mark();
						synPredMatched105 = true;
						inputState.guessing++;
						try {
							{
							defined_value();
							}
						}
						catch (RecognitionException pe) {
							synPredMatched105 = false;
						}
						rewind(_m105);
inputState.guessing--;
					}
					if ( synPredMatched105 ) {
						{
						defval=defined_value();
						if ( inputState.guessing==0 ) {
							oidcmp.isDefinedValue=true;oidcmp.defval=defval;
						}
						}
					}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}}
					}
				}
				catch (RecognitionException ex) {
					if (inputState.guessing==0) {
						reportError(ex);
						recover(ex,_tokenSet_11);
					} else {
					  throw ex;
					}
				}
				return oidcmp ;
			}
			
	public final String  tag_default() throws RecognitionException, TokenStreamException {
		String s;
		
		Token  tg = null;
		Token  tg1 = null;
		Token  tg2 = null;
		s = "";
		
		try {      // for error handling
			switch ( LA(1)) {
			case EXPLICIT_KW:
			{
				{
				tg = LT(1);
				match(EXPLICIT_KW);
				if ( inputState.guessing==0 ) {
					s = tg.getText();
				}
				}
				break;
			}
			case IMPLICIT_KW:
			{
				{
				tg1 = LT(1);
				match(IMPLICIT_KW);
				if ( inputState.guessing==0 ) {
					s = tg1.getText();
				}
				}
				break;
			}
			case AUTOMATIC_KW:
			{
				{
				tg2 = LT(1);
				match(AUTOMATIC_KW);
				if ( inputState.guessing==0 ) {
					s = tg2.getText();
				}
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_12);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final void exports(
		AsnModule module
	) throws RecognitionException, TokenStreamException {
		
		String s; ArrayList syml = new ArrayList();
		
		try {      // for error handling
			match(EXPORTS_KW);
			if ( inputState.guessing==0 ) {
				module.exported=true;
			}
			{
			switch ( LA(1)) {
			case ERROR_KW:
			case OBJECT_KW:
			case OPERATION_KW:
			case SEMI:
			case UPPER:
			case LOWER:
			case LITERAL_BIND:
			case LITERAL_UNBIND:
			case 134:
			case 135:
			case LITERAL_EXTENSION:
			case LITERAL_EXTENSIONS:
			case 138:
			case LITERAL_TOKEN:
			case 140:
			case 141:
			case LITERAL_PORT:
			case LITERAL_REFINE:
			case 144:
			case 145:
			case 146:
			case 147:
			case LITERAL_ALGORITHM:
			case LITERAL_ENCRYPTED:
			case LITERAL_SIGNED:
			case LITERAL_SIGNATURE:
			case LITERAL_PROTECTED:
			case 153:
			{
				{
				switch ( LA(1)) {
				case ERROR_KW:
				case OBJECT_KW:
				case OPERATION_KW:
				case UPPER:
				case LOWER:
				case LITERAL_BIND:
				case LITERAL_UNBIND:
				case 134:
				case 135:
				case LITERAL_EXTENSION:
				case LITERAL_EXTENSIONS:
				case 138:
				case LITERAL_TOKEN:
				case 140:
				case 141:
				case LITERAL_PORT:
				case LITERAL_REFINE:
				case 144:
				case 145:
				case 146:
				case 147:
				case LITERAL_ALGORITHM:
				case LITERAL_ENCRYPTED:
				case LITERAL_SIGNED:
				case LITERAL_SIGNATURE:
				case LITERAL_PROTECTED:
				case 153:
				{
					syml=symbol_list();
					if ( inputState.guessing==0 ) {
						module.exportSymbolList = syml;
					}
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				break;
			}
			case ALL_KW:
			{
				match(ALL_KW);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_13);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void imports(
		AsnModule module
	) throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			match(IMPORTS_KW);
			{
			switch ( LA(1)) {
			case ERROR_KW:
			case OBJECT_KW:
			case OPERATION_KW:
			case UPPER:
			case LOWER:
			case LITERAL_BIND:
			case LITERAL_UNBIND:
			case 134:
			case 135:
			case LITERAL_EXTENSION:
			case LITERAL_EXTENSIONS:
			case 138:
			case LITERAL_TOKEN:
			case 140:
			case 141:
			case LITERAL_PORT:
			case LITERAL_REFINE:
			case 144:
			case 145:
			case 146:
			case 147:
			case LITERAL_ALGORITHM:
			case LITERAL_ENCRYPTED:
			case LITERAL_SIGNED:
			case LITERAL_SIGNATURE:
			case LITERAL_PROTECTED:
			case 153:
			{
				{
				{
				int _cnt125=0;
				_loop125:
				do {
					if ((_tokenSet_14.member(LA(1)))) {
						symbols_from_module(module);
					}
					else {
						if ( _cnt125>=1 ) { break _loop125; } else {throw new NoViableAltException(LT(1), getFilename());}
					}
					
					_cnt125++;
				} while (true);
				}
				}
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			}
			if ( inputState.guessing==0 ) {
				module.imported=true;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void assignment(
		AsnModule module
	) throws RecognitionException, TokenStreamException {
		
		Token  up = null;
		Token  up2 = null;
		Object obj ; Object objv; AsnValueAssignment valueAssignment; AsnInformationObjectClass asnInformationObjectClass; List<AsnParameter> parameterListVal;
		
		try {      // for error handling
			if ((LA(1)==UPPER) && (LA(2)==ASSIGN_OP) && (_tokenSet_12.member(LA(3)))) {
				{
				up = LT(1);
				match(UPPER);
				match(ASSIGN_OP);
				{
				obj=type();
				}
				if ( inputState.guessing==0 ) {
					
					((AsnType)obj).name = up.getText();
					module.typesByName.put(((AsnType)obj).name,(AsnType)obj);
					
				}
				}
			}
			else if ((LA(1)==UPPER) && (LA(2)==L_BRACE)) {
				{
				up2 = LT(1);
				match(UPPER);
				{
				parameterListVal=parameterList();
				}
				match(ASSIGN_OP);
				{
				obj=type();
				}
				if ( inputState.guessing==0 ) {
					
					((AsnType)obj).name = up2.getText();
					((AsnType)obj).parameters = parameterListVal;
					module.typesByName.put(((AsnType)obj).name,(AsnType)obj);
					
				}
				}
			}
			else if ((LA(1)==LOWER)) {
				valueAssignment=valueAssignment();
				if ( inputState.guessing==0 ) {
					
					module.asnValueAssignmentsByName.put(valueAssignment.name, valueAssignment);
					
				}
			}
			else if ((LA(1)==UPPER) && (LA(2)==ASSIGN_OP) && (LA(3)==CLASS_KW)) {
				asnInformationObjectClass=informationObjectClass();
				if ( inputState.guessing==0 ) {
					
					module.objectClassesByName.put(asnInformationObjectClass.name,asnInformationObjectClass);
					
				}
			}
			else if ((LA(1)==UPPER) && (LA(2)==UPPER)) {
				match(UPPER);
				match(UPPER);
				match(ASSIGN_OP);
				constraint3();
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
	}
	
	public final ArrayList  symbol_list() throws RecognitionException, TokenStreamException {
		ArrayList symlist;
		
		symlist = new ArrayList(); String s="";
		
		try {      // for error handling
			{
			{
			s=symbol();
			if ( inputState.guessing==0 ) {
				symlist.add(s);
			}
			}
			{
			switch ( LA(1)) {
			case L_BRACE:
			{
				match(L_BRACE);
				match(R_BRACE);
				break;
			}
			case FROM_KW:
			case COMMA:
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			_loop141:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					{
					s=symbol();
					if ( inputState.guessing==0 ) {
						symlist.add(s);
					}
					}
					{
					switch ( LA(1)) {
					case L_BRACE:
					{
						match(L_BRACE);
						match(R_BRACE);
						break;
					}
					case FROM_KW:
					case COMMA:
					case SEMI:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
				}
				else {
					break _loop141;
				}
				
			} while (true);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_16);
			} else {
			  throw ex;
			}
		}
		return symlist;
	}
	
	public final void symbols_from_module(
		AsnModule module
	) throws RecognitionException, TokenStreamException {
		
		Token  up = null;
		SymbolsFromModule sym = new SymbolsFromModule();
		String s = "" ; AsnModuleIdentifier mid; AsnDefinedValue defval;
		ArrayList arl; AsnOidComponentList cmplist;
		
		try {      // for error handling
			{
			{
			arl=symbol_list();
			if ( inputState.guessing==0 ) {
				sym.symbolList = arl;
			}
			}
			match(FROM_KW);
			{
			up = LT(1);
			match(UPPER);
			if ( inputState.guessing==0 ) {
				sym.modref = up.getText();
			}
			{
			if ((LA(1)==L_BRACE)) {
				cmplist=obj_id_comp_lst();
				if ( inputState.guessing==0 ) {
					sym.isOidValue=true;sym.cmplist = cmplist;
				}
			}
			else {
				boolean synPredMatched132 = false;
				if (((LA(1)==UPPER||LA(1)==LOWER) && (_tokenSet_17.member(LA(2))) && (_tokenSet_18.member(LA(3))))) {
					int _m132 = mark();
					synPredMatched132 = true;
					inputState.guessing++;
					try {
						{
						defined_value();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched132 = false;
					}
					rewind(_m132);
inputState.guessing--;
				}
				if ( synPredMatched132 ) {
					{
					defval=defined_value();
					if ( inputState.guessing==0 ) {
						sym.isDefinedValue=true;sym.defval=defval;
					}
					}
				}
				else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_18.member(LA(2))) && (_tokenSet_20.member(LA(3)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				}
				}
				if ( inputState.guessing==0 ) {
					module.importSymbolFromModuleList.add(sym);
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_19);
				} else {
				  throw ex;
				}
			}
		}
		
	public final String  symbol() throws RecognitionException, TokenStreamException {
		String s;
		
		Token  up = null;
		Token  lid = null;
		s="";
		
		try {      // for error handling
			switch ( LA(1)) {
			case UPPER:
			{
				up = LT(1);
				match(UPPER);
				if ( inputState.guessing==0 ) {
					s = up.getText();
				}
				break;
			}
			case LOWER:
			{
				lid = LT(1);
				match(LOWER);
				if ( inputState.guessing==0 ) {
					s = lid.getText();
				}
				break;
			}
			case ERROR_KW:
			case OBJECT_KW:
			case OPERATION_KW:
			case LITERAL_BIND:
			case LITERAL_UNBIND:
			case 134:
			case 135:
			case LITERAL_EXTENSION:
			case LITERAL_EXTENSIONS:
			case 138:
			case LITERAL_TOKEN:
			case 140:
			case 141:
			case LITERAL_PORT:
			case LITERAL_REFINE:
			case 144:
			case 145:
			case 146:
			case 147:
			case LITERAL_ALGORITHM:
			case LITERAL_ENCRYPTED:
			case LITERAL_SIGNED:
			case LITERAL_SIGNATURE:
			case LITERAL_PROTECTED:
			case 153:
			{
				s=macroName();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_21);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final String  macroName() throws RecognitionException, TokenStreamException {
		String s;
		
		s="";
		
		try {      // for error handling
			switch ( LA(1)) {
			case OPERATION_KW:
			{
				match(OPERATION_KW);
				if ( inputState.guessing==0 ) {
					s = "OPERATION";
				}
				break;
			}
			case ERROR_KW:
			{
				match(ERROR_KW);
				if ( inputState.guessing==0 ) {
					s = "ERROR";
				}
				break;
			}
			case LITERAL_BIND:
			{
				match(LITERAL_BIND);
				if ( inputState.guessing==0 ) {
					s = "BIND";
				}
				break;
			}
			case LITERAL_UNBIND:
			{
				match(LITERAL_UNBIND);
				if ( inputState.guessing==0 ) {
					s = "UNBIND";
				}
				break;
			}
			case 134:
			{
				match(134);
				if ( inputState.guessing==0 ) {
					s = "APPLICATION-SERVICE-ELEMENT";
				}
				break;
			}
			case 135:
			{
				match(135);
				if ( inputState.guessing==0 ) {
					s = "APPLICATION-CONTEXT";
				}
				break;
			}
			case LITERAL_EXTENSION:
			{
				match(LITERAL_EXTENSION);
				if ( inputState.guessing==0 ) {
					s = "EXTENSION";
				}
				break;
			}
			case LITERAL_EXTENSIONS:
			{
				match(LITERAL_EXTENSIONS);
				if ( inputState.guessing==0 ) {
					s = "EXTENSIONS";
				}
				break;
			}
			case 138:
			{
				match(138);
				if ( inputState.guessing==0 ) {
					s = "EXTENSION-ATTRIBUTE";
				}
				break;
			}
			case LITERAL_TOKEN:
			{
				match(LITERAL_TOKEN);
				if ( inputState.guessing==0 ) {
					s = "TOKEN";
				}
				break;
			}
			case 140:
			{
				match(140);
				if ( inputState.guessing==0 ) {
					s = "TOKEN-DATA";
				}
				break;
			}
			case 141:
			{
				match(141);
				if ( inputState.guessing==0 ) {
					s = "SECURITY-CATEGORY";
				}
				break;
			}
			case OBJECT_KW:
			{
				match(OBJECT_KW);
				if ( inputState.guessing==0 ) {
					s = "OBJECT";
				}
				break;
			}
			case LITERAL_PORT:
			{
				match(LITERAL_PORT);
				if ( inputState.guessing==0 ) {
					s = "PORT";
				}
				break;
			}
			case LITERAL_REFINE:
			{
				match(LITERAL_REFINE);
				if ( inputState.guessing==0 ) {
					s = "REFINE";
				}
				break;
			}
			case 144:
			{
				match(144);
				if ( inputState.guessing==0 ) {
					s = "ABSTRACT-BIND";
				}
				break;
			}
			case 145:
			{
				match(145);
				if ( inputState.guessing==0 ) {
					s = "ABSTRACT-UNBIND";
				}
				break;
			}
			case 146:
			{
				match(146);
				if ( inputState.guessing==0 ) {
					s = "ABSTRACT-OPERATION";
				}
				break;
			}
			case 147:
			{
				match(147);
				if ( inputState.guessing==0 ) {
					s = "ABSTRACT-ERROR";
				}
				break;
			}
			case LITERAL_ALGORITHM:
			{
				match(LITERAL_ALGORITHM);
				if ( inputState.guessing==0 ) {
					s = "ALGORITHM";
				}
				break;
			}
			case LITERAL_ENCRYPTED:
			{
				match(LITERAL_ENCRYPTED);
				if ( inputState.guessing==0 ) {
					s = "ENCRYPTED";
				}
				break;
			}
			case LITERAL_SIGNED:
			{
				match(LITERAL_SIGNED);
				if ( inputState.guessing==0 ) {
					s = "SIGNED";
				}
				break;
			}
			case LITERAL_SIGNATURE:
			{
				match(LITERAL_SIGNATURE);
				if ( inputState.guessing==0 ) {
					s = "SIGNATURE";
				}
				break;
			}
			case LITERAL_PROTECTED:
			{
				match(LITERAL_PROTECTED);
				if ( inputState.guessing==0 ) {
					s = "PROTECTED";
				}
				break;
			}
			case 153:
			{
				match(153);
				if ( inputState.guessing==0 ) {
					s = "OBJECT-TYPE";
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_21);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final AsnType  type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		obj = null;
		
		try {      // for error handling
			if ((_tokenSet_22.member(LA(1)))) {
				{
				obj=built_in_type();
				}
			}
			else if ((LA(1)==AMPERSAND||LA(1)==UPPER||LA(1)==LOWER) && (_tokenSet_23.member(LA(2)))) {
				{
				obj=defined_type();
				}
			}
			else if ((LA(1)==LOWER) && (LA(2)==LESS)) {
				{
				obj=selection_type();
				}
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final List<AsnParameter>  parameterList() throws RecognitionException, TokenStreamException {
		List<AsnParameter> parameters;
		
		parameters = new ArrayList<AsnParameter>(); AsnParameter parameterVal;
		
		try {      // for error handling
			match(L_BRACE);
			parameterVal=parameter();
			if ( inputState.guessing==0 ) {
				parameters.add(parameterVal);
			}
			{
			_loop359:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					parameterVal=parameter();
					if ( inputState.guessing==0 ) {
						parameters.add(parameterVal);
					}
				}
				else {
					break _loop359;
				}
				
			} while (true);
			}
			match(R_BRACE);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_25);
			} else {
			  throw ex;
			}
		}
		return parameters;
	}
	
	public final AsnValueAssignment  valueAssignment() throws RecognitionException, TokenStreamException {
		AsnValueAssignment valueAssignment;
		
		Token  lid = null;
		Object valueType; AsnValue value; valueAssignment = new AsnValueAssignment();
		
		try {      // for error handling
			lid = LT(1);
			match(LOWER);
			{
			valueType=type();
			}
			match(ASSIGN_OP);
			{
			value=value2();
			}
			if ( inputState.guessing==0 ) {
				
				valueAssignment.name=lid.getText();
				valueAssignment.type = valueType;
				valueAssignment.value = value;
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
		return valueAssignment;
	}
	
	public final AsnInformationObjectClass  informationObjectClass() throws RecognitionException, TokenStreamException {
		AsnInformationObjectClass informationObjectClass;
		
		Token  up = null;
		informationObjectClass = new AsnInformationObjectClass(); List<AsnElementType> elementList; List<String> syntaxTokens;
		
		try {      // for error handling
			{
			up = LT(1);
			match(UPPER);
			if ( inputState.guessing==0 ) {
				informationObjectClass.name = up.getText();
			}
			match(ASSIGN_OP);
			match(CLASS_KW);
			match(L_BRACE);
			{
			switch ( LA(1)) {
			case AMPERSAND:
			case ELLIPSIS:
			{
				elementList=objectClassElements();
				if ( inputState.guessing==0 ) {
					informationObjectClass.elementList=elementList;
				}
				break;
			}
			case R_BRACE:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(R_BRACE);
			{
			switch ( LA(1)) {
			case WITH_KW:
			{
				match(WITH_KW);
				match(SYNTAX_KW);
				constraint3();
				break;
			}
			case END_KW:
			case UPPER:
			case LOWER:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
		return informationObjectClass;
	}
	
	public final AsnConstraint  constraint3() throws RecognitionException, TokenStreamException {
		AsnConstraint cnstrnt;
		
		cnstrnt=new AsnConstraint();
		
		try {      // for error handling
			match(L_BRACE);
			{
			_loop356:
			do {
				if ((LA(1)==L_BRACE)) {
					cnstrnt=constraint3();
				}
				else if ((_tokenSet_26.member(LA(1)))) {
					matchNot(R_BRACE);
				}
				else {
					break _loop356;
				}
				
			} while (true);
			}
			match(R_BRACE);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_27);
			} else {
			  throw ex;
			}
		}
		return cnstrnt;
	}
	
	public final AsnValue  value2() throws RecognitionException, TokenStreamException {
		AsnValue value;
		
		Token  c = null;
		value = new AsnValue(); AsnSequenceValue seqval;
		AsnDefinedValue defval;String aStr;AsnSignedNumber num; 
		AsnOidComponentList cmplst;List<String> valueInBracesTokens;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TRUE_KW:
			{
				{
				match(TRUE_KW);
				if ( inputState.guessing==0 ) {
					value.isTrueKW = true;
				}
				}
				break;
			}
			case FALSE_KW:
			{
				{
				match(FALSE_KW);
				if ( inputState.guessing==0 ) {
					value.isFalseKW = true;
				}
				}
				break;
			}
			case NULL_KW:
			{
				{
				match(NULL_KW);
				if ( inputState.guessing==0 ) {
					value.isNullKW = true;
				}
				}
				break;
			}
			case C_STRING:
			{
				{
				c = LT(1);
				match(C_STRING);
				if ( inputState.guessing==0 ) {
					value.isCString=true; value.cStr = c.getText();
				}
				}
				break;
			}
			case MINUS:
			case NUMBER:
			{
				{
				num=signed_number();
				if ( inputState.guessing==0 ) {
					value.isSignedNumber=true ; value.signedNumber = num;
				}
				}
				break;
			}
			case L_BRACE:
			{
				{
				valueInBracesTokens=valueInBraces();
				if ( inputState.guessing==0 ) {
					value.isValueInBraces=true;value.valueInBracesTokens = valueInBracesTokens;
				}
				}
				break;
			}
			case PLUS_INFINITY_KW:
			{
				{
				match(PLUS_INFINITY_KW);
				if ( inputState.guessing==0 ) {
					value.isPlusInfinity = true;
				}
				}
				break;
			}
			case MINUS_INFINITY_KW:
			{
				{
				match(MINUS_INFINITY_KW);
				if ( inputState.guessing==0 ) {
					value.isMinusInfinity = true;
				}
				}
				break;
			}
			default:
				boolean synPredMatched471 = false;
				if (((LA(1)==UPPER||LA(1)==LOWER) && (_tokenSet_28.member(LA(2))) && (_tokenSet_29.member(LA(3))))) {
					int _m471 = mark();
					synPredMatched471 = true;
					inputState.guessing++;
					try {
						{
						defined_value();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched471 = false;
					}
					rewind(_m471);
inputState.guessing--;
				}
				if ( synPredMatched471 ) {
					{
					defval=defined_value();
					if ( inputState.guessing==0 ) {
						value.isDefinedValue = true; value.definedValue = defval;
					}
					}
				}
				else {
					boolean synPredMatched477 = false;
					if (((LA(1)==LOWER) && (_tokenSet_30.member(LA(2))) && (_tokenSet_31.member(LA(3))))) {
						int _m477 = mark();
						synPredMatched477 = true;
						inputState.guessing++;
						try {
							{
							choice_value(value);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched477 = false;
						}
						rewind(_m477);
inputState.guessing--;
					}
					if ( synPredMatched477 ) {
						{
						choice_value(value);
						if ( inputState.guessing==0 ) {
							value.isChoiceValue = true;
						}
						}
					}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_15);
				} else {
				  throw ex;
				}
			}
			return value;
		}
		
	public final List<AsnElementType>  objectClassElements() throws RecognitionException, TokenStreamException {
		List<AsnElementType> elelist;
		
		elelist = new ArrayList<>(); AsnElementType eletyp; int i=1;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case ELLIPSIS:
			{
				match(ELLIPSIS);
				break;
			}
			case AMPERSAND:
			{
				eletyp=objectClassElement();
				if ( inputState.guessing==0 ) {
					if (eletyp.name.isEmpty()) {eletyp.name = "element" + i;};elelist.add(eletyp);i++;
				}
				{
				_loop165:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						{
						switch ( LA(1)) {
						case ELLIPSIS:
						{
							match(ELLIPSIS);
							break;
						}
						case AMPERSAND:
						{
							{
							eletyp=objectClassElement();
							if ( inputState.guessing==0 ) {
								if (eletyp.name.isEmpty()) {eletyp.name = "element" + i;};elelist.add(eletyp);i++;
							}
							}
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
					}
					else {
						break _loop165;
					}
					
				} while (true);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
		return elelist;
	}
	
	public final List<String>  syntaxTokens() throws RecognitionException, TokenStreamException {
		List<String> syntaxTokens;
		
		Token  up = null;
		Token  lo = null;
		Token  num = null;
		syntaxTokens = new ArrayList<String>();
		
		try {      // for error handling
			{
			_loop159:
			do {
				switch ( LA(1)) {
				case UPPER:
				{
					up = LT(1);
					match(UPPER);
					if ( inputState.guessing==0 ) {
						syntaxTokens.add(up.getText());
					}
					break;
				}
				case LOWER:
				{
					lo = LT(1);
					match(LOWER);
					if ( inputState.guessing==0 ) {
						syntaxTokens.add(lo.getText());
					}
					break;
				}
				case COMMA:
				{
					match(COMMA);
					if ( inputState.guessing==0 ) {
						syntaxTokens.add(",");
					}
					break;
				}
				case AMPERSAND:
				{
					match(AMPERSAND);
					if ( inputState.guessing==0 ) {
						syntaxTokens.add("&");
					}
					break;
				}
				case C_STRING:
				{
					match(C_STRING);
					break;
				}
				case DOT:
				{
					match(DOT);
					break;
				}
				case NULL_KW:
				{
					match(NULL_KW);
					break;
				}
				case BY_KW:
				{
					match(BY_KW);
					if ( inputState.guessing==0 ) {
						syntaxTokens.add("BY");
					}
					break;
				}
				case NUMBER:
				{
					num = LT(1);
					match(NUMBER);
					if ( inputState.guessing==0 ) {
						syntaxTokens.add(num.getText());
					}
					break;
				}
				case L_PAREN:
				{
					match(L_PAREN);
					if ( inputState.guessing==0 ) {
						syntaxTokens.add("(");
					}
					break;
				}
				case R_PAREN:
				{
					match(R_PAREN);
					if ( inputState.guessing==0 ) {
						syntaxTokens.add(")");
					}
					break;
				}
				default:
				{
					break _loop159;
				}
				}
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
		return syntaxTokens;
	}
	
	public final AsnElementType  objectClassElement() throws RecognitionException, TokenStreamException {
		AsnElementType eletyp;
		
		Token  lid = null;
		Token  up = null;
		eletyp = new AsnElementType();AsnValue val; 
		AsnType obj; AsnTag tg; String s;
		
		try {      // for error handling
			{
			if ((LA(1)==AMPERSAND) && (LA(2)==LOWER)) {
				{
				{
				{
				match(AMPERSAND);
				{
				lid = LT(1);
				match(LOWER);
				if ( inputState.guessing==0 ) {
					eletyp.name = lid.getText();
				}
				}
				{
				obj=type();
				}
				{
				switch ( LA(1)) {
				case UNIQUE_KW:
				{
					match(UNIQUE_KW);
					break;
				}
				case DEFAULT_KW:
				case OPTIONAL_KW:
				case COMMA:
				case R_BRACE:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case OPTIONAL_KW:
				{
					{
					match(OPTIONAL_KW);
					if ( inputState.guessing==0 ) {
						eletyp.isOptional=true;
					}
					}
					break;
				}
				case DEFAULT_KW:
				{
					{
					match(DEFAULT_KW);
					if ( inputState.guessing==0 ) {
						eletyp.isDefault = true;
					}
					val=value();
					if ( inputState.guessing==0 ) {
						eletyp.value = val;
					}
					}
					break;
				}
				case COMMA:
				case R_BRACE:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				}
				}
				if ( inputState.guessing==0 ) {
					
								if((AsnDefinedType.class).isInstance(obj)){
									eletyp.isDefinedType=true;
									eletyp.definedType = (AsnDefinedType)obj ; 
								} else{		
									eletyp.typeReference = obj;
								}
							
				}
				}
			}
			else if ((LA(1)==AMPERSAND) && (LA(2)==UPPER)) {
				{
				match(AMPERSAND);
				{
				up = LT(1);
				match(UPPER);
				if ( inputState.guessing==0 ) {
					eletyp.name = up.getText(); eletyp.typeReference = new AsnAny();
				}
				}
				}
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return eletyp;
	}
	
	public final AsnValue  value() throws RecognitionException, TokenStreamException {
		AsnValue value;
		
		Token  c = null;
		value = new AsnValue(); AsnSequenceValue seqval;
		AsnDefinedValue defval;String aStr;AsnSignedNumber num; 
		AsnOidComponentList cmplst;List<String> valueInBracesTokens;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TRUE_KW:
			{
				{
				match(TRUE_KW);
				if ( inputState.guessing==0 ) {
					value.isTrueKW = true;
				}
				}
				break;
			}
			case FALSE_KW:
			{
				{
				match(FALSE_KW);
				if ( inputState.guessing==0 ) {
					value.isFalseKW = true;
				}
				}
				break;
			}
			case NULL_KW:
			{
				{
				match(NULL_KW);
				if ( inputState.guessing==0 ) {
					value.isNullKW = true;
				}
				}
				break;
			}
			case C_STRING:
			{
				{
				c = LT(1);
				match(C_STRING);
				if ( inputState.guessing==0 ) {
					value.isCString=true; value.cStr = c.getText();
				}
				}
				break;
			}
			case MINUS:
			case NUMBER:
			{
				{
				num=signed_number();
				if ( inputState.guessing==0 ) {
					value.isSignedNumber=true ; value.signedNumber = num;
				}
				}
				break;
			}
			case PLUS_INFINITY_KW:
			{
				{
				match(PLUS_INFINITY_KW);
				if ( inputState.guessing==0 ) {
					value.isPlusInfinity = true;
				}
				}
				break;
			}
			case MINUS_INFINITY_KW:
			{
				{
				match(MINUS_INFINITY_KW);
				if ( inputState.guessing==0 ) {
					value.isMinusInfinity = true;
				}
				}
				break;
			}
			default:
				boolean synPredMatched431 = false;
				if (((LA(1)==UPPER||LA(1)==LOWER) && (_tokenSet_34.member(LA(2))) && (_tokenSet_35.member(LA(3))))) {
					int _m431 = mark();
					synPredMatched431 = true;
					inputState.guessing++;
					try {
						{
						defined_value();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched431 = false;
					}
					rewind(_m431);
inputState.guessing--;
				}
				if ( synPredMatched431 ) {
					{
					defval=defined_value();
					if ( inputState.guessing==0 ) {
						value.isDefinedValue = true; value.definedValue = defval;
					}
					}
				}
				else {
					boolean synPredMatched437 = false;
					if (((LA(1)==LOWER) && (_tokenSet_30.member(LA(2))) && (_tokenSet_36.member(LA(3))))) {
						int _m437 = mark();
						synPredMatched437 = true;
						inputState.guessing++;
						try {
							{
							choice_value(value);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched437 = false;
						}
						rewind(_m437);
inputState.guessing--;
					}
					if ( synPredMatched437 ) {
						{
						choice_value(value);
						if ( inputState.guessing==0 ) {
							value.isChoiceValue = true;
						}
						}
					}
					else {
						boolean synPredMatched440 = false;
						if (((LA(1)==L_BRACE) && (LA(2)==COMMA||LA(2)==R_BRACE||LA(2)==LOWER) && (_tokenSet_37.member(LA(3))))) {
							int _m440 = mark();
							synPredMatched440 = true;
							inputState.guessing++;
							try {
								{
								sequence_value();
								}
							}
							catch (RecognitionException pe) {
								synPredMatched440 = false;
							}
							rewind(_m440);
inputState.guessing--;
						}
						if ( synPredMatched440 ) {
							{
							seqval=sequence_value();
							if ( inputState.guessing==0 ) {
								value.isSequenceValue=true;value.seqval=seqval;
							}
							}
						}
						else {
							boolean synPredMatched443 = false;
							if (((LA(1)==L_BRACE) && (_tokenSet_38.member(LA(2))) && (_tokenSet_36.member(LA(3))))) {
								int _m443 = mark();
								synPredMatched443 = true;
								inputState.guessing++;
								try {
									{
									sequenceof_value(value);
									}
								}
								catch (RecognitionException pe) {
									synPredMatched443 = false;
								}
								rewind(_m443);
inputState.guessing--;
							}
							if ( synPredMatched443 ) {
								{
								sequenceof_value(value);
								if ( inputState.guessing==0 ) {
									value.isSequenceOfValue=true;
								}
								}
							}
							else {
								boolean synPredMatched446 = false;
								if (((LA(1)==L_BRACE||LA(1)==B_STRING||LA(1)==H_STRING) && (_tokenSet_37.member(LA(2))) && (_tokenSet_35.member(LA(3))))) {
									int _m446 = mark();
									synPredMatched446 = true;
									inputState.guessing++;
									try {
										{
										cstr_value(value);
										}
									}
									catch (RecognitionException pe) {
										synPredMatched446 = false;
									}
									rewind(_m446);
inputState.guessing--;
								}
								if ( synPredMatched446 ) {
									{
									cstr_value(value);
									if ( inputState.guessing==0 ) {
										value.isCStrValue = true;
									}
									}
								}
								else {
									boolean synPredMatched449 = false;
									if (((LA(1)==L_BRACE) && ((LA(2) >= NUMBER && LA(2) <= LOWER)) && (_tokenSet_5.member(LA(3))))) {
										int _m449 = mark();
										synPredMatched449 = true;
										inputState.guessing++;
										try {
											{
											obj_id_comp_lst();
											}
										}
										catch (RecognitionException pe) {
											synPredMatched449 = false;
										}
										rewind(_m449);
inputState.guessing--;
									}
									if ( synPredMatched449 ) {
										{
										cmplst=obj_id_comp_lst();
										if ( inputState.guessing==0 ) {
											value.isAsnOIDValue=true;value.oidval=cmplst;
										}
										}
									}
								else {
									throw new NoViableAltException(LT(1), getFilename());
								}
								}}}}}}
							}
							catch (RecognitionException ex) {
								if (inputState.guessing==0) {
									reportError(ex);
									recover(ex,_tokenSet_37);
								} else {
								  throw ex;
								}
							}
							return value;
						}
						
	public final AsnType  built_in_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		obj = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ANY_KW:
			{
				{
				obj=any_type();
				}
				break;
			}
			case BIT_KW:
			{
				{
				obj=bit_string_type();
				}
				break;
			}
			case BOOLEAN_KW:
			{
				{
				obj=boolean_type();
				}
				break;
			}
			case BMP_STR_KW:
			case CHARACTER_KW:
			case GENERALIZED_TIME_KW:
			case GENERAL_STR_KW:
			case GRAPHIC_STR_KW:
			case IA5_STRING_KW:
			case ISO646_STR_KW:
			case NUMERIC_STR_KW:
			case OBJECT_DESCRIPTOR_KW:
			case PRINTABLE_STR_KW:
			case TELETEX_STR_KW:
			case T61_STR_KW:
			case UNIVERSAL_STR_KW:
			case UTC_TIME_KW:
			case UTF8_STR_KW:
			case VIDEOTEX_STR_KW:
			case VISIBLE_STR_KW:
			case TIME_KW:
			case DATE_KW:
			case TIME_OF_DAY_KW:
			case DATE_TIME_KW:
			case DURATION_KW:
			{
				{
				obj=character_str_type();
				}
				break;
			}
			case CHOICE_KW:
			{
				{
				obj=choice_type();
				}
				break;
			}
			case EMBEDDED_KW:
			{
				{
				obj=embedded_type();
				}
				break;
			}
			case ENUMERATED_KW:
			{
				{
				obj=enum_type();
				}
				break;
			}
			case EXTERNAL_KW:
			{
				{
				obj=external_type();
				}
				break;
			}
			case INTEGER_KW:
			{
				{
				obj=integer_type();
				}
				break;
			}
			case NULL_KW:
			{
				{
				obj=null_type();
				}
				break;
			}
			case OBJECT_KW:
			{
				{
				obj=object_identifier_type();
				}
				break;
			}
			case OCTET_KW:
			{
				{
				obj=octetString_type();
				}
				break;
			}
			case REAL_KW:
			{
				{
				obj=real_type();
				}
				break;
			}
			case RELATIVE_KW:
			{
				{
				obj=relativeOid_type();
				}
				break;
			}
			case L_BRACKET:
			{
				{
				obj=tagged_type();
				}
				break;
			}
			default:
				if ((LA(1)==SEQUENCE_KW) && (LA(2)==L_BRACE) && (_tokenSet_39.member(LA(3)))) {
					{
					obj=sequence_type();
					}
				}
				else if ((LA(1)==SEQUENCE_KW) && (_tokenSet_40.member(LA(2))) && ((LA(3) >= ABSENT_KW && LA(3) <= PATTERN_KW))) {
					{
					obj=sequenceof_type();
					}
				}
				else if ((LA(1)==SET_KW) && (LA(2)==L_BRACE) && (_tokenSet_39.member(LA(3)))) {
					{
					obj=set_type();
					}
				}
				else if ((LA(1)==SET_KW) && (_tokenSet_40.member(LA(2))) && ((LA(3) >= ABSENT_KW && LA(3) <= PATTERN_KW))) {
					{
					obj=setof_type();
					}
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  defined_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		Token  up = null;
		Token  up1 = null;
		Token  lo = null;
		AsnDefinedType deftype = new AsnDefinedType();
		AsnConstraint cnstrnt; obj = null;
		
		try {      // for error handling
			{
			{
			if ((LA(1)==UPPER) && (LA(2)==DOT)) {
				up = LT(1);
				match(UPPER);
				if ( inputState.guessing==0 ) {
					deftype.moduleOrObjectClassReference = up.getText();
				}
				match(DOT);
			}
			else if ((LA(1)==AMPERSAND||LA(1)==UPPER||LA(1)==LOWER) && (_tokenSet_41.member(LA(2)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			switch ( LA(1)) {
			case AMPERSAND:
			{
				match(AMPERSAND);
				if ( inputState.guessing==0 ) {
					deftype.isObjectClassField = true;
				}
				break;
			}
			case UPPER:
			case LOWER:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case UPPER:
			{
				{
				up1 = LT(1);
				match(UPPER);
				if ( inputState.guessing==0 ) {
					deftype.typeName = up1.getText();
				}
				}
				break;
			}
			case LOWER:
			{
				{
				lo = LT(1);
				match(LOWER);
				if ( inputState.guessing==0 ) {
					deftype.typeName = lo.getText();
				}
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			if ((_tokenSet_41.member(LA(1))) && (_tokenSet_27.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
				cnstrnt=constraint();
				if ( inputState.guessing==0 ) {
					deftype.constraint = cnstrnt;
				}
			}
			else if ((_tokenSet_24.member(LA(1))) && (_tokenSet_42.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			}
			if ( inputState.guessing==0 ) {
				obj = deftype; deftype=null ; cnstrnt = null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  selection_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		Token  lid = null;
		AsnSelectionType seltype = new AsnSelectionType();
		obj = null;Object obj1;
		
		try {      // for error handling
			{
			{
			lid = LT(1);
			match(LOWER);
			if ( inputState.guessing==0 ) {
				seltype.selectionID = lid.getText();
			}
			}
			match(LESS);
			{
			obj1=type();
			if ( inputState.guessing==0 ) {
				seltype.type = obj1;
			}
			}
			}
			if ( inputState.guessing==0 ) {
				obj=seltype; seltype=null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnAny  any_type() throws RecognitionException, TokenStreamException {
		AsnAny an;
		
		Token  lid = null;
		an = new AsnAny();
		
		try {      // for error handling
			{
			match(ANY_KW);
			{
			switch ( LA(1)) {
			case DEFINED_KW:
			{
				match(DEFINED_KW);
				match(BY_KW);
				if ( inputState.guessing==0 ) {
					an.isDefinedBy = true ;
				}
				lid = LT(1);
				match(LOWER);
				if ( inputState.guessing==0 ) {
					an.definedByType = lid.getText();
				}
				break;
			}
			case EOF:
			case ANY_KW:
			case BIT_KW:
			case BMP_STR_KW:
			case BOOLEAN_KW:
			case CHARACTER_KW:
			case CHOICE_KW:
			case DEFAULT_KW:
			case EMBEDDED_KW:
			case END_KW:
			case ENUMERATED_KW:
			case EXTERNAL_KW:
			case FALSE_KW:
			case GENERALIZED_TIME_KW:
			case GENERAL_STR_KW:
			case GRAPHIC_STR_KW:
			case IA5_STRING_KW:
			case INTEGER_KW:
			case INTERSECTION_KW:
			case ISO646_STR_KW:
			case MINUS_INFINITY_KW:
			case NULL_KW:
			case NUMERIC_STR_KW:
			case OBJECT_DESCRIPTOR_KW:
			case OBJECT_KW:
			case OCTET_KW:
			case OPTIONAL_KW:
			case PLUS_INFINITY_KW:
			case PRINTABLE_STR_KW:
			case REAL_KW:
			case RELATIVE_KW:
			case SEQUENCE_KW:
			case SET_KW:
			case TELETEX_STR_KW:
			case TRUE_KW:
			case T61_STR_KW:
			case UNION_KW:
			case UNIQUE_KW:
			case UNIVERSAL_STR_KW:
			case UTC_TIME_KW:
			case UTF8_STR_KW:
			case VIDEOTEX_STR_KW:
			case VISIBLE_STR_KW:
			case TIME_KW:
			case DATE_KW:
			case TIME_OF_DAY_KW:
			case DATE_TIME_KW:
			case DURATION_KW:
			case ASSIGN_OP:
			case BAR:
			case COLON:
			case COMMA:
			case AMPERSAND:
			case INTERSECTION:
			case L_BRACE:
			case L_BRACKET:
			case MINUS:
			case R_BRACE:
			case R_PAREN:
			case NUMBER:
			case UPPER:
			case LOWER:
			case B_STRING:
			case H_STRING:
			case C_STRING:
			case EXCEPT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return an;
	}
	
	public final AsnBitString  bit_string_type() throws RecognitionException, TokenStreamException {
		AsnBitString obj;
		
		AsnBitString bstr = new AsnBitString(); 
		AsnNamedNumberList nnlst ; AsnConstraint cnstrnt;obj = null;
		
		try {      // for error handling
			{
			match(BIT_KW);
			match(STRING_KW);
			{
			if ((LA(1)==L_BRACE) && (LA(2)==ELLIPSIS||LA(2)==LOWER) && (LA(3)==COMMA||LA(3)==L_PAREN||LA(3)==R_BRACE)) {
				nnlst=namedNumber_list();
				if ( inputState.guessing==0 ) {
					bstr.namedNumberList = nnlst;
				}
			}
			else if ((_tokenSet_41.member(LA(1))) && (_tokenSet_27.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			if ((_tokenSet_41.member(LA(1))) && (_tokenSet_27.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
				cnstrnt=constraint();
				if ( inputState.guessing==0 ) {
					bstr.constraint = cnstrnt;
				}
			}
			else if ((_tokenSet_24.member(LA(1))) && (_tokenSet_42.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			}
			if ( inputState.guessing==0 ) {
				obj=bstr; nnlst = null ; cnstrnt = null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnBoolean  boolean_type() throws RecognitionException, TokenStreamException {
		AsnBoolean obj;
		
		obj = null;
		
		try {      // for error handling
			match(BOOLEAN_KW);
			if ( inputState.guessing==0 ) {
				obj = new AsnBoolean();
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnCharacterString  character_str_type() throws RecognitionException, TokenStreamException {
		AsnCharacterString obj;
		
		AsnCharacterString cstr = new AsnCharacterString();
		String s ; AsnConstraint cnstrnt; obj = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case CHARACTER_KW:
			{
				{
				match(CHARACTER_KW);
				match(STRING_KW);
				if ( inputState.guessing==0 ) {
					cstr.isUCSType = true;
				}
				}
				break;
			}
			case BMP_STR_KW:
			case GENERALIZED_TIME_KW:
			case GENERAL_STR_KW:
			case GRAPHIC_STR_KW:
			case IA5_STRING_KW:
			case ISO646_STR_KW:
			case NUMERIC_STR_KW:
			case OBJECT_DESCRIPTOR_KW:
			case PRINTABLE_STR_KW:
			case TELETEX_STR_KW:
			case T61_STR_KW:
			case UNIVERSAL_STR_KW:
			case UTC_TIME_KW:
			case UTF8_STR_KW:
			case VIDEOTEX_STR_KW:
			case VISIBLE_STR_KW:
			case TIME_KW:
			case DATE_KW:
			case TIME_OF_DAY_KW:
			case DATE_TIME_KW:
			case DURATION_KW:
			{
				{
				s=character_set();
				if ( inputState.guessing==0 ) {
					cstr.stringtype = s;
				}
				{
				if ((_tokenSet_41.member(LA(1))) && (_tokenSet_27.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
					cnstrnt=constraint();
					if ( inputState.guessing==0 ) {
						cstr.constraint = cnstrnt;
					}
				}
				else if ((_tokenSet_24.member(LA(1))) && (_tokenSet_42.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				obj = cstr; cnstrnt = null; cstr = null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnChoice  choice_type() throws RecognitionException, TokenStreamException {
		AsnChoice obj;
		
		AsnChoice ch = new AsnChoice(); List<AsnElementType> eltplst; 
		obj = null;
		
		try {      // for error handling
			{
			match(CHOICE_KW);
			match(L_BRACE);
			{
			eltplst=elementType_list();
			if ( inputState.guessing==0 ) {
				ch.componentTypes = eltplst ;
			}
			}
			match(R_BRACE);
			}
			if ( inputState.guessing==0 ) {
				obj = ch; eltplst = null; ch = null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnEmbeddedPdv  embedded_type() throws RecognitionException, TokenStreamException {
		AsnEmbeddedPdv obj;
		
		obj = null;
		
		try {      // for error handling
			{
			match(EMBEDDED_KW);
			match(PDV_KW);
			}
			if ( inputState.guessing==0 ) {
				obj = new AsnEmbeddedPdv();
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnEnum  enum_type() throws RecognitionException, TokenStreamException {
		AsnEnum obj;
		
		AsnEnum enumtyp = new AsnEnum() ;
		AsnNamedNumberList nnlst; obj = null;
		
		try {      // for error handling
			{
			match(ENUMERATED_KW);
			{
			nnlst=namedNumber_list();
			if ( inputState.guessing==0 ) {
				enumtyp.namedNumberList = nnlst;
			}
			}
			}
			if ( inputState.guessing==0 ) {
				obj = enumtyp ; enumtyp=null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  external_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		obj = null;
		
		try {      // for error handling
			match(EXTERNAL_KW);
			if ( inputState.guessing==0 ) {
				obj = new AsnExternal();
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  integer_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		AsnInteger intgr = new AsnInteger();
		AsnNamedNumberList numlst; AsnConstraint cnstrnt; obj=null;
		
		try {      // for error handling
			{
			match(INTEGER_KW);
			{
			if ((LA(1)==L_BRACE) && (LA(2)==ELLIPSIS||LA(2)==LOWER) && (LA(3)==COMMA||LA(3)==L_PAREN||LA(3)==R_BRACE)) {
				numlst=namedNumber_list();
				if ( inputState.guessing==0 ) {
					intgr.namedNumberList = numlst;
				}
			}
			else if ((_tokenSet_41.member(LA(1))) && (_tokenSet_27.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			if ((_tokenSet_41.member(LA(1))) && (_tokenSet_27.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
				cnstrnt=constraint();
				if ( inputState.guessing==0 ) {
					intgr.constraint = cnstrnt;
				}
			}
			else if ((_tokenSet_24.member(LA(1))) && (_tokenSet_42.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			}
			if ( inputState.guessing==0 ) {
				obj = intgr ; numlst = null ; cnstrnt = null; intgr = null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  null_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		AsnNull nll = new AsnNull(); obj = null;
		
		try {      // for error handling
			match(NULL_KW);
			if ( inputState.guessing==0 ) {
				obj = nll; nll = null ;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  object_identifier_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		AsnObjectIdentifier objident = new AsnObjectIdentifier(); obj = null;
		
		try {      // for error handling
			match(OBJECT_KW);
			match(IDENTIFIER_KW);
			if ( inputState.guessing==0 ) {
				obj = objident; objident = null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  octetString_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		AsnOctetString oct = new AsnOctetString();
		AsnConstraint cnstrnt ; obj = null;
		
		try {      // for error handling
			{
			match(OCTET_KW);
			match(STRING_KW);
			{
			if ((_tokenSet_41.member(LA(1))) && (_tokenSet_27.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
				cnstrnt=constraint();
				if ( inputState.guessing==0 ) {
					oct.constraint = cnstrnt;
				}
			}
			else if ((_tokenSet_24.member(LA(1))) && (_tokenSet_42.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			}
			if ( inputState.guessing==0 ) {
				obj = oct ; cnstrnt = null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  real_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		AsnReal rl = new AsnReal();obj = null;
		
		try {      // for error handling
			match(REAL_KW);
			if ( inputState.guessing==0 ) {
				obj = rl ; rl = null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  relativeOid_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		obj = null;
		
		try {      // for error handling
			match(RELATIVE_KW);
			match(MINUS);
			match(OID_KW);
			if ( inputState.guessing==0 ) {
				obj = new AsnRelativeOid();
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  sequence_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		AsnSequenceSet seq = new AsnSequenceSet();
		List<AsnElementType> eltplist ; AsnConstraint cnstrnt ; obj = null;
		
		try {      // for error handling
			{
			match(SEQUENCE_KW);
			if ( inputState.guessing==0 ) {
				seq.isSequence = true;
			}
			match(L_BRACE);
			{
			switch ( LA(1)) {
			case ANY_KW:
			case AUTOMATIC_KW:
			case BIT_KW:
			case BMP_STR_KW:
			case BOOLEAN_KW:
			case CHARACTER_KW:
			case CHOICE_KW:
			case COMPONENTS_KW:
			case EMBEDDED_KW:
			case ENUMERATED_KW:
			case EXPLICIT_KW:
			case EXTERNAL_KW:
			case GENERALIZED_TIME_KW:
			case GENERAL_STR_KW:
			case GRAPHIC_STR_KW:
			case IA5_STRING_KW:
			case IMPLICIT_KW:
			case INTEGER_KW:
			case ISO646_STR_KW:
			case NULL_KW:
			case NUMERIC_STR_KW:
			case OBJECT_DESCRIPTOR_KW:
			case OBJECT_KW:
			case OCTET_KW:
			case PRINTABLE_STR_KW:
			case REAL_KW:
			case RELATIVE_KW:
			case SEQUENCE_KW:
			case SET_KW:
			case TELETEX_STR_KW:
			case T61_STR_KW:
			case UNIVERSAL_STR_KW:
			case UTC_TIME_KW:
			case UTF8_STR_KW:
			case VIDEOTEX_STR_KW:
			case VISIBLE_STR_KW:
			case TIME_KW:
			case DATE_KW:
			case TIME_OF_DAY_KW:
			case DATE_TIME_KW:
			case DURATION_KW:
			case AMPERSAND:
			case ELLIPSIS:
			case L_BRACKET:
			case UPPER:
			case LOWER:
			{
				eltplist=elementType_list();
				if ( inputState.guessing==0 ) {
					seq.componentTypes = eltplist;
				}
				break;
			}
			case R_BRACE:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(R_BRACE);
			}
			if ( inputState.guessing==0 ) {
				obj = seq ; eltplist = null; seq =null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnSequenceOf  sequenceof_type() throws RecognitionException, TokenStreamException {
		AsnSequenceOf obj;
		
		AsnSequenceOf seqof = new AsnSequenceOf();
		AsnConstraint cnstrnt; obj = null; AsnElementType referencedAsnType ; String s ;
		
		try {      // for error handling
			{
			match(SEQUENCE_KW);
			if ( inputState.guessing==0 ) {
				seqof.isSequenceOf = true;
			}
			{
			if ((_tokenSet_40.member(LA(1))) && ((LA(2) >= ABSENT_KW && LA(2) <= PATTERN_KW)) && (_tokenSet_27.member(LA(3)))) {
				cnstrnt=constraint();
				if ( inputState.guessing==0 ) {
					seqof.constraint = cnstrnt;
				}
			}
			else if ((LA(1)==OF_KW) && (_tokenSet_43.member(LA(2))) && (_tokenSet_44.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			match(OF_KW);
			{
			referencedAsnType=sequenceof_component();
			if ( inputState.guessing==0 ) {
				
				seqof.componentType = referencedAsnType;
						
			}
			}
			}
			if ( inputState.guessing==0 ) {
				obj = seqof;  cnstrnt = null; seqof=null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  set_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		AsnSequenceSet set = new AsnSequenceSet();
		List<AsnElementType> eltplist ;obj = null;
		
		try {      // for error handling
			{
			match(SET_KW);
			match(L_BRACE);
			{
			switch ( LA(1)) {
			case ANY_KW:
			case AUTOMATIC_KW:
			case BIT_KW:
			case BMP_STR_KW:
			case BOOLEAN_KW:
			case CHARACTER_KW:
			case CHOICE_KW:
			case COMPONENTS_KW:
			case EMBEDDED_KW:
			case ENUMERATED_KW:
			case EXPLICIT_KW:
			case EXTERNAL_KW:
			case GENERALIZED_TIME_KW:
			case GENERAL_STR_KW:
			case GRAPHIC_STR_KW:
			case IA5_STRING_KW:
			case IMPLICIT_KW:
			case INTEGER_KW:
			case ISO646_STR_KW:
			case NULL_KW:
			case NUMERIC_STR_KW:
			case OBJECT_DESCRIPTOR_KW:
			case OBJECT_KW:
			case OCTET_KW:
			case PRINTABLE_STR_KW:
			case REAL_KW:
			case RELATIVE_KW:
			case SEQUENCE_KW:
			case SET_KW:
			case TELETEX_STR_KW:
			case T61_STR_KW:
			case UNIVERSAL_STR_KW:
			case UTC_TIME_KW:
			case UTF8_STR_KW:
			case VIDEOTEX_STR_KW:
			case VISIBLE_STR_KW:
			case TIME_KW:
			case DATE_KW:
			case TIME_OF_DAY_KW:
			case DATE_TIME_KW:
			case DURATION_KW:
			case AMPERSAND:
			case ELLIPSIS:
			case L_BRACKET:
			case UPPER:
			case LOWER:
			{
				eltplist=elementType_list();
				if ( inputState.guessing==0 ) {
					set.componentTypes = eltplist ;
				}
				break;
			}
			case R_BRACE:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(R_BRACE);
			}
			if ( inputState.guessing==0 ) {
				obj = set ; eltplist = null; set = null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  setof_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		AsnSequenceOf setof = new AsnSequenceOf(); setof.componentType = new AsnElementType();
		AsnConstraint cns; obj = null;
		Object obj1 ; String s;
		
		try {      // for error handling
			{
			match(SET_KW);
			{
			if ((_tokenSet_40.member(LA(1))) && ((LA(2) >= ABSENT_KW && LA(2) <= PATTERN_KW)) && (_tokenSet_27.member(LA(3)))) {
				cns=constraint();
				if ( inputState.guessing==0 ) {
					setof.constraint = cns ;
				}
			}
			else if ((LA(1)==OF_KW) && (_tokenSet_12.member(LA(2))) && (_tokenSet_45.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			match(OF_KW);
			{
			obj1=type();
			if ( inputState.guessing==0 ) {
					if((AsnDefinedType.class).isInstance(obj1)){
						  		setof.componentType.isDefinedType=true;
								setof.componentType.definedType = (AsnDefinedType)obj1; 
							}
							else{
								setof.componentType.typeReference = (AsnType) obj1;
							} 
						
			}
			}
			}
			if ( inputState.guessing==0 ) {
				obj = setof; cns = null; obj1=null; setof=null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnType  tagged_type() throws RecognitionException, TokenStreamException {
		AsnType obj;
		
		AsnTaggedType tgtyp = new AsnTaggedType();
		AsnTag tg; AsnType obj1 = null; String s; obj = null;
		
		try {      // for error handling
			{
			{
			tg=tag();
			if ( inputState.guessing==0 ) {
				tgtyp.tag = tg ;
			}
			}
			{
			switch ( LA(1)) {
			case AUTOMATIC_KW:
			case EXPLICIT_KW:
			case IMPLICIT_KW:
			{
				s=tag_default();
				if ( inputState.guessing==0 ) {
					tgtyp.tagType = s ;
				}
				break;
			}
			case ANY_KW:
			case BIT_KW:
			case BMP_STR_KW:
			case BOOLEAN_KW:
			case CHARACTER_KW:
			case CHOICE_KW:
			case EMBEDDED_KW:
			case ENUMERATED_KW:
			case EXTERNAL_KW:
			case GENERALIZED_TIME_KW:
			case GENERAL_STR_KW:
			case GRAPHIC_STR_KW:
			case IA5_STRING_KW:
			case INTEGER_KW:
			case ISO646_STR_KW:
			case NULL_KW:
			case NUMERIC_STR_KW:
			case OBJECT_DESCRIPTOR_KW:
			case OBJECT_KW:
			case OCTET_KW:
			case PRINTABLE_STR_KW:
			case REAL_KW:
			case RELATIVE_KW:
			case SEQUENCE_KW:
			case SET_KW:
			case TELETEX_STR_KW:
			case T61_STR_KW:
			case UNIVERSAL_STR_KW:
			case UTC_TIME_KW:
			case UTF8_STR_KW:
			case VIDEOTEX_STR_KW:
			case VISIBLE_STR_KW:
			case TIME_KW:
			case DATE_KW:
			case TIME_OF_DAY_KW:
			case DATE_TIME_KW:
			case DURATION_KW:
			case AMPERSAND:
			case L_BRACKET:
			case UPPER:
			case LOWER:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			obj1=type();
			if ( inputState.guessing==0 ) {
					if((AsnDefinedType.class).isInstance(obj1)){
						  		tgtyp.isDefinedType=true;
				tgtyp.definedType=(AsnDefinedType)obj1;
							}
							else{	
								tgtyp.typeReference = obj1; 
							} 
						
			}
			}
			}
			if ( inputState.guessing==0 ) {
				obj = tgtyp ; tg = null; obj1= null ;tgtyp = null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnNamedNumberList  namedNumber_list() throws RecognitionException, TokenStreamException {
		AsnNamedNumberList nnlist;
		
		nnlist = new AsnNamedNumberList();AsnNamedNumber nnum ;
		
		try {      // for error handling
			{
			match(L_BRACE);
			{
			switch ( LA(1)) {
			case ELLIPSIS:
			{
				match(ELLIPSIS);
				break;
			}
			case LOWER:
			{
				nnum=namedNumber();
				if ( inputState.guessing==0 ) {
					nnlist.namedNumbers.add(nnum);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			_loop341:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					{
					switch ( LA(1)) {
					case ELLIPSIS:
					{
						match(ELLIPSIS);
						break;
					}
					case LOWER:
					{
						{
						nnum=namedNumber();
						if ( inputState.guessing==0 ) {
							nnlist.namedNumbers.add(nnum);
						}
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
				}
				else {
					break _loop341;
				}
				
			} while (true);
			}
			match(R_BRACE);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_41);
			} else {
			  throw ex;
			}
		}
		return nnlist;
	}
	
	public final AsnConstraint  constraint() throws RecognitionException, TokenStreamException {
		AsnConstraint cnstrnt;
		
		cnstrnt=new AsnConstraint();
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case SIZE_KW:
			{
				match(SIZE_KW);
				if ( inputState.guessing==0 ) {
					cnstrnt.tokens.add("SIZE");
				}
				break;
			}
			case EOF:
			case ABSENT_KW:
			case ANY_KW:
			case BIT_KW:
			case BMP_STR_KW:
			case BOOLEAN_KW:
			case CHARACTER_KW:
			case CHOICE_KW:
			case DEFAULT_KW:
			case EMBEDDED_KW:
			case END_KW:
			case ENUMERATED_KW:
			case EXTERNAL_KW:
			case FALSE_KW:
			case GENERALIZED_TIME_KW:
			case GENERAL_STR_KW:
			case GRAPHIC_STR_KW:
			case IA5_STRING_KW:
			case INTEGER_KW:
			case INTERSECTION_KW:
			case ISO646_STR_KW:
			case MINUS_INFINITY_KW:
			case NULL_KW:
			case NUMERIC_STR_KW:
			case OBJECT_DESCRIPTOR_KW:
			case OBJECT_KW:
			case OCTET_KW:
			case OF_KW:
			case OPTIONAL_KW:
			case PLUS_INFINITY_KW:
			case PRESENT_KW:
			case PRINTABLE_STR_KW:
			case REAL_KW:
			case RELATIVE_KW:
			case SEQUENCE_KW:
			case SET_KW:
			case TELETEX_STR_KW:
			case TRUE_KW:
			case T61_STR_KW:
			case UNION_KW:
			case UNIQUE_KW:
			case UNIVERSAL_STR_KW:
			case UTC_TIME_KW:
			case UTF8_STR_KW:
			case VIDEOTEX_STR_KW:
			case VISIBLE_STR_KW:
			case TIME_KW:
			case DATE_KW:
			case TIME_OF_DAY_KW:
			case DATE_TIME_KW:
			case DURATION_KW:
			case ASSIGN_OP:
			case BAR:
			case COLON:
			case COMMA:
			case AMPERSAND:
			case INTERSECTION:
			case L_BRACE:
			case L_BRACKET:
			case L_PAREN:
			case MINUS:
			case R_BRACE:
			case R_PAREN:
			case NUMBER:
			case UPPER:
			case LOWER:
			case B_STRING:
			case H_STRING:
			case C_STRING:
			case EXCEPT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			_loop350:
			do {
				if ((LA(1)==L_PAREN)) {
					cnstrnt=constraint2();
				}
				else if ((LA(1)==L_BRACE) && ((LA(2) >= ABSENT_KW && LA(2) <= PATTERN_KW)) && (_tokenSet_27.member(LA(3)))) {
					cnstrnt=constraint3();
				}
				else {
					break _loop350;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_46);
			} else {
			  throw ex;
			}
		}
		return cnstrnt;
	}
	
	public final String  character_set() throws RecognitionException, TokenStreamException {
		String s;
		
		Token  s1 = null;
		Token  s2 = null;
		Token  s3 = null;
		Token  s4 = null;
		Token  s5 = null;
		Token  s6 = null;
		Token  s7 = null;
		Token  s8 = null;
		Token  s9 = null;
		Token  s10 = null;
		Token  s11 = null;
		Token  s12 = null;
		Token  s13 = null;
		Token  s14 = null;
		Token  s15 = null;
		Token  s16 = null;
		s = "";
		
		try {      // for error handling
			switch ( LA(1)) {
			case BMP_STR_KW:
			{
				{
				s1 = LT(1);
				match(BMP_STR_KW);
				if ( inputState.guessing==0 ) {
					s = s1.getText();
				}
				}
				break;
			}
			case GENERALIZED_TIME_KW:
			{
				{
				s2 = LT(1);
				match(GENERALIZED_TIME_KW);
				if ( inputState.guessing==0 ) {
					s = s2.getText();
				}
				}
				break;
			}
			case GENERAL_STR_KW:
			{
				{
				s3 = LT(1);
				match(GENERAL_STR_KW);
				if ( inputState.guessing==0 ) {
					s = s3.getText();
				}
				}
				break;
			}
			case GRAPHIC_STR_KW:
			{
				{
				s4 = LT(1);
				match(GRAPHIC_STR_KW);
				if ( inputState.guessing==0 ) {
					s = s4.getText();
				}
				}
				break;
			}
			case IA5_STRING_KW:
			{
				{
				s5 = LT(1);
				match(IA5_STRING_KW);
				if ( inputState.guessing==0 ) {
					s = s5.getText();
				}
				}
				break;
			}
			case ISO646_STR_KW:
			{
				{
				s6 = LT(1);
				match(ISO646_STR_KW);
				if ( inputState.guessing==0 ) {
					s = s6.getText();
				}
				}
				break;
			}
			case NUMERIC_STR_KW:
			{
				{
				s7 = LT(1);
				match(NUMERIC_STR_KW);
				if ( inputState.guessing==0 ) {
					s = s7.getText();
				}
				}
				break;
			}
			case PRINTABLE_STR_KW:
			{
				{
				s8 = LT(1);
				match(PRINTABLE_STR_KW);
				if ( inputState.guessing==0 ) {
					s = s8.getText();
				}
				}
				break;
			}
			case TELETEX_STR_KW:
			{
				{
				s9 = LT(1);
				match(TELETEX_STR_KW);
				if ( inputState.guessing==0 ) {
					s = s9.getText();
				}
				}
				break;
			}
			case T61_STR_KW:
			{
				{
				s10 = LT(1);
				match(T61_STR_KW);
				if ( inputState.guessing==0 ) {
					s = s10.getText();
				}
				}
				break;
			}
			case UNIVERSAL_STR_KW:
			{
				{
				s11 = LT(1);
				match(UNIVERSAL_STR_KW);
				if ( inputState.guessing==0 ) {
					s = s11.getText();
				}
				}
				break;
			}
			case UTF8_STR_KW:
			{
				{
				s12 = LT(1);
				match(UTF8_STR_KW);
				if ( inputState.guessing==0 ) {
					s = s12.getText();
				}
				}
				break;
			}
			case UTC_TIME_KW:
			{
				{
				s13 = LT(1);
				match(UTC_TIME_KW);
				if ( inputState.guessing==0 ) {
					s = "UtcTime";
				}
				}
				break;
			}
			case VIDEOTEX_STR_KW:
			{
				{
				s14 = LT(1);
				match(VIDEOTEX_STR_KW);
				if ( inputState.guessing==0 ) {
					s = s14.getText();
				}
				}
				break;
			}
			case VISIBLE_STR_KW:
			{
				{
				s15 = LT(1);
				match(VISIBLE_STR_KW);
				if ( inputState.guessing==0 ) {
					s = s15.getText();
				}
				}
				break;
			}
			case OBJECT_DESCRIPTOR_KW:
			{
				{
				s16 = LT(1);
				match(OBJECT_DESCRIPTOR_KW);
				if ( inputState.guessing==0 ) {
					s = s16.getText();
				}
				}
				break;
			}
			case TIME_KW:
			{
				{
				match(TIME_KW);
				if ( inputState.guessing==0 ) {
					s = "Time";
				}
				}
				break;
			}
			case DATE_KW:
			{
				{
				match(DATE_KW);
				if ( inputState.guessing==0 ) {
					s = "Date";
				}
				}
				break;
			}
			case TIME_OF_DAY_KW:
			{
				{
				match(TIME_OF_DAY_KW);
				if ( inputState.guessing==0 ) {
					s = "TimeOfDay";
				}
				}
				break;
			}
			case DATE_TIME_KW:
			{
				{
				match(DATE_TIME_KW);
				if ( inputState.guessing==0 ) {
					s = "DateTime";
				}
				}
				break;
			}
			case DURATION_KW:
			{
				{
				match(DURATION_KW);
				if ( inputState.guessing==0 ) {
					s = "Duration";
				}
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_41);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final List<AsnElementType>  elementType_list() throws RecognitionException, TokenStreamException {
		List<AsnElementType> elelist;
		
		elelist = new ArrayList<>(); AsnElementType eletyp; int i=1;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case ELLIPSIS:
			{
				match(ELLIPSIS);
				break;
			}
			case ANY_KW:
			case AUTOMATIC_KW:
			case BIT_KW:
			case BMP_STR_KW:
			case BOOLEAN_KW:
			case CHARACTER_KW:
			case CHOICE_KW:
			case COMPONENTS_KW:
			case EMBEDDED_KW:
			case ENUMERATED_KW:
			case EXPLICIT_KW:
			case EXTERNAL_KW:
			case GENERALIZED_TIME_KW:
			case GENERAL_STR_KW:
			case GRAPHIC_STR_KW:
			case IA5_STRING_KW:
			case IMPLICIT_KW:
			case INTEGER_KW:
			case ISO646_STR_KW:
			case NULL_KW:
			case NUMERIC_STR_KW:
			case OBJECT_DESCRIPTOR_KW:
			case OBJECT_KW:
			case OCTET_KW:
			case PRINTABLE_STR_KW:
			case REAL_KW:
			case RELATIVE_KW:
			case SEQUENCE_KW:
			case SET_KW:
			case TELETEX_STR_KW:
			case T61_STR_KW:
			case UNIVERSAL_STR_KW:
			case UTC_TIME_KW:
			case UTF8_STR_KW:
			case VIDEOTEX_STR_KW:
			case VISIBLE_STR_KW:
			case TIME_KW:
			case DATE_KW:
			case TIME_OF_DAY_KW:
			case DATE_TIME_KW:
			case DURATION_KW:
			case AMPERSAND:
			case L_BRACKET:
			case UPPER:
			case LOWER:
			{
				eletyp=elementType();
				if ( inputState.guessing==0 ) {
					if (eletyp.name.isEmpty()) {eletyp.name = "element" + i;};elelist.add(eletyp);i++;
				}
				{
				_loop323:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						{
						switch ( LA(1)) {
						case ELLIPSIS:
						{
							match(ELLIPSIS);
							break;
						}
						case ANY_KW:
						case AUTOMATIC_KW:
						case BIT_KW:
						case BMP_STR_KW:
						case BOOLEAN_KW:
						case CHARACTER_KW:
						case CHOICE_KW:
						case COMPONENTS_KW:
						case EMBEDDED_KW:
						case ENUMERATED_KW:
						case EXPLICIT_KW:
						case EXTERNAL_KW:
						case GENERALIZED_TIME_KW:
						case GENERAL_STR_KW:
						case GRAPHIC_STR_KW:
						case IA5_STRING_KW:
						case IMPLICIT_KW:
						case INTEGER_KW:
						case ISO646_STR_KW:
						case NULL_KW:
						case NUMERIC_STR_KW:
						case OBJECT_DESCRIPTOR_KW:
						case OBJECT_KW:
						case OCTET_KW:
						case PRINTABLE_STR_KW:
						case REAL_KW:
						case RELATIVE_KW:
						case SEQUENCE_KW:
						case SET_KW:
						case TELETEX_STR_KW:
						case T61_STR_KW:
						case UNIVERSAL_STR_KW:
						case UTC_TIME_KW:
						case UTF8_STR_KW:
						case VIDEOTEX_STR_KW:
						case VISIBLE_STR_KW:
						case TIME_KW:
						case DATE_KW:
						case TIME_OF_DAY_KW:
						case DATE_TIME_KW:
						case DURATION_KW:
						case AMPERSAND:
						case L_BRACKET:
						case UPPER:
						case LOWER:
						{
							{
							eletyp=elementType();
							if ( inputState.guessing==0 ) {
								if (eletyp.name.isEmpty()) {eletyp.name = "element" + i;};elelist.add(eletyp);i++;
							}
							}
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
					}
					else {
						break _loop323;
					}
					
				} while (true);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
		return elelist;
	}
	
	public final AsnElementType  sequenceof_component() throws RecognitionException, TokenStreamException {
		AsnElementType eletyp;
		
		Token  lid = null;
		eletyp = new AsnElementType();AsnValue val; 
		AsnType obj; AsnTag tg; String s;
		
		try {      // for error handling
			{
			{
			if ((LA(1)==LOWER) && (_tokenSet_43.member(LA(2))) && (_tokenSet_45.member(LA(3)))) {
				lid = LT(1);
				match(LOWER);
				if ( inputState.guessing==0 ) {
					eletyp.name = lid.getText();
				}
			}
			else if ((_tokenSet_43.member(LA(1))) && (_tokenSet_45.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			if ((LA(1)==L_BRACKET) && (_tokenSet_47.member(LA(2))) && (LA(3)==R_BRACKET||LA(3)==NUMBER||LA(3)==LOWER)) {
				tg=tag();
				if ( inputState.guessing==0 ) {
					eletyp.tag = tg ;
				}
			}
			else if ((_tokenSet_43.member(LA(1))) && (_tokenSet_45.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			switch ( LA(1)) {
			case AUTOMATIC_KW:
			case EXPLICIT_KW:
			case IMPLICIT_KW:
			{
				s=tag_default();
				if ( inputState.guessing==0 ) {
					eletyp.tagType = s ;
				}
				break;
			}
			case ANY_KW:
			case BIT_KW:
			case BMP_STR_KW:
			case BOOLEAN_KW:
			case CHARACTER_KW:
			case CHOICE_KW:
			case EMBEDDED_KW:
			case ENUMERATED_KW:
			case EXTERNAL_KW:
			case GENERALIZED_TIME_KW:
			case GENERAL_STR_KW:
			case GRAPHIC_STR_KW:
			case IA5_STRING_KW:
			case INTEGER_KW:
			case ISO646_STR_KW:
			case NULL_KW:
			case NUMERIC_STR_KW:
			case OBJECT_DESCRIPTOR_KW:
			case OBJECT_KW:
			case OCTET_KW:
			case PRINTABLE_STR_KW:
			case REAL_KW:
			case RELATIVE_KW:
			case SEQUENCE_KW:
			case SET_KW:
			case TELETEX_STR_KW:
			case T61_STR_KW:
			case UNIVERSAL_STR_KW:
			case UTC_TIME_KW:
			case UTF8_STR_KW:
			case VIDEOTEX_STR_KW:
			case VISIBLE_STR_KW:
			case TIME_KW:
			case DATE_KW:
			case TIME_OF_DAY_KW:
			case DATE_TIME_KW:
			case DURATION_KW:
			case AMPERSAND:
			case L_BRACKET:
			case UPPER:
			case LOWER:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			obj=type();
			}
			}
			if ( inputState.guessing==0 ) {
				
							if((AsnDefinedType.class).isInstance(obj)){
								eletyp.isDefinedType=true;
								eletyp.definedType = (AsnDefinedType)obj; 
							} else{		
								eletyp.typeReference = obj;
							}
						
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
		return eletyp;
	}
	
	public final AsnTag  tag() throws RecognitionException, TokenStreamException {
		AsnTag tg;
		
		tg = new AsnTag(); String s; AsnClassNumber cnum;
		
		try {      // for error handling
			{
			match(L_BRACKET);
			{
			switch ( LA(1)) {
			case APPLICATION_KW:
			case PRIVATE_KW:
			case UNIVERSAL_KW:
			{
				s=clazz();
				if ( inputState.guessing==0 ) {
					tg.clazz = s ;
				}
				break;
			}
			case NUMBER:
			case LOWER:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			cnum=class_NUMBER();
			if ( inputState.guessing==0 ) {
				tg.classNumber = cnum ;
			}
			}
			match(R_BRACKET);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_43);
			} else {
			  throw ex;
			}
		}
		return tg;
	}
	
	public final String  clazz() throws RecognitionException, TokenStreamException {
		String s;
		
		Token  c1 = null;
		Token  c2 = null;
		Token  c3 = null;
		s = "";
		
		try {      // for error handling
			switch ( LA(1)) {
			case UNIVERSAL_KW:
			{
				{
				c1 = LT(1);
				match(UNIVERSAL_KW);
				if ( inputState.guessing==0 ) {
					s= c1.getText();
				}
				}
				break;
			}
			case APPLICATION_KW:
			{
				{
				c2 = LT(1);
				match(APPLICATION_KW);
				if ( inputState.guessing==0 ) {
					s= c2.getText();
				}
				}
				break;
			}
			case PRIVATE_KW:
			{
				{
				c3 = LT(1);
				match(PRIVATE_KW);
				if ( inputState.guessing==0 ) {
					s= c3.getText();
				}
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_48);
			} else {
			  throw ex;
			}
		}
		return s;
	}
	
	public final AsnClassNumber  class_NUMBER() throws RecognitionException, TokenStreamException {
		AsnClassNumber cnum;
		
		Token  num = null;
		Token  lid = null;
		cnum = new AsnClassNumber() ; String s;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case NUMBER:
			{
				{
				num = LT(1);
				match(NUMBER);
				if ( inputState.guessing==0 ) {
					s=num.getText(); cnum.num = new Integer(s);
				}
				}
				break;
			}
			case LOWER:
			{
				{
				lid = LT(1);
				match(LOWER);
				if ( inputState.guessing==0 ) {
					s=lid.getText(); cnum.name = s ;
				}
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_49);
			} else {
			  throw ex;
			}
		}
		return cnum;
	}
	
	public final void typeorvaluelist(
		ObjectType objtype
	) throws RecognitionException, TokenStreamException {
		
		Object obj;
		
		try {      // for error handling
			{
			{
			obj=typeorvalue();
			if ( inputState.guessing==0 ) {
				objtype.elements.add(obj);
			}
			}
			{
			match(COMMA);
			{
			_loop312:
			do {
				if ((_tokenSet_50.member(LA(1)))) {
					obj=typeorvalue();
					if ( inputState.guessing==0 ) {
						objtype.elements.add(obj);
					}
				}
				else {
					break _loop312;
				}
				
			} while (true);
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_0);
			} else {
			  throw ex;
			}
		}
	}
	
	public final Object  typeorvalue() throws RecognitionException, TokenStreamException {
		Object obj;
		
		Object obj1; obj=null;
		
		try {      // for error handling
			{
			boolean synPredMatched316 = false;
			if (((_tokenSet_12.member(LA(1))) && (_tokenSet_51.member(LA(2))) && (_tokenSet_27.member(LA(3))))) {
				int _m316 = mark();
				synPredMatched316 = true;
				inputState.guessing++;
				try {
					{
					type();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched316 = false;
				}
				rewind(_m316);
inputState.guessing--;
			}
			if ( synPredMatched316 ) {
				{
				obj1=type();
				}
			}
			else if ((_tokenSet_52.member(LA(1))) && (_tokenSet_53.member(LA(2))) && (_tokenSet_54.member(LA(3)))) {
				obj1=value();
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			if ( inputState.guessing==0 ) {
				obj = obj1; obj1=null;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_55);
			} else {
			  throw ex;
			}
		}
		return obj;
	}
	
	public final AsnElementType  elementType() throws RecognitionException, TokenStreamException {
		AsnElementType eletyp;
		
		Token  lid = null;
		eletyp = new AsnElementType();AsnValue val; 
		AsnType obj; AsnTag tg; String s;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case ANY_KW:
			case AUTOMATIC_KW:
			case BIT_KW:
			case BMP_STR_KW:
			case BOOLEAN_KW:
			case CHARACTER_KW:
			case CHOICE_KW:
			case EMBEDDED_KW:
			case ENUMERATED_KW:
			case EXPLICIT_KW:
			case EXTERNAL_KW:
			case GENERALIZED_TIME_KW:
			case GENERAL_STR_KW:
			case GRAPHIC_STR_KW:
			case IA5_STRING_KW:
			case IMPLICIT_KW:
			case INTEGER_KW:
			case ISO646_STR_KW:
			case NULL_KW:
			case NUMERIC_STR_KW:
			case OBJECT_DESCRIPTOR_KW:
			case OBJECT_KW:
			case OCTET_KW:
			case PRINTABLE_STR_KW:
			case REAL_KW:
			case RELATIVE_KW:
			case SEQUENCE_KW:
			case SET_KW:
			case TELETEX_STR_KW:
			case T61_STR_KW:
			case UNIVERSAL_STR_KW:
			case UTC_TIME_KW:
			case UTF8_STR_KW:
			case VIDEOTEX_STR_KW:
			case VISIBLE_STR_KW:
			case TIME_KW:
			case DATE_KW:
			case TIME_OF_DAY_KW:
			case DATE_TIME_KW:
			case DURATION_KW:
			case AMPERSAND:
			case L_BRACKET:
			case UPPER:
			case LOWER:
			{
				{
				{
				if ((LA(1)==LOWER) && (_tokenSet_43.member(LA(2))) && (_tokenSet_56.member(LA(3)))) {
					lid = LT(1);
					match(LOWER);
					if ( inputState.guessing==0 ) {
						eletyp.name = lid.getText();
					}
				}
				else if ((_tokenSet_43.member(LA(1))) && (_tokenSet_56.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				{
				if ((LA(1)==L_BRACKET) && (_tokenSet_47.member(LA(2))) && (LA(3)==R_BRACKET||LA(3)==NUMBER||LA(3)==LOWER)) {
					tg=tag();
					if ( inputState.guessing==0 ) {
						eletyp.tag = tg ;
					}
				}
				else if ((_tokenSet_43.member(LA(1))) && (_tokenSet_56.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				{
				switch ( LA(1)) {
				case AUTOMATIC_KW:
				case EXPLICIT_KW:
				case IMPLICIT_KW:
				{
					s=tag_default();
					if ( inputState.guessing==0 ) {
						eletyp.tagType = s ;
					}
					break;
				}
				case ANY_KW:
				case BIT_KW:
				case BMP_STR_KW:
				case BOOLEAN_KW:
				case CHARACTER_KW:
				case CHOICE_KW:
				case EMBEDDED_KW:
				case ENUMERATED_KW:
				case EXTERNAL_KW:
				case GENERALIZED_TIME_KW:
				case GENERAL_STR_KW:
				case GRAPHIC_STR_KW:
				case IA5_STRING_KW:
				case INTEGER_KW:
				case ISO646_STR_KW:
				case NULL_KW:
				case NUMERIC_STR_KW:
				case OBJECT_DESCRIPTOR_KW:
				case OBJECT_KW:
				case OCTET_KW:
				case PRINTABLE_STR_KW:
				case REAL_KW:
				case RELATIVE_KW:
				case SEQUENCE_KW:
				case SET_KW:
				case TELETEX_STR_KW:
				case T61_STR_KW:
				case UNIVERSAL_STR_KW:
				case UTC_TIME_KW:
				case UTF8_STR_KW:
				case VIDEOTEX_STR_KW:
				case VISIBLE_STR_KW:
				case TIME_KW:
				case DATE_KW:
				case TIME_OF_DAY_KW:
				case DATE_TIME_KW:
				case DURATION_KW:
				case AMPERSAND:
				case L_BRACKET:
				case UPPER:
				case LOWER:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				obj=type();
				}
				{
				switch ( LA(1)) {
				case OPTIONAL_KW:
				{
					{
					match(OPTIONAL_KW);
					if ( inputState.guessing==0 ) {
						eletyp.isOptional=true;
					}
					}
					break;
				}
				case DEFAULT_KW:
				{
					{
					match(DEFAULT_KW);
					if ( inputState.guessing==0 ) {
						eletyp.isDefault = true;
					}
					val=value();
					if ( inputState.guessing==0 ) {
						eletyp.value = val;
					}
					}
					break;
				}
				case COMMA:
				case R_BRACE:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				}
				break;
			}
			case COMPONENTS_KW:
			{
				match(COMPONENTS_KW);
				match(OF_KW);
				if ( inputState.guessing==0 ) {
					eletyp.isComponentsOf = true;
				}
				{
				obj=type();
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
							if((AsnDefinedType.class).isInstance(obj)){
								eletyp.isDefinedType=true;
								eletyp.definedType = (AsnDefinedType)obj; 
							} else{		
								eletyp.typeReference = obj;
							}
						
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return eletyp;
	}
	
	public final AsnNamedNumber  namedNumber() throws RecognitionException, TokenStreamException {
		AsnNamedNumber nnum;
		
		Token  lid = null;
		nnum = new AsnNamedNumber() ;AsnSignedNumber i; 
		AsnDefinedValue s;	
		
		try {      // for error handling
			{
			lid = LT(1);
			match(LOWER);
			if ( inputState.guessing==0 ) {
				nnum.name = lid.getText();
			}
			{
			switch ( LA(1)) {
			case L_PAREN:
			{
				match(L_PAREN);
				{
				switch ( LA(1)) {
				case MINUS:
				case NUMBER:
				{
					i=signed_number();
					if ( inputState.guessing==0 ) {
						nnum.signedNumber = i;nnum.isSignedNumber=true;
					}
					break;
				}
				case UPPER:
				case LOWER:
				{
					{
					s=defined_value();
					if ( inputState.guessing==0 ) {
						nnum.definedValue=s;
					}
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(R_PAREN);
				break;
			}
			case COMMA:
			case R_BRACE:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return nnum;
	}
	
	public final AsnSignedNumber  signed_number() throws RecognitionException, TokenStreamException {
		AsnSignedNumber i;
		
		Token  n = null;
		i = new AsnSignedNumber() ; String s ;
		
		try {      // for error handling
			{
			{
			switch ( LA(1)) {
			case MINUS:
			{
				match(MINUS);
				if ( inputState.guessing==0 ) {
					i.positive=false;
				}
				break;
			}
			case NUMBER:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			n = LT(1);
			match(NUMBER);
			if ( inputState.guessing==0 ) {
				s = n.getText(); i.num= new BigInteger(s);
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_37);
			} else {
			  throw ex;
			}
		}
		return i;
	}
	
	public final AsnConstraint  constraint2() throws RecognitionException, TokenStreamException {
		AsnConstraint cnstrnt;
		
		cnstrnt=new AsnConstraint();
		
		try {      // for error handling
			match(L_PAREN);
			{
			_loop353:
			do {
				if ((LA(1)==L_PAREN)) {
					cnstrnt=constraint2();
				}
				else if ((_tokenSet_57.member(LA(1)))) {
					matchNot(R_PAREN);
				}
				else {
					break _loop353;
				}
				
			} while (true);
			}
			match(R_PAREN);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_27);
			} else {
			  throw ex;
			}
		}
		return cnstrnt;
	}
	
	public final AsnParameter  parameter() throws RecognitionException, TokenStreamException {
		AsnParameter parameter;
		
		Token  up = null;
		Token  lo = null;
		Token  up2 = null;
		Token  lo2 = null;
		parameter = new AsnParameter();
		
		try {      // for error handling
			if ((LA(1)==UPPER||LA(1)==LOWER) && (LA(2)==COLON||LA(2)==COMMA||LA(2)==R_BRACE) && (LA(3)==ASSIGN_OP||LA(3)==UPPER||LA(3)==LOWER)) {
				{
				if ((LA(1)==UPPER||LA(1)==LOWER) && (LA(2)==COLON)) {
					{
					switch ( LA(1)) {
					case UPPER:
					{
						{
						up = LT(1);
						match(UPPER);
						if ( inputState.guessing==0 ) {
							parameter.paramGovernor = up.getText();
						}
						}
						break;
					}
					case LOWER:
					{
						{
						lo = LT(1);
						match(LOWER);
						if ( inputState.guessing==0 ) {
							parameter.paramGovernor = lo.getText();
						}
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					match(COLON);
				}
				else if ((LA(1)==UPPER) && (LA(2)==COMMA||LA(2)==R_BRACE)) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				{
				up2 = LT(1);
				match(UPPER);
				if ( inputState.guessing==0 ) {
					parameter.dummyReference = up2.getText();
				}
				}
			}
			else if ((LA(1)==LOWER) && (LA(2)==COMMA||LA(2)==R_BRACE) && (LA(3)==ASSIGN_OP||LA(3)==UPPER||LA(3)==LOWER)) {
				{
				lo2 = LT(1);
				match(LOWER);
				if ( inputState.guessing==0 ) {
					parameter.dummyReference = lo2.getText();
				}
				}
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return parameter;
	}
	
	public final void exception_spec(
		AsnConstraint cnstrnt
	) throws RecognitionException, TokenStreamException {
		
		AsnSignedNumber signum; AsnDefinedValue defval;
		Object typ;AsnValue val;
		
		try {      // for error handling
			{
			match(EXCLAMATION);
			{
			boolean synPredMatched371 = false;
			if (((LA(1)==MINUS||LA(1)==NUMBER))) {
				int _m371 = mark();
				synPredMatched371 = true;
				inputState.guessing++;
				try {
					{
					signed_number();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched371 = false;
				}
				rewind(_m371);
inputState.guessing--;
			}
			if ( synPredMatched371 ) {
				{
				signum=signed_number();
				if ( inputState.guessing==0 ) {
					cnstrnt.isSignedNumber=true;cnstrnt.signedNumber=signum;
				}
				}
			}
			else {
				boolean synPredMatched374 = false;
				if (((LA(1)==UPPER||LA(1)==LOWER) && (LA(2)==EOF||LA(2)==DOT) && (LA(3)==EOF||LA(3)==LOWER))) {
					int _m374 = mark();
					synPredMatched374 = true;
					inputState.guessing++;
					try {
						{
						defined_value();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched374 = false;
					}
					rewind(_m374);
inputState.guessing--;
				}
				if ( synPredMatched374 ) {
					{
					defval=defined_value();
					if ( inputState.guessing==0 ) {
						cnstrnt.isDefinedValue=true;cnstrnt.definedValue=defval;
					}
					}
				}
				else if ((_tokenSet_12.member(LA(1))) && (_tokenSet_58.member(LA(2))) && ((LA(3) >= ABSENT_KW && LA(3) <= PATTERN_KW))) {
					typ=type();
					match(COLON);
					val=value();
					if ( inputState.guessing==0 ) {
						cnstrnt.isColonValue=true;cnstrnt.type=typ;cnstrnt.value=val;
					}
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				}
				if ( inputState.guessing==0 ) {
					cnstrnt.isExceptionSpec=true;
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_0);
				} else {
				  throw ex;
				}
			}
		}
		
	public final void element_set_specs(
		AsnConstraint cnstrnt
	) throws RecognitionException, TokenStreamException {
		
		ElementSetSpec elemspec;
		
		try {      // for error handling
			{
			elemspec=element_set_spec();
			if ( inputState.guessing==0 ) {
				
								cnstrnt.elemSetSpec=elemspec; // TODO - need list.add() func
						
			}
			{
			if ((LA(1)==COMMA) && (LA(2)==ELLIPSIS)) {
				match(COMMA);
				match(ELLIPSIS);
				if ( inputState.guessing==0 ) {
					cnstrnt.isCommaDotDot=true;
				}
			}
			else if ((LA(1)==EOF||LA(1)==COMMA) && (_tokenSet_59.member(LA(2)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			switch ( LA(1)) {
			case COMMA:
			{
				match(COMMA);
				elemspec=element_set_spec();
				if ( inputState.guessing==0 ) {
					cnstrnt.addElemSetSpec=elemspec;cnstrnt.isAdditionalElementSpec=true;
				}
				break;
			}
			case EOF:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_0);
			} else {
			  throw ex;
			}
		}
	}
	
	public final ElementSetSpec  element_set_spec() throws RecognitionException, TokenStreamException {
		ElementSetSpec elemspec;
		
		elemspec = new ElementSetSpec(); Intersection intersect;ConstraintElements cnselem;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ANY_KW:
			case BIT_KW:
			case BMP_STR_KW:
			case BOOLEAN_KW:
			case CHARACTER_KW:
			case CHOICE_KW:
			case EMBEDDED_KW:
			case ENUMERATED_KW:
			case EXTERNAL_KW:
			case FALSE_KW:
			case FROM_KW:
			case GENERALIZED_TIME_KW:
			case GENERAL_STR_KW:
			case GRAPHIC_STR_KW:
			case IA5_STRING_KW:
			case INTEGER_KW:
			case ISO646_STR_KW:
			case MINUS_INFINITY_KW:
			case MIN_KW:
			case NULL_KW:
			case NUMERIC_STR_KW:
			case OBJECT_DESCRIPTOR_KW:
			case OBJECT_KW:
			case OCTET_KW:
			case PLUS_INFINITY_KW:
			case PRINTABLE_STR_KW:
			case REAL_KW:
			case RELATIVE_KW:
			case SEQUENCE_KW:
			case SET_KW:
			case SIZE_KW:
			case TELETEX_STR_KW:
			case TRUE_KW:
			case T61_STR_KW:
			case UNIVERSAL_STR_KW:
			case UTC_TIME_KW:
			case UTF8_STR_KW:
			case VIDEOTEX_STR_KW:
			case VISIBLE_STR_KW:
			case WITH_KW:
			case TIME_KW:
			case DATE_KW:
			case TIME_OF_DAY_KW:
			case DATE_TIME_KW:
			case DURATION_KW:
			case AMPERSAND:
			case L_BRACE:
			case L_BRACKET:
			case L_PAREN:
			case MINUS:
			case NUMBER:
			case UPPER:
			case LOWER:
			case B_STRING:
			case H_STRING:
			case C_STRING:
			case INCLUDES:
			case PATTERN_KW:
			{
				intersect=intersections();
				if ( inputState.guessing==0 ) {
					elemspec.intersectionList.add(intersect);
				}
				{
				_loop383:
				do {
					if ((LA(1)==UNION_KW||LA(1)==BAR)) {
						{
						switch ( LA(1)) {
						case BAR:
						{
							match(BAR);
							break;
						}
						case UNION_KW:
						{
							match(UNION_KW);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						intersect=intersections();
						if ( inputState.guessing==0 ) {
							elemspec.intersectionList.add(intersect);
						}
					}
					else {
						break _loop383;
					}
					
				} while (true);
				}
				break;
			}
			case ALL_KW:
			{
				match(ALL_KW);
				match(EXCEPT_KW);
				cnselem=constraint_elements();
				if ( inputState.guessing==0 ) {
					elemspec.allExceptCnselem=cnselem;elemspec.isAllExcept=true;
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_60);
			} else {
			  throw ex;
			}
		}
		return elemspec;
	}
	
	public final Intersection  intersections() throws RecognitionException, TokenStreamException {
		Intersection intersect;
		
		intersect = new Intersection();ConstraintElements cnselem;
		
		try {      // for error handling
			cnselem=constraint_elements();
			if ( inputState.guessing==0 ) {
				intersect.cnsElemList.add(cnselem);
			}
			{
			switch ( LA(1)) {
			case EXCEPT:
			{
				match(EXCEPT);
				if ( inputState.guessing==0 ) {
					intersect.isExcept=true;
				}
				cnselem=constraint_elements();
				if ( inputState.guessing==0 ) {
					intersect.exceptCnsElem.add(cnselem);
				}
				break;
			}
			case EOF:
			case INTERSECTION_KW:
			case UNION_KW:
			case BAR:
			case COMMA:
			case INTERSECTION:
			case R_PAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			_loop389:
			do {
				if ((LA(1)==INTERSECTION_KW||LA(1)==INTERSECTION)) {
					{
					switch ( LA(1)) {
					case INTERSECTION:
					{
						match(INTERSECTION);
						break;
					}
					case INTERSECTION_KW:
					{
						match(INTERSECTION_KW);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						intersect.isInterSection=true;
					}
					cnselem=constraint_elements();
					if ( inputState.guessing==0 ) {
						intersect.cnsElemList.add(cnselem);
					}
					{
					switch ( LA(1)) {
					case EXCEPT:
					{
						match(EXCEPT);
						cnselem=constraint_elements();
						if ( inputState.guessing==0 ) {
							intersect.exceptCnsElem.add(cnselem);
						}
						break;
					}
					case EOF:
					case INTERSECTION_KW:
					case UNION_KW:
					case BAR:
					case COMMA:
					case INTERSECTION:
					case R_PAREN:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
				}
				else {
					break _loop389;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_61);
			} else {
			  throw ex;
			}
		}
		return intersect;
	}
	
	public final ConstraintElements  constraint_elements() throws RecognitionException, TokenStreamException {
		ConstraintElements cnsElem;
		
		cnsElem = new ConstraintElements(); AsnValue val;
		AsnConstraint cns; ElementSetSpec elespec;Object typ;
		
		try {      // for error handling
			switch ( LA(1)) {
			case SIZE_KW:
			{
				{
				match(SIZE_KW);
				cns=constraint();
				if ( inputState.guessing==0 ) {
					cnsElem.isSizeConstraint=true;cnsElem.constraint=cns;
				}
				}
				break;
			}
			case FROM_KW:
			{
				{
				match(FROM_KW);
				cns=constraint();
				if ( inputState.guessing==0 ) {
					cnsElem.isAlphabetConstraint=true;cnsElem.constraint=cns;
				}
				}
				break;
			}
			case L_PAREN:
			{
				{
				match(L_PAREN);
				elespec=element_set_spec();
				if ( inputState.guessing==0 ) {
					cnsElem.isElementSetSpec=true;cnsElem.elespec=elespec;
				}
				match(R_PAREN);
				}
				break;
			}
			case PATTERN_KW:
			{
				{
				match(PATTERN_KW);
				val=value();
				if ( inputState.guessing==0 ) {
					cnsElem.isPatternValue=true;cnsElem.value=val;
				}
				}
				break;
			}
			case WITH_KW:
			{
				{
				match(WITH_KW);
				{
				switch ( LA(1)) {
				case COMPONENT_KW:
				{
					{
					match(COMPONENT_KW);
					cns=constraint();
					if ( inputState.guessing==0 ) {
						cnsElem.isWithComponent=true;cnsElem.constraint=cns;
					}
					}
					break;
				}
				case COMPONENTS_KW:
				{
					{
					match(COMPONENTS_KW);
					if ( inputState.guessing==0 ) {
						cnsElem.isWithComponents=true;
					}
					match(L_BRACE);
					{
					switch ( LA(1)) {
					case ELLIPSIS:
					{
						match(ELLIPSIS);
						match(COMMA);
						break;
					}
					case LOWER:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					type_constraint_list(cnsElem);
					match(R_BRACE);
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				}
				break;
			}
			default:
				if ((_tokenSet_52.member(LA(1))) && (_tokenSet_62.member(LA(2))) && (_tokenSet_63.member(LA(3)))) {
					{
					val=value();
					if ( inputState.guessing==0 ) {
						cnsElem.isValue=true;cnsElem.value=val;
					}
					}
				}
				else {
					boolean synPredMatched393 = false;
					if (((_tokenSet_64.member(LA(1))) && (_tokenSet_65.member(LA(2))) && (_tokenSet_66.member(LA(3))))) {
						int _m393 = mark();
						synPredMatched393 = true;
						inputState.guessing++;
						try {
							{
							value_range(cnsElem);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched393 = false;
						}
						rewind(_m393);
inputState.guessing--;
					}
					if ( synPredMatched393 ) {
						{
						value_range(cnsElem);
						if ( inputState.guessing==0 ) {
							cnsElem.isValueRange=true;
						}
						}
					}
					else if ((_tokenSet_67.member(LA(1))) && (_tokenSet_68.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
						{
						{
						switch ( LA(1)) {
						case INCLUDES:
						{
							match(INCLUDES);
							if ( inputState.guessing==0 ) {
								cnsElem.isIncludeType=true;
							}
							break;
						}
						case ANY_KW:
						case BIT_KW:
						case BMP_STR_KW:
						case BOOLEAN_KW:
						case CHARACTER_KW:
						case CHOICE_KW:
						case EMBEDDED_KW:
						case ENUMERATED_KW:
						case EXTERNAL_KW:
						case GENERALIZED_TIME_KW:
						case GENERAL_STR_KW:
						case GRAPHIC_STR_KW:
						case IA5_STRING_KW:
						case INTEGER_KW:
						case ISO646_STR_KW:
						case NULL_KW:
						case NUMERIC_STR_KW:
						case OBJECT_DESCRIPTOR_KW:
						case OBJECT_KW:
						case OCTET_KW:
						case PRINTABLE_STR_KW:
						case REAL_KW:
						case RELATIVE_KW:
						case SEQUENCE_KW:
						case SET_KW:
						case TELETEX_STR_KW:
						case T61_STR_KW:
						case UNIVERSAL_STR_KW:
						case UTC_TIME_KW:
						case UTF8_STR_KW:
						case VIDEOTEX_STR_KW:
						case VISIBLE_STR_KW:
						case TIME_KW:
						case DATE_KW:
						case TIME_OF_DAY_KW:
						case DATE_TIME_KW:
						case DURATION_KW:
						case AMPERSAND:
						case L_BRACKET:
						case UPPER:
						case LOWER:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						typ=type();
						if ( inputState.guessing==0 ) {
							cnsElem.isTypeConstraint=true;cnsElem.type=typ;
						}
						}
					}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_69);
				} else {
				  throw ex;
				}
			}
			return cnsElem;
		}
		
	public final void value_range(
		ConstraintElements cnsElem
	) throws RecognitionException, TokenStreamException {
		
		AsnValue val;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case FALSE_KW:
			case MINUS_INFINITY_KW:
			case NULL_KW:
			case PLUS_INFINITY_KW:
			case TRUE_KW:
			case L_BRACE:
			case MINUS:
			case NUMBER:
			case UPPER:
			case LOWER:
			case B_STRING:
			case H_STRING:
			case C_STRING:
			{
				val=value();
				if ( inputState.guessing==0 ) {
					cnsElem.lEndValue=val;
				}
				break;
			}
			case MIN_KW:
			{
				match(MIN_KW);
				if ( inputState.guessing==0 ) {
					cnsElem.isMinKw=true;
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LESS:
			{
				match(LESS);
				if ( inputState.guessing==0 ) {
					cnsElem.isLEndLess=true;
				}
				break;
			}
			case DOTDOT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(DOTDOT);
			{
			switch ( LA(1)) {
			case LESS:
			{
				match(LESS);
				if ( inputState.guessing==0 ) {
					cnsElem.isUEndLess=true;
				}
				break;
			}
			case FALSE_KW:
			case MAX_KW:
			case MINUS_INFINITY_KW:
			case NULL_KW:
			case PLUS_INFINITY_KW:
			case TRUE_KW:
			case L_BRACE:
			case MINUS:
			case NUMBER:
			case UPPER:
			case LOWER:
			case B_STRING:
			case H_STRING:
			case C_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case FALSE_KW:
			case MINUS_INFINITY_KW:
			case NULL_KW:
			case PLUS_INFINITY_KW:
			case TRUE_KW:
			case L_BRACE:
			case MINUS:
			case NUMBER:
			case UPPER:
			case LOWER:
			case B_STRING:
			case H_STRING:
			case C_STRING:
			{
				val=value();
				if ( inputState.guessing==0 ) {
					cnsElem.uEndValue=val;
				}
				break;
			}
			case MAX_KW:
			{
				match(MAX_KW);
				if ( inputState.guessing==0 ) {
					cnsElem.isMaxKw=true;
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_69);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void type_constraint_list(
		ConstraintElements cnsElem
	) throws RecognitionException, TokenStreamException {
		
		NamedConstraint namecns;
		
		try {      // for error handling
			namecns=named_constraint();
			if ( inputState.guessing==0 ) {
				cnsElem.typeConstraintList.add(namecns);
			}
			{
			_loop413:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					namecns=named_constraint();
					if ( inputState.guessing==0 ) {
						cnsElem.typeConstraintList.add(namecns);
					}
				}
				else {
					break _loop413;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
	}
	
	public final NamedConstraint  named_constraint() throws RecognitionException, TokenStreamException {
		NamedConstraint namecns;
		
		Token  lid = null;
		namecns = new NamedConstraint(); AsnConstraint cns;
		
		try {      // for error handling
			lid = LT(1);
			match(LOWER);
			if ( inputState.guessing==0 ) {
				namecns.name=lid.getText();
			}
			{
			if ((_tokenSet_70.member(LA(1))) && (_tokenSet_27.member(LA(2))) && (_tokenSet_27.member(LA(3)))) {
				cns=constraint();
				if ( inputState.guessing==0 ) {
					namecns.isConstraint=true;namecns.constraint=cns;
				}
			}
			else if ((_tokenSet_71.member(LA(1))) && (_tokenSet_72.member(LA(2))) && (_tokenSet_73.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			switch ( LA(1)) {
			case PRESENT_KW:
			{
				match(PRESENT_KW);
				if ( inputState.guessing==0 ) {
					namecns.isPresentKw=true;
				}
				break;
			}
			case ABSENT_KW:
			{
				match(ABSENT_KW);
				if ( inputState.guessing==0 ) {
					namecns.isAbsentKw=true;
				}
				break;
			}
			case OPTIONAL_KW:
			{
				match(OPTIONAL_KW);
				if ( inputState.guessing==0 ) {
					namecns.isOptionalKw=true;
				}
				break;
			}
			case COMMA:
			case R_BRACE:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return namecns;
	}
	
	public final void choice_value(
		AsnValue value
	) throws RecognitionException, TokenStreamException {
		
		Token  lid = null;
		AsnChoiceValue chval = new AsnChoiceValue(); AsnValue val;
		
		try {      // for error handling
			{
			{
			lid = LT(1);
			match(LOWER);
			if ( inputState.guessing==0 ) {
				chval.name = lid.getText();
			}
			}
			{
			switch ( LA(1)) {
			case COLON:
			{
				match(COLON);
				break;
			}
			case FALSE_KW:
			case MINUS_INFINITY_KW:
			case NULL_KW:
			case PLUS_INFINITY_KW:
			case TRUE_KW:
			case L_BRACE:
			case MINUS:
			case NUMBER:
			case UPPER:
			case LOWER:
			case B_STRING:
			case H_STRING:
			case C_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			val=value();
			if ( inputState.guessing==0 ) {
				chval.value = val;
			}
			}
			}
			if ( inputState.guessing==0 ) {
				value.chval = chval;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_37);
			} else {
			  throw ex;
			}
		}
	}
	
	public final AsnSequenceValue  sequence_value() throws RecognitionException, TokenStreamException {
		AsnSequenceValue seqval;
		
		AsnNamedValue nameval = new AsnNamedValue();
		seqval = new AsnSequenceValue();
		
		try {      // for error handling
			match(L_BRACE);
			{
			{
			switch ( LA(1)) {
			case LOWER:
			{
				nameval=named_value();
				if ( inputState.guessing==0 ) {
					seqval.isValPresent=true;seqval.namedValueList.add(nameval);
				}
				break;
			}
			case COMMA:
			case R_BRACE:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			_loop542:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					nameval=named_value();
					if ( inputState.guessing==0 ) {
						seqval.namedValueList.add(nameval);
					}
				}
				else {
					break _loop542;
				}
				
			} while (true);
			}
			}
			match(R_BRACE);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_37);
			} else {
			  throw ex;
			}
		}
		return seqval;
	}
	
	public final void sequenceof_value(
		AsnValue value
	) throws RecognitionException, TokenStreamException {
		
		AsnValue val;value.seqOfVal = new AsnSequenceOfValue();
		
		try {      // for error handling
			match(L_BRACE);
			{
			{
			switch ( LA(1)) {
			case FALSE_KW:
			case MINUS_INFINITY_KW:
			case NULL_KW:
			case PLUS_INFINITY_KW:
			case TRUE_KW:
			case L_BRACE:
			case MINUS:
			case NUMBER:
			case UPPER:
			case LOWER:
			case B_STRING:
			case H_STRING:
			case C_STRING:
			{
				val=value();
				if ( inputState.guessing==0 ) {
					value.seqOfVal.value.add(val);
				}
				break;
			}
			case COMMA:
			case R_BRACE:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			_loop547:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					val=value();
					if ( inputState.guessing==0 ) {
						value.seqOfVal.value.add(val);
					}
				}
				else {
					break _loop547;
				}
				
			} while (true);
			}
			}
			match(R_BRACE);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_37);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void cstr_value(
		AsnValue value
	) throws RecognitionException, TokenStreamException {
		
		Token  h = null;
		Token  b = null;
		AsnBitOrOctetStringValue bstrval = new AsnBitOrOctetStringValue();
		AsnCharacterStringValue cstrval = new AsnCharacterStringValue();
		AsnSequenceValue seqval;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case H_STRING:
			{
				{
				h = LT(1);
				match(H_STRING);
				if ( inputState.guessing==0 ) {
					bstrval.isHString=true; bstrval.bhStr = h.getText();
				}
				}
				break;
			}
			case B_STRING:
			{
				{
				b = LT(1);
				match(B_STRING);
				if ( inputState.guessing==0 ) {
					bstrval.isBString=true; bstrval.bhStr = b.getText();
				}
				}
				break;
			}
			case L_BRACE:
			{
				{
				match(L_BRACE);
				{
				boolean synPredMatched501 = false;
				if (((LA(1)==LOWER) && (LA(2)==COMMA||LA(2)==R_BRACE) && (_tokenSet_37.member(LA(3))))) {
					int _m501 = mark();
					synPredMatched501 = true;
					inputState.guessing++;
					try {
						{
						id_list(bstrval);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched501 = false;
					}
					rewind(_m501);
inputState.guessing--;
				}
				if ( synPredMatched501 ) {
					{
					id_list(bstrval);
					}
				}
				else {
					boolean synPredMatched504 = false;
					if (((_tokenSet_74.member(LA(1))) && (_tokenSet_75.member(LA(2))) && (_tokenSet_37.member(LA(3))))) {
						int _m504 = mark();
						synPredMatched504 = true;
						inputState.guessing++;
						try {
							{
							char_defs_list(cstrval);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched504 = false;
						}
						rewind(_m504);
inputState.guessing--;
					}
					if ( synPredMatched504 ) {
						{
						char_defs_list(cstrval);
						}
					}
					else if ((LA(1)==MINUS||LA(1)==NUMBER)) {
						tuple_or_quad(cstrval);
					}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					match(R_BRACE);
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					value.cStrValue=cstrval;value.bStrValue=bstrval;
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_37);
				} else {
				  throw ex;
				}
			}
		}
		
	public final List<String>  valueInBraces() throws RecognitionException, TokenStreamException {
		List<String> valueInBracesTokens;
		
		List<String> syntaxTokens; valueInBracesTokens = new ArrayList<String>();
		
		try {      // for error handling
			{
			match(L_BRACE);
			{
			{
			syntaxTokens=syntaxTokens();
			if ( inputState.guessing==0 ) {
				valueInBracesTokens.addAll(syntaxTokens);
			}
			}
			}
			match(R_BRACE);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
		return valueInBracesTokens;
	}
	
	public final void id_list(
		AsnBitOrOctetStringValue bstrval
	) throws RecognitionException, TokenStreamException {
		
		Token  ld = null;
		Token  ld1 = null;
		String s="";
		
		try {      // for error handling
			{
			ld = LT(1);
			match(LOWER);
			if ( inputState.guessing==0 ) {
				s = ld.getText(); bstrval.idlist.add(s);
			}
			}
			{
			_loop509:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					ld1 = LT(1);
					match(LOWER);
					if ( inputState.guessing==0 ) {
						s = ld1.getText();bstrval.idlist.add(s);
					}
				}
				else {
					break _loop509;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void char_defs_list(
		AsnCharacterStringValue cstrval
	) throws RecognitionException, TokenStreamException {
		
		CharDef a ;
		
		try {      // for error handling
			a=char_defs();
			if ( inputState.guessing==0 ) {
				cstrval.isCharDefList = true;cstrval.charDefsList.add(a);
			}
			{
			_loop513:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					{
					a=char_defs();
					if ( inputState.guessing==0 ) {
						cstrval.charDefsList.add(a);
					}
					}
				}
				else {
					break _loop513;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void tuple_or_quad(
		AsnCharacterStringValue cstrval
	) throws RecognitionException, TokenStreamException {
		
		AsnSignedNumber n;
		
		try {      // for error handling
			{
			n=signed_number();
			if ( inputState.guessing==0 ) {
				cstrval.tupleQuad.add(n);
			}
			}
			match(COMMA);
			{
			n=signed_number();
			if ( inputState.guessing==0 ) {
				cstrval.tupleQuad.add(n);
			}
			}
			{
			switch ( LA(1)) {
			case R_BRACE:
			{
				{
				match(R_BRACE);
				if ( inputState.guessing==0 ) {
					cstrval.isTuple=true;
				}
				}
				break;
			}
			case COMMA:
			{
				{
				match(COMMA);
				{
				n=signed_number();
				if ( inputState.guessing==0 ) {
					cstrval.tupleQuad.add(n);
				}
				}
				match(COMMA);
				{
				n=signed_number();
				if ( inputState.guessing==0 ) {
					cstrval.tupleQuad.add(n);
				}
				}
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
	}
	
	public final CharDef  char_defs() throws RecognitionException, TokenStreamException {
		CharDef chardef;
		
		Token  c = null;
		chardef = new CharDef(); 
		AsnSignedNumber n ; AsnDefinedValue defval;
		
		try {      // for error handling
			switch ( LA(1)) {
			case C_STRING:
			{
				{
				c = LT(1);
				match(C_STRING);
				if ( inputState.guessing==0 ) {
					chardef.isCString = true;chardef.cStr=c.getText();
				}
				}
				break;
			}
			case L_BRACE:
			{
				{
				match(L_BRACE);
				{
				n=signed_number();
				if ( inputState.guessing==0 ) {
					chardef.tupleQuad.add(n);
				}
				}
				match(COMMA);
				{
				n=signed_number();
				if ( inputState.guessing==0 ) {
					chardef.tupleQuad.add(n);
				}
				}
				{
				switch ( LA(1)) {
				case R_BRACE:
				{
					{
					match(R_BRACE);
					if ( inputState.guessing==0 ) {
						chardef.isTuple=true;
					}
					}
					break;
				}
				case COMMA:
				{
					{
					match(COMMA);
					{
					n=signed_number();
					if ( inputState.guessing==0 ) {
						chardef.tupleQuad.add(n);
					}
					}
					match(COMMA);
					{
					n=signed_number();
					if ( inputState.guessing==0 ) {
						chardef.tupleQuad.add(n);
					}
					}
					match(R_BRACE);
					if ( inputState.guessing==0 ) {
						chardef.isQuadruple=true;
					}
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				}
				break;
			}
			case UPPER:
			case LOWER:
			{
				{
				defval=defined_value();
				if ( inputState.guessing==0 ) {
					chardef.defval=defval;
				}
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return chardef;
	}
	
	public final AsnNamedValue  named_value() throws RecognitionException, TokenStreamException {
		AsnNamedValue nameval;
		
		Token  lid = null;
		nameval = new AsnNamedValue(); AsnValue val;
		
		try {      // for error handling
			{
			lid = LT(1);
			match(LOWER);
			if ( inputState.guessing==0 ) {
				nameval.name = lid.getText();
			}
			val=value();
			if ( inputState.guessing==0 ) {
				nameval.value = val;
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return nameval;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"ABSENT\"",
		"\"ALL\"",
		"\"ANY\"",
		"\"ARGUMENT\"",
		"\"APPLICATION\"",
		"\"AUTOMATIC\"",
		"\"BASEDNUM\"",
		"\"BEGIN\"",
		"\"BIT\"",
		"\"BMPString\"",
		"\"BOOLEAN\"",
		"\"BY\"",
		"\"CHARACTER\"",
		"\"CHOICE\"",
		"\"CLASS\"",
		"\"COMPONENTS\"",
		"\"COMPONENT\"",
		"\"CONSTRAINED\"",
		"\"DEFAULT\"",
		"\"DEFINED\"",
		"\"DEFINITIONS\"",
		"\"EMBEDDED\"",
		"\"END\"",
		"\"ENUMERATED\"",
		"\"ERROR\"",
		"\"ERRORS\"",
		"\"EXCEPT\"",
		"\"EXPLICIT\"",
		"\"EXPORTS\"",
		"\"EXTENSIBILITY\"",
		"\"EXTERNAL\"",
		"\"FALSE\"",
		"\"FROM\"",
		"\"GeneralizedTime\"",
		"\"GeneralString\"",
		"\"GraphicString\"",
		"\"IA5String\"",
		"\"IDENTIFIER\"",
		"\"IMPLICIT\"",
		"\"IMPLIED\"",
		"\"IMPORTS\"",
		"\"INCLUDES\"",
		"\"INSTANCE\"",
		"\"INTEGER\"",
		"\"INTERSECTION\"",
		"\"ISO646String\"",
		"\"LINKED\"",
		"\"MAX\"",
		"\"MINUSINFINITY\"",
		"\"MIN\"",
		"\"NULL\"",
		"\"NumericString\"",
		"\"ObjectDescriptor\"",
		"\"OBJECT\"",
		"\"OCTET\"",
		"\"OPERATION\"",
		"\"OF\"",
		"\"OID\"",
		"\"OPTIONAL\"",
		"\"PARAMETER\"",
		"\"PDV\"",
		"\"PLUSINFINITY\"",
		"\"PRESENT\"",
		"\"PrintableString\"",
		"\"PRIVATE\"",
		"\"REAL\"",
		"\"RELATIVE\"",
		"\"RESULT\"",
		"\"SEQUENCE\"",
		"\"SET\"",
		"\"SIZE\"",
		"\"STRING\"",
		"\"SYNTAX\"",
		"\"TAGS\"",
		"\"TeletexString\"",
		"\"TRUE\"",
		"\"T61String\"",
		"\"UNION\"",
		"\"UNIQUE\"",
		"\"UNIVERSAL\"",
		"\"UniversalString\"",
		"\"UTCTime\"",
		"\"UTF8String\"",
		"\"VideotexString\"",
		"\"VisibleString\"",
		"\"WITH\"",
		"\"TIME\"",
		"\"DATE\"",
		"\"TIME-OF-DAY\"",
		"\"DATE-TIME\"",
		"\"DURATION\"",
		"ASSIGN_OP",
		"BAR",
		"COLON",
		"COMMA",
		"COMMENT",
		"DOT",
		"AMPERSAND",
		"DOTDOT",
		"ELLIPSIS",
		"EXCLAMATION",
		"INTERSECTION",
		"LESS",
		"L_BRACE",
		"L_BRACKET",
		"L_PAREN",
		"MINUS",
		"PLUS",
		"R_BRACE",
		"R_BRACKET",
		"R_PAREN",
		"SEMI",
		"SINGLE_QUOTE",
		"CHARB",
		"CHARH",
		"AT_SIGN",
		"WS",
		"SL_COMMENT",
		"ML_COMMENT",
		"NUMBER",
		"UPPER",
		"LOWER",
		"BDIG",
		"HDIG",
		"B_OR_H_STRING",
		"B_STRING",
		"H_STRING",
		"C_STRING",
		"\"BIND\"",
		"\"UNBIND\"",
		"\"APPLICATION-SERVICE-ELEMENT\"",
		"\"APPLICATION-CONTEXT\"",
		"\"EXTENSION\"",
		"\"EXTENSIONS\"",
		"\"EXTENSION-ATTRIBUTE\"",
		"\"TOKEN\"",
		"\"TOKEN-DATA\"",
		"\"SECURITY-CATEGORY\"",
		"\"PORT\"",
		"\"REFINE\"",
		"\"ABSTRACT-BIND\"",
		"\"ABSTRACT-UNBIND\"",
		"\"ABSTRACT-OPERATION\"",
		"\"ABSTRACT-ERROR\"",
		"\"ALGORITHM\"",
		"\"ENCRYPTED\"",
		"\"SIGNED\"",
		"\"SIGNATURE\"",
		"\"PROTECTED\"",
		"\"OBJECT-TYPE\"",
		"EXCEPT",
		"INCLUDES",
		"PATTERN_KW"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 2L, 1152921504606846976L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 16777216L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 67108864L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 0L, 4035225334843441152L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 0L, 4035541994192240640L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 1140397981787451458L, 4039023483910603626L, 134217726L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 1140397981787451458L, 4038988230819038058L, 134217726L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 1140397981770674242L, 4038988230819038058L, 134217726L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 0L, 4035541925472763904L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 0L, 4035506809820151808L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 0L, 4035506741100675072L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 559152120167886912L, 3458782245558502248L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 17592253153280L, 3458764513820540928L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 720575940647714816L, 3458764513820540928L, 67108848L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { 67108864L, 3458764513820540928L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = { 68719476736L, 2251799813685248L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { 720575940647714816L, 3461016382353702912L, 67108848L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { 68786585600L, 3458773327093432320L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 720575940647714816L, 3461016313634226176L, 67108848L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { 1135612872739745858L, 3459072518775718760L, 67108848L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = { 68719476736L, 2260613086576640L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = { 559152120167886912L, 17594299007848L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = { 5175623247630397506L, 4036767021910181738L, 67108878L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = { 5175623247630397506L, 4036731768818615146L, 67108878L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = { 0L, 2147483648L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = new long[8];
		data[0]=-16L;
		data[1]=-290271069732865L;
		data[2]=536870911L;
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = new long[8];
		data[0]=-14L;
		data[1]=-1L;
		data[2]=536870911L;
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = { 67108864L, 3458764582540017664L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = { 559152120167886914L, 3458791043799008104L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = { 22518032496590848L, 4035304439551131650L, 14L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = { 22518032563699712L, 4035586000427188226L, 14L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = { 0L, 281474976710656L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = { 0L, 281492156579840L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	private static final long[] mk_tokenSet_34() {
		long[] data = { 563937229198815298L, 4036736499724829546L, 67108878L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	private static final long[] mk_tokenSet_35() {
		long[] data = { 6339810419251311458L, 4036772244624494459L, 469762062L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	private static final long[] mk_tokenSet_36() {
		long[] data = { 563937229198815298L, 4036736508314764138L, 67108878L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	private static final long[] mk_tokenSet_37() {
		long[] data = { 563937229198815298L, 4036736431005352810L, 67108878L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	private static final long[] mk_tokenSet_38() {
		long[] data = { 22518032496590848L, 4035585923117776898L, 14L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	private static final long[] mk_tokenSet_39() {
		long[] data = { 559156520362406464L, 3459064270291026792L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());
	private static final long[] mk_tokenSet_40() {
		long[] data = { 1152921504606846976L, 43980465112064L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());
	private static final long[] mk_tokenSet_41() {
		long[] data = { 5175623247630397506L, 4036766953190705002L, 67108878L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());
	private static final long[] mk_tokenSet_42() {
		long[] data = { 6337558619437626210L, 4036771969746587515L, 469762062L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());
	private static final long[] mk_tokenSet_43() {
		long[] data = { 559156520361882176L, 3458782245558502248L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());
	private static final long[] mk_tokenSet_44() {
		long[] data = { 6328551351462884162L, 4036771419957219195L, 67108878L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());
	private static final long[] mk_tokenSet_45() {
		long[] data = { 6328546951268888898L, 4036771419957219195L, 67108878L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());
	private static final long[] mk_tokenSet_46() {
		long[] data = { 6328544752237244498L, 4036731768818615150L, 67108878L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());
	private static final long[] mk_tokenSet_47() {
		long[] data = { 256L, 2882303761517641744L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());
	private static final long[] mk_tokenSet_48() {
		long[] data = { 0L, 2882303761517117440L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_48 = new BitSet(mk_tokenSet_48());
	private static final long[] mk_tokenSet_49() {
		long[] data = { 0L, 562949953421312L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_49 = new BitSet(mk_tokenSet_49());
	private static final long[] mk_tokenSet_50() {
		long[] data = { 563655754154995776L, 4035322162699158378L, 14L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_50 = new BitSet(mk_tokenSet_50());
	private static final long[] mk_tokenSet_51() {
		long[] data = { 1716579457793487170L, 4035361831017631611L, 14L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_51 = new BitSet(mk_tokenSet_51());
	private static final long[] mk_tokenSet_52() {
		long[] data = { 22518032496590848L, 4035304430961197058L, 14L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_52 = new BitSet(mk_tokenSet_52());
	private static final long[] mk_tokenSet_53() {
		long[] data = { 563655754154995778L, 4035603732165149546L, 14L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_53 = new BitSet(mk_tokenSet_53());
	private static final long[] mk_tokenSet_54() {
		long[] data = { 1716579457793487170L, 4035643314584276859L, 14L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_54 = new BitSet(mk_tokenSet_54());
	private static final long[] mk_tokenSet_55() {
		long[] data = { 563655754154995778L, 4035322179879027562L, 14L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_55 = new BitSet(mk_tokenSet_55());
	private static final long[] mk_tokenSet_56() {
		long[] data = { 6323761842237960512L, 4035643305994309497L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_56 = new BitSet(mk_tokenSet_56());
	private static final long[] mk_tokenSet_57() {
		long[] data = new long[8];
		data[0]=-16L;
		data[1]=-1161084278931457L;
		data[2]=536870911L;
		return data;
	}
	public static final BitSet _tokenSet_57 = new BitSet(mk_tokenSet_57());
	private static final long[] mk_tokenSet_58() {
		long[] data = { 1152923703638491392L, 4035344090689702929L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_58 = new BitSet(mk_tokenSet_58());
	private static final long[] mk_tokenSet_59() {
		long[] data = { 572663022129213538L, 4035357347104802666L, 402653198L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_59 = new BitSet(mk_tokenSet_59());
	private static final long[] mk_tokenSet_60() {
		long[] data = { 2L, 1125917086711808L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_60 = new BitSet(mk_tokenSet_60());
	private static final long[] mk_tokenSet_61() {
		long[] data = { 2L, 1125921381810176L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_61 = new BitSet(mk_tokenSet_61());
	private static final long[] mk_tokenSet_62() {
		long[] data = { 22799507473301506L, 4036714103652384770L, 67108878L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_62 = new BitSet(mk_tokenSet_62());
	private static final long[] mk_tokenSet_63() {
		long[] data = { 572944497105924194L, 4036767569551804266L, 469762062L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_63 = new BitSet(mk_tokenSet_63());
	private static final long[] mk_tokenSet_64() {
		long[] data = { 31525231751331840L, 4035304430961197058L, 14L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_64 = new BitSet(mk_tokenSet_64());
	private static final long[] mk_tokenSet_65() {
		long[] data = { 22518032496590848L, 4035590673351606274L, 14L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_65 = new BitSet(mk_tokenSet_65());
	private static final long[] mk_tokenSet_66() {
		long[] data = { 24769832310276096L, 4035625857723695106L, 14L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_66 = new BitSet(mk_tokenSet_66());
	private static final long[] mk_tokenSet_67() {
		long[] data = { 559152120167886912L, 3458782245558502248L, 134217728L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_67 = new BitSet(mk_tokenSet_67());
	private static final long[] mk_tokenSet_68() {
		long[] data = { 1712357298783088962L, 4036489934242795385L, 67108864L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_68 = new BitSet(mk_tokenSet_68());
	private static final long[] mk_tokenSet_69() {
		long[] data = { 281474976710658L, 1128120405065728L, 67108864L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_69 = new BitSet(mk_tokenSet_69());
	private static final long[] mk_tokenSet_70() {
		long[] data = { 4611686018427387920L, 325472621691908L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_70 = new BitSet(mk_tokenSet_70());
	private static final long[] mk_tokenSet_71() {
		long[] data = { 4611686018427387920L, 281492156579844L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_71 = new BitSet(mk_tokenSet_71());
	private static final long[] mk_tokenSet_72() {
		long[] data = { 281474976710658L, 2307252604595470336L, 67108864L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_72 = new BitSet(mk_tokenSet_72());
	private static final long[] mk_tokenSet_73() {
		long[] data = { 5184630515533312114L, 4036767492242392942L, 469762062L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_73 = new BitSet(mk_tokenSet_73());
	private static final long[] mk_tokenSet_74() {
		long[] data = { 0L, 3458773309913563136L, 8L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_74 = new BitSet(mk_tokenSet_74());
	private static final long[] mk_tokenSet_75() {
		long[] data = { 0L, 576812681923657728L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_75 = new BitSet(mk_tokenSet_75());
	
	}
