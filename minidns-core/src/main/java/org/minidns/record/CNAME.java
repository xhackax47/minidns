/*
 * Copyright 2015-2018 the original author or authors
 *
 * This software is licensed under the Apache License, Version 2.0,
 * the GNU Lesser General Public License version 2 or later ("LGPL")
 * and the WTFPL.
 * You may choose either license to govern your use of this software only
 * upon the condition that you accept all of the terms of either
 * the Apache License 2.0, the LGPL 2.1+ or the WTFPL.
 */
package org.minidns.record;

import org.minidns.DNSName;
import org.minidns.record.Record.TYPE;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * CNAME payload (pointer to another domain / address).
 */
public class CNAME extends RRWithTarget {

    public static CNAME parse(DataInputStream dis, byte[] data) throws IOException {
        DNSName target = DNSName.parse(dis, data);
        return new CNAME(target);
    }

    public CNAME(String target) {
        this(DNSName.from(target));
    }

    public CNAME(DNSName target) {
        super(target);
    }

    @Override
    public TYPE getType() {
        return TYPE.CNAME;
    }

}
