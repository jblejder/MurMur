package com.projectblejder.murmur.domain;

import java.security.spec.AlgorithmParameterSpec;

public interface AlgorithmParameterSpecFactory {

    AlgorithmParameterSpec create(String alias);
}
