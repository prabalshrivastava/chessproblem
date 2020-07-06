package com.technogise.chessproblem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Block {
    private int x;
    private int y;
    private String label;
    private String piece;

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
