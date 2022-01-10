package com.horus;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class WallTest {
    private static final BlockImp BLOCK_IMP1 = new BlockImp("Black", "Brick");
    private static final BlockImp BLOCK_IMP2 = new BlockImp("Blue", "Cement");
    private static final CompositeBlockImp COMPOSITE_BLOCK_IMP3 = new CompositeBlockImp("Yellow", "Brick2");
    private static final CompositeBlockImp COMPOSITE_BLOCK_IMP4 = new CompositeBlockImp("Purple", "Brick3");

    private Wall emptyWall;
    private Wall filledWall;

    @BeforeAll
    static void setUpClass() {
        COMPOSITE_BLOCK_IMP3.addBlockImp(BLOCK_IMP1);
        COMPOSITE_BLOCK_IMP3.addBlockImp(COMPOSITE_BLOCK_IMP4);
    }

    @BeforeEach
    void setUp() {
        emptyWall = new Wall();
        filledWall = new Wall(BLOCK_IMP1, BLOCK_IMP2, COMPOSITE_BLOCK_IMP3, COMPOSITE_BLOCK_IMP4);
    }

    @Test
    void instantiateClassTest() {
        assertThat(emptyWall, notNullValue());
    }

    @Test
    void findBlockByColor() {
        assertThat(filledWall.findBlockByColor("Blue"), is(BLOCK_IMP2));
    }

    @Test
    void findBlockByMaterial() {
        assertThat(filledWall.findBlocksByMaterial("Cement"), is(BLOCK_IMP2));
    }
}