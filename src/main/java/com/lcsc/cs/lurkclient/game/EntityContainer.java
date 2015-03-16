package com.lcsc.cs.lurkclient.game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jake on 3/11/2015.
 */
public class EntityContainer {
    private final DefaultListModel  _entities;
    private final JList             _entityList;

    public EntityContainer(String title, int x, int y, JPanel panel) {
        JLabel titleLbl = new JLabel(title);

        Font oldFont = titleLbl.getFont();
        Font newFont = new Font(oldFont.getFontName(), Font.PLAIN, 25);
        titleLbl.setFont(newFont);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor    = GridBagConstraints.WEST;
        c.gridx     = x;
        c.gridy     = y;
        panel.add(titleLbl, c);

        _entities = new DefaultListModel();

        _entityList = new JList(_entities);
        _entityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollList = new JScrollPane(_entityList);
        scrollList.setPreferredSize(new Dimension(100, 100));
        scrollList.setMinimumSize(_entityList.getPreferredSize());

        c           = new GridBagConstraints();
        c.weightx   = c.weighty = 1.0;
        c.fill      = GridBagConstraints.BOTH;
        c.gridx     = x;
        c.gridy     = y+1;

        panel.add(scrollList, c);
    }

    //This makes sure that every added element is unique!
    public void add(String element) {
        if (!_entities.contains(element))
            _entities.addElement(element);
    }

    public void remove(String element) {
        _entities.removeElement(element);
    }

    public void clear() {
        _entities.clear();
    }
}
