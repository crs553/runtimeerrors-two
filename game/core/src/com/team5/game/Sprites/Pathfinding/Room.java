package com.team5.game.Sprites.Pathfinding;

public class Room extends Node{

    /*
    Room is used to differentiate hallways and rooms in the NodeGraph class.
     */

    public String tag;

    public Room(String tag, float x, float y, String name) {
        /*Sets the position and name of the room
        parameters:
            String tag gives the tag of the room
            float x gives the x coordinate of the room
            float y give the y coordinate of the room
            String name gives the name of the room
         */
        super(x, y, name);
        this.tag = tag;
    }

    public Room(String tag, float x, float y, String name, float xDim, float yDim) {
        /*Sets the position and name of the room
        parameters:
            String tag gives the tag of the room
            float x gives the x coordinate of the room
            float y give the y coordinate of the room
            String name gives the name of the room
            float xDim gives x length of the room
            float yDim gives y length of the room
         */
        super(x, y, name, xDim, yDim);
        this.tag = tag;
    }
}
