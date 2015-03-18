package views.beans;

import controllers.ControllerFactory;
import controlles.ejb.ControllerEjbFactory;

public class ViewBean {

    private ControllerFactory controllerFactory=null;

    public ControllerFactory getControllerFactory() {
        if(controllerFactory==null){
            controllerFactory= new ControllerEjbFactory();
        }
        return controllerFactory;
    }

    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }
}
