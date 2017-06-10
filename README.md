
# jASN1 Overview [![Build Status](https://travis-ci.org/gythialy/jASN1.svg)](https://travis-ci.org/gythialy/jASN1)

This is **UNOFFICIAL**, fork from [openmuc](https://www.openmuc.org/asn1/).

jASN1 is an LGPL licensed Java ASN.1 BER and DER encoding/decoding library. It consists of a compiler (jasn-compiler) that creates Java classes from ASN.1 syntax. Compilation of multiple inter-dependent ASN.1 modules defined in multiple files is supported. The generated classes can then be used together with the jASN1 library to efficiently encode and decode messages using the Basic Encoding Rules (BER). The encoded bytes also confirm to the Distinguished Encoding Rules (DER) which is a subset of BER.

Much effort has been made to make encoding and decoding BER messages using this library very efficient. Benchmarks suggest that it is faster than the Binary Notes Framework by factors of 3 and 6 for encoding and decoding respectively. Similarly it was found to be faster than JAC by factors of 8 and 4 for encoding and decoding.

jASN.1 was chosen by the European Space Agency & Telespazio VEGA as their open source ASN.1 Java tool of choice.

Developer: Stefan Feuerhahn
