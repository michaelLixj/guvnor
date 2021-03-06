/*
 * Copyright 2011 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.drools.guvnor.client.asseteditor.drools;

import org.drools.ide.common.client.modeldriven.dt52.GuidedDecisionTable52.TableFormat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * A control providing options for creating a Guided Decision Table asset
 */
public class GuidedDecisionTableOptions extends Composite {

    interface GuidedDecisionTableOptionsBinder
            extends
            UiBinder<Widget, GuidedDecisionTableOptions> {
    }

    private static GuidedDecisionTableOptionsBinder uiBinder      = GWT.create( GuidedDecisionTableOptionsBinder.class );

    @UiField
    CheckBox                                        chkUseWizard;

    private boolean                                 isUsingWizard = false;

    private TableFormat                             tableFormat   = TableFormat.EXTENDED_ENTRY;

    public GuidedDecisionTableOptions() {
        initWidget( uiBinder.createAndBindUi( this ) );
    }

    public boolean isUsingWizard() {
        return this.isUsingWizard;
    }

    public TableFormat getTableFormat() {
        return this.tableFormat;
    }

    @UiHandler(value = "chkUseWizard")
    void chkUseWizardClick(ClickEvent event) {
        this.isUsingWizard = chkUseWizard.getValue();
    }

    @UiHandler(value = "optExtendedEntry")
    void optExtendedEntryClick(ClickEvent event) {
        tableFormat = TableFormat.EXTENDED_ENTRY;
    }

    @UiHandler(value = "optLimitedEntry")
    void optoptLimitedEntryClick(ClickEvent event) {
        tableFormat = TableFormat.LIMITED_ENTRY;
    }

}
