package com.naver.idealproduction.song.domain.unit;

import java.math.BigDecimal;
import java.math.MathContext;

public enum Speed {
    METER_PER_SEC(3.6),
    MILE_PER_HOUR(1.60934),
    KNOT(1.852),
    FEET_PER_MIN(0.018288),
    KILOMETER_PER_HOUR(1.0);

    private final double ratio;

    Speed(double ratio) {
        this.ratio = ratio;
    }

    @SuppressWarnings("DuplicatedCode")
    public Double convertTo(Speed unit, double value) {
        if (this == unit) {
            return value;
        }

        var ctx = MathContext.DECIMAL64;
        var dividend = BigDecimal.valueOf(unit.ratio);
        var divisor = BigDecimal.valueOf(this.ratio);
        var bigValue = BigDecimal.valueOf(value);
        return dividend.divide(divisor, ctx).multiply(bigValue, ctx).doubleValue();
    }
}
