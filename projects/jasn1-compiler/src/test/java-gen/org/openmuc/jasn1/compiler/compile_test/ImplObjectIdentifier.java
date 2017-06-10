/**
 * This class file was automatically generated by jASN1 v1.7.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.compile_test;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;


public class ImplObjectIdentifier extends BerObjectIdentifier {

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 3);

	public ImplObjectIdentifier() {
	}

	public ImplObjectIdentifier(byte[] code) {
		super(code);
	}

	public ImplObjectIdentifier(int[] value) {
		super(value);
	}

	public int encode(BerByteArrayOutputStream os, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			if (withTag) {
				return tag.encode(os) + code.length;
			}
			return code.length;
		}

		int codeLength;

		codeLength = super.encode(os, false);
		if (withTag) {
			codeLength += tag.encode(os);
		}

		return codeLength;
	}

	public int decode(InputStream is, boolean withTag) throws IOException {

		int codeLength = 0;

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		codeLength += super.decode(is, false);

		return codeLength;
	}

}
