package controllers;

public abstract class ControllerFactory {
    public static ControllerFactory factory = null;

    public static void setFactory(ControllerFactory factory) {
        ControllerFactory.factory = factory;
    }

    public static ControllerFactory getFactory() {
        assert factory != null;
        return factory;
    }

    public abstract VotarController getVotarCotroller();

    public abstract VerVotacionesController getVerVotacionesController();

    public abstract NuevoTemaController getNuevoTemaController();

    public abstract EliminarTemaController getEliminarTemaController();

}
