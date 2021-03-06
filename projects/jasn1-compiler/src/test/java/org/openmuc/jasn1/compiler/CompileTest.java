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

import org.junit.Test;

public class CompileTest {

    private static final String generatedSrcDir = "src/test/java-gen";
    private static final String rootPackageName = "org.openmuc.jasn1.compiler";
    String[] args;

    // @Test
    // public void testCompilingEmbeddedPdv() throws Exception {
    // args = new String[] { "-o", "../jasn1/src/main/java/", "-p", "org.openmuc.jasn1.ber", "-f",
    // "src/test/resources/embedded-pdv.asn" };
    // Compiler.main(args);
    // }

    @Test
    public void testCompilingTagging() throws Exception {
        args = new String[] { "-o", generatedSrcDir, "-p", rootPackageName, "-f",
                "src/test/resources/tagging-test.asn" };
        Compiler.main(args);
    }

    @Test
    public void testCompilingCompileTests() throws Exception {

        args = new String[] { "-il", "-o", generatedSrcDir, "-p", rootPackageName, "-f",
                "src/test/resources/compile-test.asn", "-l" };
        Compiler.main(args);
    }

    @Test
    public void testCompilingModules() throws Exception {
        args = new String[] { "-il", "-o", generatedSrcDir, "-p", rootPackageName, "-f",
                "src/test/resources/modules1.asn", "src/test/resources/modules2.asn" };
        Compiler.main(args);
    }

    @Test
    public void testCompilingIsoPresentationLayer() throws Exception {
        args = new String[] { "-il", "-o", generatedSrcDir, "-p", rootPackageName, "-f",
                "src/test/resources/iso-presentation-layer.asn", "-l" };
        Compiler.main(args);
    }

    @Test
    public void testCompilingX690BerExample() throws Exception {
        args = new String[] { "-o", generatedSrcDir, "-p", rootPackageName, "-f",
                "src/test/resources/x690-ber-example.asn" };
        Compiler.main(args);
    }

    @Test
    public void testCompilingMobile() throws Exception {
        args = new String[] { "-il", "-o", generatedSrcDir, "-p", rootPackageName, "-f",
                "src/test/resources/mobile/PKIXExplicit88.asn", "src/test/resources/mobile/PKIXImplicit88.asn",
                "src/test/resources/mobile/RSPDefinitionsV2.0.asn", "-l" };
        Compiler.main(args);
    }

    @Test
    public void testCompilingMobile2() throws Exception {
        args = new String[] { "-il", "-o", generatedSrcDir, "-p", rootPackageName, "-f",
                "src/test/resources/mobile/PEDefinitionsV2.0.asn", "-l" };
        Compiler.main(args);
    }

    @Test
    public void testCompilingVariousTests() throws Exception {
        args = new String[] { "-il", "-o", generatedSrcDir, "-p", rootPackageName, "-f",
                "src/test/resources/various-tests.asn", "-l" };
        Compiler.main(args);
    }

    @Test
    public void testCompilingInformationObjectClasses() throws Exception {
        args = new String[] { "-il", "-o", generatedSrcDir, "-p", rootPackageName, "-f",
                "src/test/resources/information-object-class.asn" };
        Compiler.main(args);
    }
}
