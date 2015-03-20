package views.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
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
            try {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Clave incorrecto, intente de nuevo", ""));
            } catch (Exception e) {
            }
            return "loginToRemoveTema";
        } else {
            return "removeTema";
        }
    }

}
