package views.beans;

public class LoginToRemoveTemaView {
    private String errorMsg;

    private String clave;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String process() {
        if (!this.getClave().equals("666")) {
            this.setErrorMsg("Error en la clave, intente de nuevo");
            return "loginToRemoveTema";
        } else {
            return "removeTema";
        }
    }

}
