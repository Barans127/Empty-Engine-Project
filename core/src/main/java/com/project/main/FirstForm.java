package com.project.main;

import com.engine.core.Engine;
import com.engine.core.Resources;
import com.engine.ui.controls.Form;
import com.engine.ui.controls.widgets.SymbolButton;

public class FirstForm extends Form {
    // Our logo button.
    private SymbolButton symbolButton;

    public FirstForm(){
        //Preparing button to show our logo.
        SymbolButton.SymbolButtonStyle style = new SymbolButton.SymbolButtonStyle();
        // Accessing our image which was created in Initializer class.
        style.symbol = Resources.getDrawable("logo");
        // Size of this button.
        style.width = 500;
        style.height = 500;
        // Placing button in the middle of the screen.
        // Drawings works from lower left corner.
        Engine p = Engine.getInstance();
        style.x = p.getScreenWidth()/2 - style.width/2;
        style.y = p.getScreenHeight()/2 - style.height/2;

        // After styling prepared creating button.
        symbolButton = new SymbolButton(style);
        // Every control must be added to form to work.
        addControl(symbolButton);
    }
}
