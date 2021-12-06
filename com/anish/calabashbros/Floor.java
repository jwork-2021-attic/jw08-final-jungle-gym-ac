package com.anish.calabashbros;

import java.awt.Color;

public class Floor extends Thing {

    public Floor(World world) {
        super(Color.gray, (char) 63, world);
    }
    public Floor(Color color, char glyph,World world){
        super(color,glyph,world);
    }
}
