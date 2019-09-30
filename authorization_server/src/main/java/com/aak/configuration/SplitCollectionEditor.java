package com.aak.configuration;

import java.util.Collection;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;

/**
 * Project authorization_server
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Aug 27, 2019
 */
public class SplitCollectionEditor extends CustomCollectionEditor {

    private final Class<? extends Collection> collectionType;

    private final String splitRegex;

    public SplitCollectionEditor(Class<? extends Collection> collectionType, String splitRegex) {

        super(collectionType, true);
        this.collectionType = collectionType;
        this.splitRegex = splitRegex;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        if (text == null || text.isEmpty()) {
            super.setValue(super.createCollection(collectionType, 0));
        } else {
            super.setValue(text.split(splitRegex));
        }
    }
}
