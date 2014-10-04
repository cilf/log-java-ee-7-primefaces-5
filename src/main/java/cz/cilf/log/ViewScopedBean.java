package cz.cilf.log;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ViewScopedBean implements Serializable {

    @Inject
    transient Logger logger;

    private int value = 0;

    @PostConstruct
    private void init() {
        logger.info("Constructing ViewScopedBean in {}", FacesContext.getCurrentInstance().getViewRoot().getViewId());
    }

    public void increaseValue() {
        value++;
        logger.info("increasing value to " + value);
    }

    public int getValue() {
        return value;
    }

}
