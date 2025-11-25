package com.project.main;

import com.badlogic.gdx.math.Vector2;
import com.engine.animations.CameraSlider;
import com.engine.core.Engine;
import com.engine.jbconstructor.Constructor;
import com.engine.jbconstructor.Entity;
import com.engine.jbconstructor.Template;
import com.engine.physics.Physics;
import com.engine.ui.controls.Form;

public class FirstForm extends Form {
    private final Physics physics;
    private final CameraSlider cameraSlider;

    public FirstForm(){
        // Load all constructor files.
        Constructor constructor = new Constructor();
        constructor.decode("resources/GravityExample.json", true, true, true, true);

        // Getting template.
        // Only one template was used, so we know that there is only one.
        Template template = constructor.getTemplate(0);
        setFormsTemplate(template);

        // Creating physics with gravity to downside.
        // Our app physics.
        Physics physics = new Physics(new Vector2(0, -10f));
        this.physics = physics;
        // When closing app physics must be disposed.
        // This will handle it for us.
        Engine.addDisposable(physics);

        // Now loading all physics.
        template.loadPhysicsBodies(physics);
        // creating all physics now.
        physics.flushLists();

        // Now we want camera to follow one of the balls.
        // For this we may use camera slider.
        // Camera mover to follow one of the balls.
        // We need it to be global too.
        this.cameraSlider = new CameraSlider();
    }

    @Override
    protected void onShow() {
        // Now let's make camera to follow our main entity.
        // First get entity.
        Entity main = getFormsTemplate().getEntity("Main");

        // Now let's follow it.
        // It must be done here after form is shown or else camera slider will be
        // dropped and not work.
        cameraSlider.followPoint(main.getPosition());
    }

    @Override
    protected void background() {
        super.background();
        physics.step(Engine.getDelta());
    }
}
