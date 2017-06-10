/*
 * Copyright 2011-17 Fraunhofer ISE
 *
 * This file is part of jASN1.
 * For more information visit http://www.openmuc.org
 *
 * jASN1 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * jASN1 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with jASN1.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.openmuc.jasn1.compiler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.types.BerEmbeddedPdv;
import org.openmuc.jasn1.ber.types.BerInteger;
import org.openmuc.jasn1.ber.types.string.BerVisibleString;
import org.openmuc.jasn1.compiler.modules.module1.ChildInformation;
import org.openmuc.jasn1.compiler.modules.module1.Date;
import org.openmuc.jasn1.compiler.modules.module1.MyBitString;
import org.openmuc.jasn1.compiler.modules.module1.MyDate1;
import org.openmuc.jasn1.compiler.modules.module1.MyInt;
import org.openmuc.jasn1.compiler.modules.module1.MyInt2;
import org.openmuc.jasn1.compiler.modules.module1.Name;
import org.openmuc.jasn1.compiler.modules.module1.PersonnelRecord;
import org.openmuc.jasn1.compiler.modules.module1.PersonnelRecord.TestSequenceOf2;
import org.openmuc.jasn1.compiler.modules.module1.PersonnelRecord.TestSequenceOf2.SEQUENCE;
import org.openmuc.jasn1.compiler.modules.module1.TestChoice;
import org.openmuc.jasn1.compiler.modules.module1.TestSequenceOf;
import org.openmuc.jasn1.compiler.modules.module2.EmployeeNumberZ;

public class ModulesTest {

    @Test
    public void encodingDecoding() throws IOException {

        BerByteArrayOutputStream berOS = new BerByteArrayOutputStream(1000);

        MyDate1 dateOfHire = new MyDate1();
        // MyDate1 dateOfHire = new MyDate1("19710917");
        dateOfHire.value = new String("19710917").getBytes();

        dateOfHire.encode(berOS, true);

        MyInt2 myInt2Encode = new MyInt2(2);
        berOS.reset();
        myInt2Encode.encode(berOS, true);

        MyInt2 myInt2Decode = new MyInt2();
        byte[] code = HexConverter.fromShortHexString("a303020102");
        InputStream is = new ByteArrayInputStream(code);
        myInt2Decode.decode(is, true);
        Assert.assertEquals(myInt2Decode.value.intValue(), 2);

        PersonnelRecord pr = new PersonnelRecord();

        Name name = new Name();
        name.setGivenName(new BerVisibleString("givenName".getBytes()));
        name.setFamilyName(new BerVisibleString("familyName".getBytes()));
        name.setInitial(new BerVisibleString("initial".getBytes()));
        pr.setName(name);

        pr.setTitle(new BerVisibleString("title".getBytes()));

        pr.setNumber(new EmployeeNumberZ(1));

        pr.setDateOfHire(new Date("23121981".getBytes()));

        pr.setNameOfSpouse(name);

        ChildInformation child = new ChildInformation();
        child.setName(new Name("child name".getBytes()));
        child.setDateOfBirth(new Date("12121912".getBytes()));

        PersonnelRecord.Children children = new PersonnelRecord.Children();
        List<ChildInformation> childInformation = children.getChildInformation();
        childInformation.add(child);
        childInformation.add(child);

        pr.setTestBitString(new MyBitString(new byte[] { (byte) 0x80, (byte) 0xff }, 10));

        pr.setTest(new MyInt(3));

        TestChoice testChoice = new TestChoice();
        testChoice.setChoiceElement1(child);

        pr.setTest2(testChoice);

        pr.setTest3(testChoice);

        pr.setTest4(testChoice);

        pr.setTest5(testChoice);

        pr.setTest6(testChoice);

        TestSequenceOf testSequenceOf = new TestSequenceOf();
        List<BerInteger> berIntegers = testSequenceOf.getBerInteger();
        for (int i = 0; i < 10; i++) {
            berIntegers.add(new BerInteger(i));
        }
        pr.setTestSequenceOf(testSequenceOf);

        TestSequenceOf2 testSequenceOf2 = new TestSequenceOf2();
        List<SEQUENCE> sequences = testSequenceOf2.getSEQUENCE();
        for (int i = 0; i < 10; i++) {
            SEQUENCE sequence = new SEQUENCE();
            sequence.setTest1(new BerInteger(i++));
            sequence.setTest2(new BerInteger(i));
            sequences.add(sequence);
        }
        pr.setTestSequenceOf2(testSequenceOf2);

        BerEmbeddedPdv berEmbeddedPdv = new BerEmbeddedPdv();
        pr.setEmbeddedPdv(berEmbeddedPdv);

        System.out.println("PersonnelRecord.toString():\n" + pr);
    }

}
