package com.project.main;

import com.engine.core.Engine;
import com.engine.core.ImagesLoader;
import com.engine.core.StartListener;

/** Main initialization of engine framework. */
public class Initializer implements StartListener {
    // Our form to work on.
    private FirstForm form;

    /** Called when engine is fully loaded. */
    @Override
    public void startup() {
        // Loading resources. For example only. One resource is used
        // But it is defined in imagesToLoad.txt file.
        // In that file image id was defined as "logo".
        // Many images can be placed here, so no need to manually load them.
        // It will be done in ImagesLoader automatically.
        ImagesLoader imagesLoader = new ImagesLoader();
        imagesLoader.readFileForResources("resources/imagesToLoad.txt");
        // Load everything now.
        imagesLoader.loadAllNow();

        // Getting Engine instance.
        Engine p = Engine.getInstance();

        // Creating our form.
        // It must be created after Engine was initialized.
        form = new FirstForm();
        // Now adding form to Engine.
        p.addForm(form, "main");
        // Than making this form active.
        p.achangeState("main");
    }
}
