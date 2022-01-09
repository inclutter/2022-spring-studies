package com.inclutter.springquickstart.common;

import org.junit.jupiter.api.Test;
import org.springframework.core.SpringVersion;

public class GetSpringVersion {
    @Test
    void getSpringVersion() {
        System.out.println(SpringVersion.getVersion());
    }
}
