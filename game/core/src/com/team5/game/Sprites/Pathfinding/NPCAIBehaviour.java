package com.team5.game.Sprites.Pathfinding;

import com.badlogic.gdx.ai.pfa.GraphPath;
import com.badlogic.gdx.math.Vector2;
import com.team5.game.Sprites.NPC;

import java.util.Random;

public class NPCAIBehaviour {

    /*
    NPCAIBehaviour contains all of the basic AI for NPCs.

    It makes the NPCs move to a random target destination and then stop
    for a random amount of time between given bounds, and repeat.
     */

    //NPC Reference
    NPC npc;

    //Movement
    int maxSpeed = 60;
    int minSpeed = 30;
    float speed;
    //Runtime errors addition
    boolean slowed = false;
    boolean sprint = false;
    float sprintTimer = 300;

    //Pathfinding
    NodeGraph graph;
    public Node currentNode;
    public Node goalNode;
    GraphPath<Node> path;
    int currentIndex;

    Vector2 target;
    float offset = 8;

    //Waiting
    float maxWait = 5;
    float minWait = 1;
    float waitTime;

    //Behaviours
    boolean waiting = false;

    Random random;

    public NPCAIBehaviour(NPC npc, NodeGraph graph, Node node){
        /*sets the speed and prepares the objects needed for pathfinding
        parameters:
            NPC npc provides the settings for the animations
            NodeGraph graph provides the pathfinding nodes
            Node node gives the current node the npc is at*/
        this.npc = npc;
        this.graph = graph;
        currentNode = node;
        random = new Random();
        speed = random.nextInt(maxSpeed - minSpeed);
        speed += minSpeed;

        newTarget();
    }

    //Is called to tell the NPC what to do on each frame.
    public void update(float delta){
        /*controls the npc waiting and directions
        parameters:
            float delta is the amount of time that has passed*/
        if (waiting){
            wait(delta);
            npc.direction = Vector2.Zero;
        } else {
            npc.direction = move(npc.x, npc.y);
        }
    }

    void newTarget(){
        /*Generates a random room for the npc to target.*/
        goalNode = graph.getRandomRoom(currentNode);
        path = graph.findPath(currentNode, goalNode);

        target = path.get(currentIndex).randomPos();
    }
    //added by runtime errors
    public void decreaseInfiltratorSpeed() {
        /*make the npc go slower if they are an infiltrator*/
        slowed = true;
    }
    public void increaseInfiltratorSpeed() {
        /*return the speed of the infiltrators to normal*/
        slowed = false;
    }

    public Vector2 move(float x, float y){
        /*Moves the npc towards their target.
        parameters:
            float x is the current x position of the npc
            float y is the current y position of the npc
        returns:
            Vector2 object specifying where the npc is aiming
         */
        if (goalNode.equals(path.get(currentIndex)) &&
                x < target.x + offset && x > target.x - offset &&
                y < target.y + offset && y > target.y - offset){
            currentNode = goalNode;
            currentIndex = 1;

            waiting = true;
            waitTime = (random.nextFloat()*(maxWait-minWait)) + minWait;

            return Vector2.Zero;

        } else if (x < target.x + offset && x > target.x - offset &&
                y < target.y + offset && y > target.y - offset){
            currentNode = path.get(currentIndex);
            currentIndex++;

            target = path.get(currentIndex).randomPos();
        }

        Vector2 resultant = new Vector2(target.x - x,
                target.y - y).nor();

        //edited by runtime errors
        if(slowed) {
            return new Vector2(resultant.x*10,resultant.y*10);
        } else if(sprint) {
            sprintTimer -= 1;
            if(sprintTimer <= 0) {
                sprint = false;
            }
            return new Vector2(resultant.x * 100, resultant.y * 100);
        } else {
            return new Vector2(resultant.x * speed, resultant.y * speed);
        }
    }

    //added by runtime errors
    public void activateAbility(int index) {
        /*sets sprint to true if the sprint ability active
        parameters:
            int index gives the index of the ability in the active abilities array
            in infiltator
         */
        if(index == 0) {
            sprint = true;
        }
    }

    //Makes the npc wait for a certain amount of time
    public void wait(float delta){
        /*makes the npc wait for certain amount of time
        parameters:
            float delta give the amount of time passed
         */
        if (waitTime <= 0f){
            waiting = false;
            newTarget();
        }else {
            waitTime -= delta;
        }
    }

}
