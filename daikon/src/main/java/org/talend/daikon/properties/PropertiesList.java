// ============================================================================
//
// Copyright (C) 2006-2017 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.daikon.properties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.talend.daikon.NamedThing;
import org.talend.daikon.properties.presentation.Form;

/**
 * Class representing a list of Properties, which can be represented as a row-based table. Every Properties object in
 * the list represents a separate row in the table. Every Row of the table can have it's own validation rules and it's
 * own methods to update Property fields, which it contains. Thus it should be possible to set a different set of
 * possible values for each "Cell" in the table(Property field in the Properties object).
 */
public abstract class PropertiesList<T extends Properties & NamedThing> extends PropertiesImpl {

    /**
     * List of all properties present in the table
     */
    protected List<T> properties = new ArrayList<>();

    public PropertiesList(String name) {
        super(name);
    }

    @Override
    public void setupLayout() {
        super.setupLayout();

        Form main = new Form(this, Form.MAIN);
        layoutPropertiesOnForm(main);
    }

    /**
     * Put all the rows to the given form
     */
    protected void layoutPropertiesOnForm(Form form) {
        for (T props : properties) {
            form.addRow(props);
        }
    }

    @Override
    public void refreshLayout(Form form) {
        super.refreshLayout(form);
        if (Form.MAIN.equals(form.getName())) {
            form.clearForm();
            layoutPropertiesOnForm(form);
        }
    }

    /**
     * Get list of properties defined for this object.
     */
    public Collection<T> getPropertiesList() {
        return properties;
    }

    public void addRow(T props) {
        properties.add(props);
    }

    public void addAllRows(Collection<T> props) {
        properties.addAll(props);
    }

    /**
     * Get all properties defined as fields of current PropertiesImpl object(can be Property or Properties) and all
     * properties added to the properties list.
     */
    @Override
    public List<NamedThing> getProperties() {
        List<NamedThing> props = super.getProperties();
        props.addAll(properties);
        return props;
    }

}
