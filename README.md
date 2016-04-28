
# jASN1 Overview [![Build Status](https://travis-ci.org/gythialy/jASN1.svg)](https://travis-ci.org/gythialy/jASN1)

This is **UNOFFICIAL**, fork from [openmuc](https://www.openmuc.org/asn1/).

jASN1 is an LGPL licensed Java ASN.1 BER encoding/decoding library. It consists of a compiler (jasn-compiler) that creates Java classes from ASN.1 syntax. Compilation of multiple inter-dependent ASN.1 modules defined in multiple files is supported. The generated classes can then be used together with the jASN1 library to efficiently encode and decode messages using the Basic Encoding Rules (BER).

Much effort has been made to make encoding and decoding BER messages using this library very efficient. Profiling jASN1 suggested that it is faster than the Binary Notes Framework by factors of 6 and 3 for decoding and encoding respectively. Similarly it was found to be faster than JAC by factors of 8 and 4 for decoding and encoding.

Recently jASN.1 was chosen by the European Space Agency & Telespazio VEGA as their open source ASN.1 Java tool of choice.

The easiest way to learn how to use jASN1 is to take a look at the sample program which is packed with the distribution.

Developer: Stefan Feuerhahn
