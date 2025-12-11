package model.game.space;

import CrossyRoad.model.Position;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class LoaderSpaceBuilderTest {
    private LoaderSpaceBuilder loader;
    private Space space;

    @BeforeEach
    public void setUp() throws IOException {
        this.loader = new LoaderSpaceBuilder(1);
        this.space = loader.createSpace();
    }

    @Test
    public void testgetWidth() {
        assertEquals(space.getWidth(), 20);
    }

    @Test
    public void testgetHeight() {
        assertEquals(space.getHeight(), 6);
    }

    @Test
    public void testCreateWalls(){
        assertEquals(48, space.getWalls().size());
    }

    @Test
    public void testCreateChicken(){
        assertNotNull(space.getChicken());
        assertEquals(new Position(1, 1), space.getChicken().getPosition());
    }

    @Test
    public void testCreateBushes(){
        assertEquals(space.getBushes().size(), 4);
    }

    @Test
    public void testCreateRiver(){
        assertEquals(space.getRiver().size(),12);
    }

    @Test
    public void testCreateLog(){
        assertEquals(space.getLogs().size(),1);
    }

    @Test
    public void testCreateCar(){
        assertEquals(space.getCars().size(),1);
    }

    @Test
    public void testCreateTruck(){
        assertEquals(space.getTruck().size(),1);
    }

    @Test
    public void testCreateEndline(){
        assertEquals(space.getEndlines().size(),3);
    }

    @Test
    void testNoChickenThrowsException() {
        Exception exception = assertThrows(
                IllegalStateException.class,
                () -> {
                    LoaderSpaceBuilder builder = new LoaderSpaceBuilder(99);
                    builder.createSpace();
                }
        );

        assertEquals("No chicken found in level 99", exception.getMessage());
    }
}
