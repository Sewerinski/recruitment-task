package com.horus;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class CompositeBlockImp extends BlockImp implements CompositeBlock {
    final private List<Block> blocks = new LinkedList<>();

    public CompositeBlockImp(String color, String material) {
        super(color, material);
    }

    @Override
    public List<Block> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }

    public void addBlockImp(Block block) {
        blocks.add(block);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompositeBlockImp compositeBlockImplementation = (CompositeBlockImp) o;
        return Objects.equals(blocks, compositeBlockImplementation.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), blocks);
    }

    @Override
    public Stream<Block> toStream() {
        return Stream.concat(
                super.toStream(),
                blocks.stream().flatMap(Block::toStream)
        );
    }
}