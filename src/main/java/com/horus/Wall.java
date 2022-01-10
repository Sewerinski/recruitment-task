package com.horus;

import java.util.*;
import java.util.function.Predicate;

public class Wall implements Structure {
    private final List<Block> blocks = new ArrayList<>();

    public Wall(Block... blocks) {
        Arrays.stream(blocks).forEach(this::addBlockImp);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (color == null) {
            throw new IllegalArgumentException("COLOR/NULL");
        }
        return Optional.ofNullable(searchByPredicate(n -> color.equals(n.getColor())));
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (material == null) {
            throw new IllegalArgumentException("MATERIAL/NULL");
        }
        return Collections.singletonList(searchByPredicate(n -> material.equals(n.getMaterial())));
    }

    private Block searchByPredicate(Predicate<Block> predicate) {
        return blocks.stream()
                .flatMap(Block::toStream)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int count() {
        return (int) blocks.stream().flatMap(Block::toStream).count();
    }

    public void addBlockImp(Block block) {
        blocks.add(block);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return Objects.equals(blocks, wall.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blocks);
    }
}