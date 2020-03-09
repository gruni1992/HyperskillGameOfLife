package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class GameOfLife extends JFrame{

    private JLabel generationLabel = new JLabel();
    private JLabel aliveLabel = new JLabel();
    private JPanel[][] cells;
    private GameOfLifeController controller;

    public GameOfLife(){ this(20); }

    GameOfLife(int size){
        super("Game of Life");
        controller = new GameOfLifeController(this, size);
        setSize(1000, 1000);

        //Statistics Panel for Generation and alive statistics
        JPanel statisticsPanel = new JPanel();
        statisticsPanel.setLayout(new BoxLayout(statisticsPanel, BoxLayout.Y_AXIS));
        generationLabel.setName("GenerationLabel");
        aliveLabel.setName("AliveLabel");
        generationLabel.setText("Generation #0");
        aliveLabel.setText("Alive: 0");
        statisticsPanel.add(generationLabel);
        statisticsPanel.add(aliveLabel);

        //Button Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        JToggleButton playPauseButton = new JToggleButton("Play");
        playPauseButton.setName("PlayToggleButton");
        playPauseButton.addItemListener(itemEvent -> {
            int state = itemEvent.getStateChange();
            if (state == ItemEvent.SELECTED) {
                playPauseButton.setText("Pause");
                controller.play();
            } else {
                playPauseButton.setText("Play");
                controller.pause();
            }
        });
        JButton resetButton = new JButton("Reset");
        resetButton.setName("ResetButton");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.reset();
            }
        });


        buttonPanel.add(playPauseButton);
        buttonPanel.add(resetButton);

        //controlPanel for buttons and statistics
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        statisticsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        controlPanel.add(buttonPanel);
        controlPanel.add(statisticsPanel);

        //Universe Panel to show the actual universe
        JPanel universePanel = new JPanel();
        universePanel.setLayout(new GridLayout(size, size));
        cells = new JPanel[size][size];
        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells[i].length; j++) {
                JPanel cell = new JPanel();
                cell.setBorder(BorderFactory.createLineBorder(Color.black));
                universePanel.add(cell);
                cells[i][j] = cell;
            }
        }

        //JFrame
        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.WEST);
        add(universePanel, BorderLayout.CENTER);
        controller.setView();
        setVisible(true);
    }

    public void setUniverse(boolean[][] universe){
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe[i].length; j++) {
                cells[i][j].setBackground(universe[i][j] ? Color.BLACK : null);
            }
        }
    }

    public void setGeneration(int generation){
        generationLabel.setText("Generation #" + generation);
    }

    public void setAlive(int alive){
        aliveLabel.setText("Alive: " + alive);
    }
}