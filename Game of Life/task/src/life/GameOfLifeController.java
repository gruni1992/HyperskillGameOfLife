package life;

public class GameOfLifeController extends Thread{

    private GameOfLife view;
    private GameOfLifeModel model;
    private int size;
    private boolean paused = true;

    public GameOfLifeController(GameOfLife view, int size){
        this.size = size;
        this.view = view;
        this.model = new GameOfLifeModel(size);
    }

    public void run(){
        while (!interrupted()) {
            try {
                while(!interrupted() && paused) {
                    Thread.sleep(100);
                }
                evolve();
                Thread.sleep(200);
                }
            catch (InterruptedException e) {}
        }
    }

    public void evolve(){
        model.evolve();
        model.getUniverse();
        setView();
    }

    public void setView(){
        view.setGeneration(model.getGeneration());
        view.setAlive(model.getAlive());
        view.setUniverse(model.getUniverse());
    }

    public void play() {
        if(this.getState() == State.NEW){
            this.start();
        }
        paused = false;
    }

    public void pause() {
        paused = true;
    }

    public void reset() {
        this.model = new GameOfLifeModel(size);
        setView();
    }
}
