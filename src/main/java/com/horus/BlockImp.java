package com.horus;

import java.util.Objects;
import java.util.stream.Stream;

public class BlockImp implements Block {
    private final String color;
    private final String material;

    public BlockImp(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockImp blockImplementation = (BlockImp) o;
        return Objects.equals(color, blockImplementation.color) && Objects.equals(material, blockImplementation.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, material);
    }

    @Override
    public Stream<Block> toStream() {
        return Stream.of(this);
    }
}
