package ru.andrei.advertisingstand.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 * Global exception handler
 */
public class CustomExceptionHandler extends ExceptionHandlerWrapper {
    private ExceptionHandler wrapped;
    private static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    public CustomExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    /**
     * When exception is thrown this method handles it
     * @throws FacesException exception
     */
    @Override
    public void handle() throws FacesException {
        Iterator iterator = getUnhandledExceptionQueuedEvents().iterator();

        while (iterator.hasNext()) {
            ExceptionQueuedEvent event = (ExceptionQueuedEvent) iterator.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
            Throwable throwable = context.getException();
            logger.error(throwable.getMessage(), throwable);

            FacesContext facesContext = FacesContext.getCurrentInstance();

            try {
                Flash flash = facesContext.getExternalContext().getFlash();
                flash.put("error", throwable.getMessage());
                flash.setRedirect(true);
                flash.setKeepMessages(true);
                NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
                navigationHandler.handleNavigation(facesContext, null,
                        "/error?faces-redirect=true");
                facesContext.renderResponse();
            } finally {
                iterator.remove();
            }
        }

        getWrapped().handle();
    }
}
