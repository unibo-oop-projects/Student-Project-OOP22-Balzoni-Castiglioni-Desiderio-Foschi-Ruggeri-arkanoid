package it.unibo.game.app.view.jswing.implementation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.game.Pair;
import it.unibo.game.app.view.jswing.api.UIController;

public class CommandsView extends JPanel {
  private static final String COLOR = "#293132";
  private static final int MAX = 3;
  private static final int GAP = 15;
  private static final int DIM = 40;

  public CommandsView(final UIController control) {
    this.setLayout(new GridLayout(MAX + 2, 1, GAP, GAP));
    this.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
    this.setBackground(Color.decode(COLOR));

    JLabel title = new JLabel("   PRINCIPAL COMMANDS: ");
    title.setFont(new Font("myFont", Font.ITALIC, 26));
    title.setBackground(Color.decode(COLOR));
    title.setForeground(Color.YELLOW);
    this.add(title);
    this.createPanel("/sx.png", "-Left arrow key to move the pad to the left  ",
        new Pair<>(DIM, DIM));
    this.createPanel("/dx.png", "-Right arrow key to move the pad to the right  ",
        new Pair<>(DIM, DIM));
    this.createPanel("/space.png", "-Space key to stop the game  ",
        new Pair<>(DIM * 2, DIM));

    JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton jb = new JButton("MENU");
    jb.addActionListener(e -> control.initialView());
    jb.setBorderPainted(true);
    panel.add(jb);
    panel.setBackground(Color.decode(COLOR));
    this.add(panel);

  }

}
