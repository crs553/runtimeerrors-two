package com.team5.game.Sprites.Pathfinding;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.team5.game.Environment.SystemChecker;
import com.team5.game.Sprites.Infiltrator;
import com.team5.game.Sprites.Player;
import com.team5.game.Tools.Constants;
import com.team5.game.Tools.GameController;

public class InfiltratorAIBehaviour extends NPCAIBehaviour{

    /*
    InfiltratorAIBehaviour contains all of the basic AI for Infiltrators.

    It makes the Infiltrators either follow the same AI as the NPCs or
    target a system and break it.
     */

    Infiltrator npc;

    //Abilities
    Player player;

    float changeCooldown = 15f;
    float timer = changeCooldown;

    float distance = 100;

    //Systems
    System goalSystem;
    SystemChecker systemChecker;
    Array<System> systems;

    //States
    boolean breaking;

    float breakOdds = 1f;

    //Audio
    Sound explosion = Gdx.audio.newSound(Gdx.files.internal("Audio/Sound Effects/explosion.wav"));

    //runtime errors addition
    boolean slowed = false;

    //runtime errors addition
    //where index 0 is sprint
    //and index 1 is quick sabotage
    private boolean[] abilitiesAvailable = {true,true};
    private boolean quicksabotage = false;


    public InfiltratorAIBehaviour(GameController gameController, Infiltrator infiltrator,
                                  NodeGraph graph, Node node) {
        /*sets all the variables needed to inform the ai of the infiltrators*/
        super(infiltrator, graph, node);
        npc = infiltrator;
        systemChecker = gameController.getSystemChecker();
        player = gameController.getPlayer();
        systems = new Array<>();
        systems.addAll(graph.getSystems());

        goalSystem = systems.random();
    }

    //Used to randomly generate a target system from the systems that
    //haven't been visited yet.
    void newSystemTarget() {
        /*sets a new system for the infiltrator to target*/
        goalSystem = systems.random();
        goalNode = goalSystem;
        path = graph.findPath(currentNode, goalNode);

        target = path.get(currentIndex).randomPos();
    }

    @Override
    public void update(float delta) {
        /*runs ability checks and also checks if infiltrators are close
        enough to break systems
        parameters:
            float object delta that gives the time passed
         */
        slowingAbility();
        if (waiting){
            wait(delta);
            npc.direction = Vector2.Zero;
        } else {
            npc.direction = move(npc.x, npc.y);
        }

        //This changes the infiltrators disguise every 30 seconds
        //But only if it's away from the player.
        timer -= delta;
        if (timer <= 0){

            if (Vector2.dst(player.x, player.y, npc.x, npc.y) > distance){
                npc.changeSkin();
                timer = changeCooldown;
            }
        }
        //added by runtime errors
        if(abilitiesAvailable[0]) {
            if (Vector2.dst(player.x, player.y, npc.x, npc.y) < distance-50) {
                activateAbility(0, 3);
            }
        }
    }
    //added by runtime errors
    //calls the function to set slowed to true in the NCPAIBehaviourclass
    public void slowingAbility() {
        /*reduces the infiltrator's speed while this ability is active*/
        if (player.abilityCurrentlyActive[3] && Vector2.dst(player.x, player.y, npc.x, npc.y) < distance && !slowed) {
            super.decreaseInfiltratorSpeed();
            slowed = true;
        } else if (!player.abilityCurrentlyActive[3] && slowed) {
            super.increaseInfiltratorSpeed();
            slowed = false;
        }
    }

    //wait is changed to break a system if they're at one.
    @Override
    public void wait(float delta) {
        /* makes the user break systems, and controls the wait time before they do. Also
        calls the system invulnerability code
        parameters:
            float object delta giving the amount of time passed
         */
        //Runtime errors edit
        if(!player.abilityCurrentlyActive[0]) {
            if (waitTime <= 0f || goalSystem.getBroken() || quicksabotage) {
                if (breaking && !goalSystem.getBroken()) {
                    explosion.play(0.2f* Constants.volumeMultipler);
                    goalSystem.destroy();
                    systemChecker.breakSystem();
                }
                waiting = false;
                systems.removeValue(goalSystem, false);

                if (random.nextFloat() < breakOdds) {
                    breaking = true;
                    //edited by runtime errors
                    quicksabotage = false;
                    newSystemTarget();
                    activateAbility(1,200);
                } else {
                    breaking = false;
                    newTarget();
                }
            } else {
                waitTime -= delta;
            }
        }
    }
    //runtime errors addition
    public void activateAbility(int index,int probability) {
        /*generates a random number and activates the ability indicated by index if
        the number is less than probability
        parameters:
            int object index specifies the position of chosen ability in the abilitiesAvailable array
            int probability gives the probability out of 1000 that the ability should be activated
         */
        if(abilitiesAvailable[index]) {
            int randomGen = (int) (Math.random() * 1000);
            if (randomGen <= probability) {
                abilitiesAvailable[index] = false;
                if(index == 0) {
                    super.activateAbility(index);
                } else if(index == 1) {
                    quicksabotage = true;
                }
            }
        }
    }

    public boolean isBreaking(){
        /*getter for breaking
        returns:
            boolean breaking which is true if the infiltrator is ready to break the system.
         */
        return breaking;
    }

    public boolean isWaiting(){
        /*getter for waiting
        returns:
            boolean waiting is true if infiltrator is waiting to break a system
         */
        return waiting;
    }

    public void dispose(){
        /*removes all used objects from memory*/
        explosion.dispose();
    }
}
