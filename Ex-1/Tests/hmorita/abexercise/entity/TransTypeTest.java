package hmorita.abexercise.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransTypeTest {

    @Test
    public void testTransType() {

        String p1 = "p";
        String r1 = "R";
        String p2 = "p";

        System.out.println(TransType.valueOf(p1.toUpperCase()));
        assertTrue(TransType.P == TransType.valueOf(p1.toUpperCase()));
        assertTrue(TransType.P == TransType.valueOf(p2.toUpperCase()));
        assertTrue(TransType.R == TransType.valueOf(r1.toUpperCase()));
        assert(TransType.R == TransType.valueOf(r1.toUpperCase()));

    }

}