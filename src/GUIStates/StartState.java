package GUIStates;

import core.GraphicsEngine;
import fsm.State;
import graphics.gui.Button;
import graphics.gui.GUI;
import graphics.gui.GUIButtonListener;

/**
 * Created by Christopher on 18/04/2017.
 */
public class StartState extends State {
    private GUI start;
    private GraphicsEngine graphicsEngine;
    private GUIButtonListener startButtonListener = new GUIButtonListener();
    private GUIButtonListener exitButtonListener = new GUIButtonListener();

    public StartState(GUI start, GraphicsEngine graphicsEngine){
        this.start = start;
        this.graphicsEngine = graphicsEngine;
    }

    public void initialize(){
        onEnter();
    }

    public void onEnter(){
        Button play = start.getButtonById("play");
        play.addListener(startButtonListener);
        Button exit = start.getButtonById("exit");
        exit.addListener(exitButtonListener);
        startButtonListener.setNotClicked();
        exitButtonListener.setNotClicked();

        graphicsEngine.setGUI(start);
        System.out.println("Switching to Start Screen");
    }

    @Override
    public String onUpdate() {
        if(startButtonListener.isClicked()) {
            System.out.println("game modes button clicked");
            return "gameModes";
        }
        else if (exitButtonListener.isClicked()) {
            System.out.println("Exit button clicked");
            return "exit";
        }
        return "start";
    }

    @Override
    public String getStateName() {
        return "start";
    }
}
