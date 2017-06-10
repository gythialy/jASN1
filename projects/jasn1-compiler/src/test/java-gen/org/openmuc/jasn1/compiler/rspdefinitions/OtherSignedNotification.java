/**
 * This class file was automatically generated by jASN1 v1.7.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.rspdefinitions;

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

import org.openmuc.jasn1.compiler.pkix1explicit88.*;
import org.openmuc.jasn1.compiler.pkix1implicit88.*;

public class OtherSignedNotification {

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public NotificationMetadata tbsOtherNotification = null;
	public BerOctetString euiccNotificationSignature = null;
	public Certificate euiccCertificate = null;
	public Certificate eumCertificate = null;
	
	public OtherSignedNotification() {
	}

	public OtherSignedNotification(byte[] code) {
		this.code = code;
	}

	public OtherSignedNotification(NotificationMetadata tbsOtherNotification, BerOctetString euiccNotificationSignature, Certificate euiccCertificate, Certificate eumCertificate) {
		this.tbsOtherNotification = tbsOtherNotification;
		this.euiccNotificationSignature = euiccNotificationSignature;
		this.euiccCertificate = euiccCertificate;
		this.eumCertificate = eumCertificate;
	}

	public int encode(BerByteArrayOutputStream os) throws IOException {
		return encode(os, true);
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

		int codeLength = 0;
		codeLength += eumCertificate.encode(os, true);
		
		codeLength += euiccCertificate.encode(os, true);
		
		codeLength += euiccNotificationSignature.encode(os, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 55
		os.write(0x37);
		os.write(0x5F);
		codeLength += 2;
		
		codeLength += tbsOtherNotification.encode(os, true);
		
		codeLength += BerLength.encodeLength(os, codeLength);

		if (withTag) {
			codeLength += tag.encode(os);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		if (totalLength == -1) {
			subCodeLength += berTag.decode(is);

			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(NotificationMetadata.tag)) {
				tbsOtherNotification = new NotificationMetadata();
				subCodeLength += tbsOtherNotification.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 55)) {
				euiccNotificationSignature = new BerOctetString();
				subCodeLength += euiccNotificationSignature.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(Certificate.tag)) {
				euiccCertificate = new Certificate();
				subCodeLength += euiccCertificate.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(Certificate.tag)) {
				eumCertificate = new Certificate();
				subCodeLength += eumCertificate.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			int nextByte = is.read();
			if (berTag.tagNumber != 0 || berTag.tagClass != 0 || berTag.primitive != 0
			|| nextByte != 0) {
				if (nextByte == -1) {
					throw new EOFException("Unexpected end of input stream.");
				}
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			codeLength += subCodeLength + 1;
			return codeLength;
		}

		codeLength += totalLength;

		subCodeLength += berTag.decode(is);
		if (berTag.equals(NotificationMetadata.tag)) {
			tbsOtherNotification = new NotificationMetadata();
			subCodeLength += tbsOtherNotification.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 55)) {
			euiccNotificationSignature = new BerOctetString();
			subCodeLength += euiccNotificationSignature.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(Certificate.tag)) {
			euiccCertificate = new Certificate();
			subCodeLength += euiccCertificate.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(Certificate.tag)) {
			eumCertificate = new Certificate();
			subCodeLength += eumCertificate.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("tbsOtherNotification: ").append(tbsOtherNotification);
		
		sb.append(", ");
		sb.append("euiccNotificationSignature: ").append(euiccNotificationSignature);
		
		sb.append(", ");
		sb.append("euiccCertificate: ").append(euiccCertificate);
		
		sb.append(", ");
		sb.append("eumCertificate: ").append(eumCertificate);
		
		sb.append("}");
		return sb.toString();
	}

}

