package com.technogise.chessproblem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Block {
    int x;
    int y;
    String label;
    String piece;

    Block(int x, int y) {
        this.x = x;
        this.y = y;
        label = String.format("%s%s", (char) ('A' + x - 1), y);
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return StringUtils.equals(label, block.label);
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(x + "" + y);
    }
}
